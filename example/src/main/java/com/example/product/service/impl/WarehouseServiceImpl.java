package com.example.product.service.impl;

import com.example.product.entity.Warehouse;
import com.example.product.mapper.WarehouseMapper;
import com.example.product.service.WarehouseService;
import com.example.product.param.WarehousePageParam;
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
 * @since 2021-04-14
 */
@Slf4j
@Service
public class WarehouseServiceImpl extends BaseServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveWarehouse(Warehouse warehouse) throws Exception {
        return super.save(warehouse);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateWarehouse(Warehouse warehouse) throws Exception {
        return super.updateById(warehouse);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWarehouse(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<Warehouse> getWarehousePageList(WarehousePageParam warehousePageParam) throws Exception {
        Page<Warehouse> page = new PageInfo<>(warehousePageParam);
        LambdaQueryWrapper<Warehouse> wrapper = new LambdaQueryWrapper<>();
        IPage<Warehouse> iPage = warehouseMapper.selectPage(page, wrapper);
        return new Paging<Warehouse>(iPage);
    }

}
