package com.example.product.controller;

import com.example.product.entity.ProductSell;
import com.example.product.service.ProductSellService;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.ProductSellPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.common.param.IdParam;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  控制器
 *
 * @author yb
 * @since 2021-04-05
 */
@Slf4j
@RestController
@RequestMapping("/productSell")
@Module("product")
@Api(value = "API", tags = {""})
public class ProductSellController extends BaseController {

    @Autowired
    private ProductSellService productSellService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addProductSell(@Validated(Add.class) @RequestBody ProductSell productSell) throws Exception {
        boolean flag = productSellService.saveProductSell(productSell);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateProductSell(@Validated(Update.class) @RequestBody ProductSell productSell) throws Exception {
        boolean flag = productSellService.updateProductSell(productSell);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteProductSell(@PathVariable("id") Long id) throws Exception {
        boolean flag = productSellService.deleteProductSell(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = ProductSell.class)
    public ApiResult<ProductSell> getProductSell(@PathVariable("id") Long id) throws Exception {
        ProductSell productSell = productSellService.getById(id);
        return ApiResult.ok(productSell);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = ProductSell.class)
    public ApiResult<Paging<ProductSell>> getProductSellPageList(@Validated @RequestBody ProductSellPageParam productSellPageParam) throws Exception {
        Paging<ProductSell> paging = productSellService.getProductSellPageList(productSellPageParam);
        return ApiResult.ok(paging);
    }

}

