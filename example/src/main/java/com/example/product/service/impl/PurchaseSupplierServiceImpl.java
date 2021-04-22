package com.example.product.service.impl;

import com.example.product.entity.PurchaseSupplier;
import com.example.product.mapper.PurchaseSupplierMapper;
import com.example.product.service.PurchaseSupplierService;
import com.example.product.param.PurchaseSupplierPageParam;
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
public class PurchaseSupplierServiceImpl extends BaseServiceImpl<PurchaseSupplierMapper, PurchaseSupplier> implements PurchaseSupplierService {

    @Autowired
    private PurchaseSupplierMapper purchaseSupplierMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean savePurchaseSupplier(PurchaseSupplier purchaseSupplier) throws Exception {
        return super.save(purchaseSupplier);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePurchaseSupplier(PurchaseSupplier purchaseSupplier) throws Exception {
        return super.updateById(purchaseSupplier);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deletePurchaseSupplier(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<PurchaseSupplier> getPurchaseSupplierPageList(PurchaseSupplierPageParam purchaseSupplierPageParam) throws Exception {
        Page<PurchaseSupplier> page = new PageInfo<>(purchaseSupplierPageParam);
        LambdaQueryWrapper<PurchaseSupplier> wrapper = new LambdaQueryWrapper<>();
        IPage<PurchaseSupplier> iPage = purchaseSupplierMapper.selectPage(page, wrapper);
        return new Paging<PurchaseSupplier>(iPage);
    }

}
