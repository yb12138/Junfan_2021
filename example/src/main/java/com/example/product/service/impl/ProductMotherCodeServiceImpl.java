package com.example.product.service.impl;

import com.example.product.entity.ProductMotherCode;
import com.example.product.mapper.ProductMotherCodeMapper;
import com.example.product.service.ProductMotherCodeService;
import com.example.product.param.ProductMotherCodePageParam;
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
 * @since 2021-04-16
 */
@Slf4j
@Service
public class ProductMotherCodeServiceImpl extends BaseServiceImpl<ProductMotherCodeMapper, ProductMotherCode> implements ProductMotherCodeService {

    @Autowired
    private ProductMotherCodeMapper productMotherCodeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveProductMotherCode(ProductMotherCode productMotherCode) throws Exception {
        return super.save(productMotherCode);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProductMotherCode(ProductMotherCode productMotherCode) throws Exception {
        return super.updateById(productMotherCode);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProductMotherCode(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<ProductMotherCode> getProductMotherCodePageList(ProductMotherCodePageParam productMotherCodePageParam) throws Exception {
        Page<ProductMotherCode> page = new PageInfo<>(productMotherCodePageParam);
        LambdaQueryWrapper<ProductMotherCode> wrapper = new LambdaQueryWrapper<>();
        IPage<ProductMotherCode> iPage = productMotherCodeMapper.selectPage(page, wrapper);
        return new Paging<ProductMotherCode>(iPage);
    }

}
