package com.example.product.controller;

import com.example.product.entity.ProductCountry;
import com.example.product.service.ProductCountryService;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.ProductCountryPageParam;
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
@RequestMapping("/productCountry")
@Module("product")
@Api(value = "API", tags = {""})
public class ProductCountryController extends BaseController {

    @Autowired
    private ProductCountryService productCountryService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addProductCountry(@Validated(Add.class) @RequestBody ProductCountry productCountry) throws Exception {
        boolean flag = productCountryService.saveProductCountry(productCountry);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateProductCountry(@Validated(Update.class) @RequestBody ProductCountry productCountry) throws Exception {
        boolean flag = productCountryService.updateProductCountry(productCountry);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteProductCountry(@PathVariable("id") Long id) throws Exception {
        boolean flag = productCountryService.deleteProductCountry(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = ProductCountry.class)
    public ApiResult<ProductCountry> getProductCountry(@PathVariable("id") Long id) throws Exception {
        ProductCountry productCountry = productCountryService.getById(id);
        return ApiResult.ok(productCountry);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = ProductCountry.class)
    public ApiResult<Paging<ProductCountry>> getProductCountryPageList(@Validated @RequestBody ProductCountryPageParam productCountryPageParam) throws Exception {
        Paging<ProductCountry> paging = productCountryService.getProductCountryPageList(productCountryPageParam);
        return ApiResult.ok(paging);
    }

}

