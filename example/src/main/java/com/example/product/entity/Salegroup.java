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
 * @since 2021-04-16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Salegroup对象")
public class Salegroup extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "saleGroupID不能为空", groups = {Update.class})
    @TableId(value = "saleGroupID", type = IdType.AUTO)
    private Integer salegroupid;

    @NotBlank(message = "不能为空")
    @TableField("saleGroupName")
    private String salegroupname;

}