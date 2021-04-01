package com.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.product.entity.Product;
import com.example.product.param.ProductPageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 *  Mapper 接口
 *
 * @author yb
 * @since 2021-03-22
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {


}
