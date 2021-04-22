package com.example.product.service;

import com.example.product.entity.ProductMotherCode;
import com.example.product.param.ProductMotherCodePageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-16
 */
public interface ProductMotherCodeService extends BaseService<ProductMotherCode> {

    /**
     * 保存
     *
     * @param productMotherCode
     * @return
     * @throws Exception
     */
    boolean saveProductMotherCode(ProductMotherCode productMotherCode) throws Exception;

    /**
     * 修改
     *
     * @param productMotherCode
     * @return
     * @throws Exception
     */
    boolean updateProductMotherCode(ProductMotherCode productMotherCode) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteProductMotherCode(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param productMotherCodeQueryParam
     * @return
     * @throws Exception
     */
    Paging<ProductMotherCode> getProductMotherCodePageList(ProductMotherCodePageParam productMotherCodePageParam) throws Exception;

}
