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
 * @since 2021-04-16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductMotherCode对象")
public class ProductMotherCode extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "mid不能为空", groups = {Update.class})
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    @NotBlank(message = "不能为空")
    private String mname;

}
