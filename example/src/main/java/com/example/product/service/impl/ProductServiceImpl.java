package com.example.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.product.entity.Product;
import com.example.product.entity.ProductCountry;
import com.example.product.entity.ProductCountryExample;
import com.example.product.entity.ProductSell;
import com.example.product.mapper.ProductCountryMapper;
import com.example.product.mapper.ProductMapper;
import com.example.product.mapper.ProductSellMapper;
import com.example.product.service.ProductService;
import com.example.product.param.ProductPageParam;
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
 * @since 2021-03-22
 */
@Slf4j
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSellMapper productSellMapper;
    @Autowired
    private ProductCountryMapper productCountryMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveProduct(Product product,List<ProductCountry> productCountries, ProductSell productSell) throws Exception {
        int id = product.getProductID();
        for(ProductCountry productCountry : productCountries) {
            productCountry.setPcID(id);
            productCountryMapper.insert(productCountry);
        }
        productSell.setProductID(id);
        productSellMapper.insert(productSell);
        /*
        * 生成补货信息
        * */

        return super.save(product);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProduct(Product product,List<ProductCountry> productCountries, ProductSell productSell) throws Exception {
        int pid = product.getProductID();
        for(ProductCountry productCountry : productCountries){
            if(productCountry.getPcID() != null){
               productCountryMapper.updateById(productCountry);
            }else{
                //如果没有主键id,则检查该产品是否有国家，若没有则新增
                QueryWrapper<ProductCountry> queryWrapper = new QueryWrapper<>();
                queryWrapper = queryWrapper.eq("productID",product.getProductID()).eq("countryCode",productCountry.getCountryCode());
                List<ProductCountry> countries = productCountryMapper.selectList(queryWrapper);
                if(countries == null || countries.size() == 0) {
                    productCountry.setProductID(product.getProductID());
                    productCountryMapper.insert(productCountry);
                } else {
                    productCountryMapper.delete(queryWrapper);
                    productCountryMapper.insert(productCountry);
                }
            }
        }
        productSellMapper.updateById(productSell);
        return super.updateById(product);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProduct(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<Product> getProductPageList(ProductPageParam productPageParam) throws Exception {
        Page<Product> page = new PageInfo<>(productPageParam);
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        IPage<Product> iPage = productMapper.selectPage(page, wrapper);
        return new Paging<Product>(iPage);
    }

}
