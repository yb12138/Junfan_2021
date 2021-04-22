package com.example.product.controller;

import com.example.product.entity.Productgroup;
import com.example.product.service.ProductgroupService;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.ProductgroupPageParam;
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

import java.util.List;

/**
 *  控制器
 *
 * @author yb
 * @since 2021-04-16
 */
@Slf4j
@RestController
@RequestMapping("/productgroup")
@Module("product")
@Api(value = "API", tags = {""})
public class ProductgroupController extends BaseController {

    @Autowired
    private ProductgroupService productgroupService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addProductgroup(@Validated(Add.class) @RequestBody Productgroup productgroup) throws Exception {
        boolean flag = productgroupService.saveProductgroup(productgroup);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateProductgroup(@Validated(Update.class) @RequestBody Productgroup productgroup) throws Exception {
        boolean flag = productgroupService.updateProductgroup(productgroup);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteProductgroup(@PathVariable("id") Long id) throws Exception {
        boolean flag = productgroupService.deleteProductgroup(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = Productgroup.class)
    public ApiResult<Productgroup> getProductgroup(@PathVariable("id") Long id) throws Exception {
        Productgroup productgroup = productgroupService.getById(id);
        return ApiResult.ok(productgroup);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = Productgroup.class)
    public ApiResult<Paging<Productgroup>> getProductgroupPageList(@Validated @RequestBody ProductgroupPageParam productgroupPageParam) throws Exception {
        Paging<Productgroup> paging = productgroupService.getProductgroupPageList(productgroupPageParam);
        return ApiResult.ok(paging);
    }
    @GetMapping("/list")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = Productgroup.class)
    public ApiResult<List<Productgroup>> getProductgroupPageList() throws Exception {
        List<Productgroup> paging = productgroupService.list();
        return ApiResult.ok(paging);
    }

}

