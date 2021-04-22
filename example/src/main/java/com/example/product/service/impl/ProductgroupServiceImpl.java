package com.example.product.service.impl;

import com.example.product.entity.Productgroup;
import com.example.product.mapper.ProductgroupMapper;
import com.example.product.service.ProductgroupService;
import com.example.product.param.ProductgroupPageParam;
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
public class ProductgroupServiceImpl extends BaseServiceImpl<ProductgroupMapper, Productgroup> implements ProductgroupService {

    @Autowired
    private ProductgroupMapper productgroupMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveProductgroup(Productgroup productgroup) throws Exception {
        return super.save(productgroup);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProductgroup(Productgroup productgroup) throws Exception {
        return super.updateById(productgroup);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProductgroup(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<Productgroup> getProductgroupPageList(ProductgroupPageParam productgroupPageParam) throws Exception {
        Page<Productgroup> page = new PageInfo<>(productgroupPageParam);
        LambdaQueryWrapper<Productgroup> wrapper = new LambdaQueryWrapper<>();
        IPage<Productgroup> iPage = productgroupMapper.selectPage(page, wrapper);
        return new Paging<Productgroup>(iPage);
    }

}
