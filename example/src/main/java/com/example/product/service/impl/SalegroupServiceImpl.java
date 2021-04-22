package com.example.product.service.impl;

import com.example.product.entity.Salegroup;
import com.example.product.mapper.SalegroupMapper;
import com.example.product.service.SalegroupService;
import com.example.product.param.SalegroupPageParam;
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
public class SalegroupServiceImpl extends BaseServiceImpl<SalegroupMapper, Salegroup> implements SalegroupService {

    @Autowired
    private SalegroupMapper salegroupMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSalegroup(Salegroup salegroup) throws Exception {
        return super.save(salegroup);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateSalegroup(Salegroup salegroup) throws Exception {
        return super.updateById(salegroup);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSalegroup(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<Salegroup> getSalegroupPageList(SalegroupPageParam salegroupPageParam) throws Exception {
        Page<Salegroup> page = new PageInfo<>(salegroupPageParam);
        LambdaQueryWrapper<Salegroup> wrapper = new LambdaQueryWrapper<>();
        IPage<Salegroup> iPage = salegroupMapper.selectPage(page, wrapper);
        return new Paging<Salegroup>(iPage);
    }

}
