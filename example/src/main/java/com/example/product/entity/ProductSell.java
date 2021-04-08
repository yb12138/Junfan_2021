package com.example.product.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;

/**
 * 
 *
 * @author yb
 * @since 2021-04-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductSell对象")
public class ProductSell extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "不能为空")
    @TableId(value = "productID", type = IdType.AUTO)
    private Integer productID;

    private Double month1;

    private Double month2;

    private Double month3;

    private Double month4;

    private Double month5;

    private Double month6;

    private Double month7;

    private Double month8;

    private Double month9;

    private Double month10;

    private Double month11;

    private Double month12;

}
