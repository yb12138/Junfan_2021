package com.example.product.service.impl;

import com.example.product.entity.Product;
import com.example.product.entity.ProductCountry;
import com.example.product.mapper.ProductCountryMapper;
import com.example.product.service.ProductCountryService;
import com.example.product.param.ProductCountryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *  服务实现类
 *
 * @author yb
 * @since 2021-04-05
 */
@Slf4j
@Service
public class ProductCountryServiceImpl extends BaseServiceImpl<ProductCountryMapper, ProductCountry> implements ProductCountryService {

    @Autowired
    private ProductCountryMapper productCountryMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveProductCountry(ProductCountry productCountry) throws Exception {
        return super.save(productCountry);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProductCountry(ProductCountry productCountry) throws Exception {
        return super.updateById(productCountry);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProductCountry(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<ProductCountry> getProductCountryPageList(ProductCountryPageParam productCountryPageParam) throws Exception {
        Page<ProductCountry> page = new PageInfo<>(productCountryPageParam);
        LambdaQueryWrapper<ProductCountry> wrapper = new LambdaQueryWrapper<>();
        IPage<ProductCountry> iPage = productCountryMapper.selectPage(page, wrapper);
        return new Paging<ProductCountry>(iPage);
    }

    @Override
    public List<ProductCountry> getCountryList(Product product) {
        int pid = product.getProductID();
        List<ProductCountry> plist = (List<ProductCountry>) super.getById(pid);
        return plist;
    }

}
