package com.example.product.service;

import com.example.product.entity.PurchaseSupplier;
import com.example.product.param.PurchaseSupplierPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-16
 */
public interface PurchaseSupplierService extends BaseService<PurchaseSupplier> {

    /**
     * 保存
     *
     * @param purchaseSupplier
     * @return
     * @throws Exception
     */
    boolean savePurchaseSupplier(PurchaseSupplier purchaseSupplier) throws Exception;

    /**
     * 修改
     *
     * @param purchaseSupplier
     * @return
     * @throws Exception
     */
    boolean updatePurchaseSupplier(PurchaseSupplier purchaseSupplier) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deletePurchaseSupplier(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param purchaseSupplierQueryParam
     * @return
     * @throws Exception
     */
    Paging<PurchaseSupplier> getPurchaseSupplierPageList(PurchaseSupplierPageParam purchaseSupplierPageParam) throws Exception;

}
