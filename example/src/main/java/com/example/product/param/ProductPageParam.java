package com.example.product.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.geekidea.springbootplus.framework.core.pagination.BasePageOrderParam;

/**
 * <pre>
 *  分页参数对象
 * </pre>
 *
 * @author yb
 * @date 2021-03-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页参数")
public class ProductPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
    private  String sku;
    private  String name;
    private Long warehouseid;
}
