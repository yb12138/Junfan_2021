package com.example.product.controller;

import com.example.product.entity.Salegroup;
import com.example.product.service.SalegroupService;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.SalegroupPageParam;
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
@RequestMapping("/salegroup")
@Module("product")
@Api(value = "API", tags = {""})
public class SalegroupController extends BaseController {

    @Autowired
    private SalegroupService salegroupService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addSalegroup(@Validated(Add.class) @RequestBody Salegroup salegroup) throws Exception {
        boolean flag = salegroupService.saveSalegroup(salegroup);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateSalegroup(@Validated(Update.class) @RequestBody Salegroup salegroup) throws Exception {
        boolean flag = salegroupService.updateSalegroup(salegroup);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteSalegroup(@PathVariable("id") Long id) throws Exception {
        boolean flag = salegroupService.deleteSalegroup(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = Salegroup.class)
    public ApiResult<Salegroup> getSalegroup(@PathVariable("id") Long id) throws Exception {
        Salegroup salegroup = salegroupService.getById(id);
        return ApiResult.ok(salegroup);
    }

    /**
     * 分页列表
     */
    @GetMapping("/list")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = Salegroup.class)
    public ApiResult<List<Salegroup>> getSalegroupPageList() throws Exception {
        List<Salegroup> paging = salegroupService.list();
        return ApiResult.ok(paging);
    }

}

