package com.example.product.service;

import com.example.product.entity.ProductCountry;
import com.example.product.param.ProductCountryPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author yb
 * @since 2021-04-05
 */
public interface ProductCountryService extends BaseService<ProductCountry> {

    /**
     * 保存
     *
     * @param productCountry
     * @return
     * @throws Exception
     */
    boolean saveProductCountry(ProductCountry productCountry) throws Exception;

    /**
     * 修改
     *
     * @param productCountry
     * @return
     * @throws Exception
     */
    boolean updateProductCountry(ProductCountry productCountry) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteProductCountry(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param productCountryQueryParam
     * @return
     * @throws Exception
     */
    Paging<ProductCountry> getProductCountryPageList(ProductCountryPageParam productCountryPageParam) throws Exception;

}
