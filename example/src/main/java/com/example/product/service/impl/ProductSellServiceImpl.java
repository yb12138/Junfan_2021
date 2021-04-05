package com.example.product.service.impl;

import com.example.product.entity.ProductSell;
import com.example.product.mapper.ProductSellMapper;
import com.example.product.service.ProductSellService;
import com.example.product.param.ProductSellPageParam;
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

/**
 *  服务实现类
 *
 * @author yb
 * @since 2021-04-05
 */
@Slf4j
@Service
public class ProductSellServiceImpl extends BaseServiceImpl<ProductSellMapper, ProductSell> implements ProductSellService {

    @Autowired
    private ProductSellMapper productSellMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveProductSell(ProductSell productSell) throws Exception {
        return super.save(productSell);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProductSell(ProductSell productSell) throws Exception {
        return super.updateById(productSell);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProductSell(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<ProductSell> getProductSellPageList(ProductSellPageParam productSellPageParam) throws Exception {
        Page<ProductSell> page = new PageInfo<>(productSellPageParam, OrderItem.desc(getLambdaColumn(ProductSell::getCreateTime)));
        LambdaQueryWrapper<ProductSell> wrapper = new LambdaQueryWrapper<>();
        IPage<ProductSell> iPage = productSellMapper.selectPage(page, wrapper);
        return new Paging<ProductSell>(iPage);
    }

}
