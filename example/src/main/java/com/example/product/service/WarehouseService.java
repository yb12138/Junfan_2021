package com.example.product.service;

import com.example.product.entity.Warehouse;
import com.example.product.param.WarehousePageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-14
 */
public interface WarehouseService extends BaseService<Warehouse> {

    /**
     * 保存
     *
     * @param warehouse
     * @return
     * @throws Exception
     */
    boolean saveWarehouse(Warehouse warehouse) throws Exception;

    /**
     * 修改
     *
     * @param warehouse
     * @return
     * @throws Exception
     */
    boolean updateWarehouse(Warehouse warehouse) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteWarehouse(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param warehouseQueryParam
     * @return
     * @throws Exception
     */
    Paging<Warehouse> getWarehousePageList(WarehousePageParam warehousePageParam) throws Exception;

}
