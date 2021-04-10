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

import java.util.List;

/**
 * 
 *
 * @author yb
 * @since 2021-03-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Product对象")
public class Product extends BaseEntity {
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

    public Product(Productappend productappend) {
        this.productID = productappend.getProductID();
        this.skuCode  = productappend.getSkuCode();
        this.cnName = productappend.getCnName();
        this.enName = productappend.getEnName();
        this.registeredLength = productappend.getRegisteredLength();
        this.registeredWidth = productappend.getRegisteredWidth();
        this.registeredHeight = productappend.getRegisteredHeight();
        this.branded = productappend.getBranded();
        this.brandedName = productappend.getBrandedName();
        this.displayPageUrl = productappend.getDisplayPageUrl();
        this.remark = productappend.getRemark();
        this.inportDeclaredvalue = productappend.getInportDeclaredvalue();
        this.exportDeclaredvalue = productappend.getExportDeclaredvalue();
        this.battery = productappend.getBattery();
        this.registeredWeight = productappend.getRegisteredWeight();
        this.isNew = productappend.getIsNew();
        this.warehouseID = productappend.getWarehouseID();
        this.warehouseName = productappend.getWarehouseName();
        this.headwayType = productappend.getHeadwayType();
        this.productlevel = productappend.getProductlevel();
        this.salegroupID = productappend.getSalegroupID();
        this.salegroupName = productappend.getSalegroupName();
        this.productgroupID = productappend.getProductgroupID();
        this.productgroupName = productappend.getProductgroupName();
        this.isActive = productappend.getIsActive();
        this.isDelete = productappend.getIsDelete();
        this.isPlus = productappend.getIsPlus();
        this.registeredVolume = productappend.getRegisteredVolume();
        this.imgurl = productappend.getImgurl();
        this.cost = productappend.getCost();
        this.mid = productappend.getMid();
        this.mcode = productappend.getMcode();
        this.supplierID = productappend.getSupplierID();
        this.supplierName = productappend.getSupplierName();
        this.supplierlink1 = productappend.getSupplierlink1();
        this.supplierlink2 = productappend.getSupplierlink2();
        this.supplierlink3 = productappend.getSupplierlink3();
        this.deliverytime = productappend.getDeliverytime();
    }

    public Product() {
    }
}
