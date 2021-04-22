package com.example.product.controller;

import com.example.product.entity.PurchaseSupplier;
import com.example.product.service.PurchaseSupplierService;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.PurchaseSupplierPageParam;
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
@RequestMapping("/supplier")
@Module("product")
@Api(value = "API", tags = {""})
public class PurchaseSupplierController extends BaseController {

    @Autowired
    private PurchaseSupplierService purchaseSupplierService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addPurchaseSupplier(@Validated(Add.class) @RequestBody PurchaseSupplier purchaseSupplier) throws Exception {
        boolean flag = purchaseSupplierService.savePurchaseSupplier(purchaseSupplier);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updatePurchaseSupplier(@Validated(Update.class) @RequestBody PurchaseSupplier purchaseSupplier) throws Exception {
        boolean flag = purchaseSupplierService.updatePurchaseSupplier(purchaseSupplier);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deletePurchaseSupplier(@PathVariable("id") Long id) throws Exception {
        boolean flag = purchaseSupplierService.deletePurchaseSupplier(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = PurchaseSupplier.class)
    public ApiResult<PurchaseSupplier> getPurchaseSupplier(@PathVariable("id") Long id) throws Exception {
        PurchaseSupplier purchaseSupplier = purchaseSupplierService.getById(id);
        return ApiResult.ok(purchaseSupplier);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = PurchaseSupplier.class)
    public ApiResult<Paging<PurchaseSupplier>> getPurchaseSupplierPageList(@Validated @RequestBody PurchaseSupplierPageParam purchaseSupplierPageParam) throws Exception {
        Paging<PurchaseSupplier> paging = purchaseSupplierService.getPurchaseSupplierPageList(purchaseSupplierPageParam);
        return ApiResult.ok(paging);
    }
    @GetMapping("/list")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = PurchaseSupplier.class)
    public ApiResult<List<PurchaseSupplier>> getList() throws Exception {
        List<PurchaseSupplier> paging = purchaseSupplierService.list();
        return ApiResult.ok(paging);
    }
}

