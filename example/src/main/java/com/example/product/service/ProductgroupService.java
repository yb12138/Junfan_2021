package com.example.product.service;

import com.example.product.entity.Productgroup;
import com.example.product.param.ProductgroupPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-16
 */
public interface ProductgroupService extends BaseService<Productgroup> {

    /**
     * 保存
     *
     * @param productgroup
     * @return
     * @throws Exception
     */
    boolean saveProductgroup(Productgroup productgroup) throws Exception;

    /**
     * 修改
     *
     * @param productgroup
     * @return
     * @throws Exception
     */
    boolean updateProductgroup(Productgroup productgroup) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteProductgroup(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param productgroupQueryParam
     * @return
     * @throws Exception
     */
    Paging<Productgroup> getProductgroupPageList(ProductgroupPageParam productgroupPageParam) throws Exception;

}
