package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.param.ProductPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-03-22
 */
public interface ProductService extends BaseService<Product> {

    /**
     * 保存
     *
     * @param product
     * @return
     * @throws Exception
     */
    boolean saveProduct(Product product) throws Exception;

    /**
     * 修改
     *
     * @param product
     * @return
     * @throws Exception
     */
    boolean updateProduct(Product product) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteProduct(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param productQueryParam
     * @return
     * @throws Exception
     */
    Paging<Product> getProductPageList(ProductPageParam productPageParam) throws Exception;

}
