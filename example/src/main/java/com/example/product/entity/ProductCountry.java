package com.example.product.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "ProductCountry对象")
public class ProductCountry extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "pcID不能为空", groups = {Update.class})
    @TableId(value = "pcID", type = IdType.AUTO)
    private Integer pcID;

    @NotNull(message = "不能为空")
    @TableField("productID")
    private Integer productID;

    @NotBlank(message = "不能为空")
    @TableField("countryCode")
    private String countryCode;

    private Double productlength;

    private Double productwidth;

    private Double productheight;

    @TableField("importPrice")
    private Double importPrice;

    @TableField("exportPrice")
    private Double exportPrice;

    private Double volume;

    private Double weight;

    @TableField("isNew")
    private String isNew;

    @TableField("rebateRate")
    private Double rebateRate;

    @TableField("importRate")
    private Double importRate;

}
