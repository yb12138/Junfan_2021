package com.example.product.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @since 2021-04-16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PurchaseSupplier对象")
public class PurchaseSupplier extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "supplierID不能为空", groups = {Update.class})
    @TableId(value = "supplierID", type = IdType.AUTO)
    private Integer supplierID;

    @NotBlank(message = "不能为空")
    @TableField("supplierName")
    private String supplierName;

    private String linkperson;

    private String linkphone;

    private String linkurl;

    @NotNull(message = "不能为空")
    private Integer status;

    @NotNull(message = "不能为空")
    @TableField("createID")
    private Integer createID;

    @NotNull(message = "不能为空")
    @TableField("createTime")
    private Date createTime;

    @NotNull(message = "不能为空")
    @TableField("updateTime")
    private Date updateTime;

    @NotBlank(message = "不能为空")
    @TableField("createName")
    private String createName;

}
