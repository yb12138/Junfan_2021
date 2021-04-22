package com.example.product.controller;

import com.example.product.entity.Warehouse;
import com.example.product.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import com.example.product.param.WarehousePageParam;
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
 * @since 2021-04-14
 */
@Slf4j
@RestController
@RequestMapping("/warehouse")
@Module("product")
@Api(value = "API", tags = {""})
public class WarehouseController extends BaseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addWarehouse(@Validated(Add.class) @RequestBody Warehouse warehouse) throws Exception {
        boolean flag = warehouseService.saveWarehouse(warehouse);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouse(@Validated(Update.class) @RequestBody Warehouse warehouse) throws Exception {
        boolean flag = warehouseService.updateWarehouse(warehouse);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteWarehouse(@PathVariable("id") Long id) throws Exception {
        boolean flag = warehouseService.deleteWarehouse(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = Warehouse.class)
    public ApiResult<Warehouse> getWarehouse(@PathVariable("id") Long id) throws Exception {
        Warehouse warehouse = warehouseService.getById(id);
        return ApiResult.ok(warehouse);
    }

    /**
     * 分页列表
     */
    @GetMapping("/list")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = Warehouse.class)
    public ApiResult<List<Warehouse>> getWarehousePageList() throws Exception {
        List<Warehouse> res = warehouseService.list();
        System.out.println(res.size() + "哈哈哈哈啊");
        return ApiResult.ok(res);
    }

}

