package com.example.product.service;

import com.example.product.entity.ProductSell;
import com.example.product.param.ProductSellPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-05
 */
public interface ProductSellService extends BaseService<ProductSell> {

    /**
     * 保存
     *
     * @param productSell
     * @return
     * @throws Exception
     */
    boolean saveProductSell(ProductSell productSell) throws Exception;

    /**
     * 修改
     *
     * @param productSell
     * @return
     * @throws Exception
     */
    boolean updateProductSell(ProductSell productSell) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteProductSell(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param productSellQueryParam
     * @return
     * @throws Exception
     */
    Paging<ProductSell> getProductSellPageList(ProductSellPageParam productSellPageParam) throws Exception;

}
