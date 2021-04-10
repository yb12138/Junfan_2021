package com.example.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.product.entity.Product;
import com.example.product.entity.ProductCountry;
import com.example.product.entity.ProductSell;
import com.example.product.entity.Productappend;
import com.example.product.mapper.ProductMapper;
import com.example.product.service.ProductCountryService;
import com.example.product.service.ProductService;
import io.geekidea.springbootplus.framework.common.api.ApiCode;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.ProductPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.common.param.IdParam;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  控制器
 *
 * @author yb
 * @since 2021-03-22
 */
@Slf4j
@RestController
@RequestMapping("/product")
@Module("product")
@Api(value = "API", tags = {""})
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCountryService productCountryService;
    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addProduct(@Validated(Add.class) @RequestBody Productappend productappend) throws Exception {
        Integer id = productappend.getProductID();
        Product product = new Product(productappend);
        List<ProductCountry> productCountries = productappend.getCountryList();
        if(productCountries == null || productCountries.size() == 0)
            return ApiResult.fail(ApiCode.E_90003);
        if(product.getWarehouseID() == 0)
            return ApiResult.fail(ApiCode.E_100016);
        if(product.getCost() == null)
            return ApiResult.fail(ApiCode.E_100017);
        if(productCountryService.getById(id) != null)
            return ApiResult.fail(ApiCode.E_100012);
        product.setIsNew("Y");
        if (product.getBranded() == null || product.getBranded().equals("")) {
            product.setBranded("N");
        }
        if (product.getBattery() == null || product.getBattery().equals("")) {
            product.setBattery("N");
        }
        if (product.getIsPlus() == null || product.getIsPlus().equals("")) {
            product.setIsPlus("N");
        }
        ProductSell productSell = productappend.getProductSell();
        boolean flag = productService.saveProduct(product,productCountries,productSell);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateProduct(@Validated(Update.class) @RequestBody Productappend productappend) throws Exception {
        List<ProductCountry> productCountries = productappend.getCountryList();
        ProductSell productSell = productappend.getProductSell();
        Product product = new Product(productappend);
        if(product.getWarehouseID() == 0)
            product.setWarehouseID(null);
        if(product.getCost() == null)
            return ApiResult.fail(ApiCode.E_100017);
        boolean flag = productService.updateProduct(product,productCountries,productSell);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteProduct(@PathVariable("id") Long id) throws Exception {
        /*
        * 查询采购
        * */


        boolean flag = productService.deleteProduct(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = Product.class)
    public ApiResult<Product> getProduct(@PathVariable("id") Long id) throws Exception {
        Product product = productService.getById(id);
        return ApiResult.ok(product);
    }

    /**
     * 分页列表
     */
    @PostMapping("/list")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = Product.class)
    public ApiResult<Paging<Product>> getProductPageList(@Validated @RequestBody ProductPageParam productPageParam) throws Exception {
        Page<Product> productPage = new PageInfo<Product>();
        LambdaQueryWrapper<Product> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String sku = productPageParam.getSku();
        String name = productPageParam.getName();
        Long warehouseid = productPageParam.getWarehouseid();
        if(StringUtils.isNotBlank(sku)){
            lambdaQueryWrapper.like(Product::getSkuCode,sku);
        }
        if(StringUtils.isNotBlank(name)){
            lambdaQueryWrapper.like(Product::getCnName,name);
        }
        if(warehouseid != null){
            lambdaQueryWrapper.eq(Product::getWarehouseID,warehouseid);
        }
        IPage<Product> iPage = productMapper.selectPage(productPage,lambdaQueryWrapper);
        return ApiResult.ok(new Paging<>(iPage));
    }

}

