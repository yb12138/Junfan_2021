package com.example.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Accessors(chain = true)
public class Productappend {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "productID不能为空", groups = {Update.class})
    @TableId(value = "productID", type = IdType.AUTO)
    private Integer productID;

    @NotBlank(message = "不能为空")
    @TableField("skuCode")
    private String skuCode;

    @NotBlank(message = "不能为空")
    @TableField("cnName")
    private String cnName;

    @NotBlank(message = "不能为空")
    @TableField("enName")
    private String enName;

    @TableField("registeredLength")
    private Double registeredLength;

    @TableField("registeredWidth")
    private Double registeredWidth;

    @TableField("registeredHeight")
    private Double registeredHeight;

    private String branded;

    @TableField("brandedName")
    private String brandedName;

    @TableField("displayPageUrl")
    private String displayPageUrl;

    private String remark;

    @TableField("inportDeclaredvalue")
    private String inportDeclaredvalue;

    @TableField("exportDeclaredvalue")
    private String exportDeclaredvalue;

    private String battery;

    @TableField("registeredWeight")
    private Double registeredWeight;

    @TableField("isNew")
    private String isNew;

    @NotNull(message = "不能为空")
    @TableField("warehouseID")
    private Long warehouseID;

    @NotBlank(message = "不能为空")
    @TableField("warehouseName")
    private String warehouseName;

    @TableField("headwayType")
    private String headwayType;

    private String productlevel;

    @TableField("salegroupID")
    private Integer salegroupID;

    @TableField("salegroupName")
    private String salegroupName;

    @TableField("productgroupID")
    private Integer productgroupID;

    @TableField("productgroupName")
    private String productgroupName;

    @TableField("isActive")
    private String isActive;

    @TableField("isDelete")
    private String isDelete;

    @TableField("isPlus")
    private String isPlus;

    @TableField("registeredVolume")
    private Double registeredVolume;

    private String imgurl;

    private Double cost;

    private Integer mid;

    private String mcode;

    @NotNull(message = "不能为空")
    @TableField("supplierID")
    private Integer supplierID;

    @NotBlank(message = "不能为空")
    @TableField("supplierName")
    private String supplierName;

    private String supplierlink1;

    private String supplierlink2;

    private String supplierlink3;

    @NotNull(message = "不能为空")
    private Integer deliverytime;

    private  ProductSell productSell;
    private List<ProductCountry> countryList;
}
