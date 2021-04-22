package com.example.product.service;

import com.example.product.entity.Salegroup;
import com.example.product.param.SalegroupPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-16
 */
public interface SalegroupService extends BaseService<Salegroup> {

    /**
     * 保存
     *
     * @param salegroup
     * @return
     * @throws Exception
     */
    boolean saveSalegroup(Salegroup salegroup) throws Exception;

    /**
     * 修改
     *
     * @param salegroup
     * @return
     * @throws Exception
     */
    boolean updateSalegroup(Salegroup salegroup) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteSalegroup(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param salegroupQueryParam
     * @return
     * @throws Exception
     */
    Paging<Salegroup> getSalegroupPageList(SalegroupPageParam salegroupPageParam) throws Exception;

}
