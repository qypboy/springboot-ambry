package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict_item")
public class SysDictItem extends BaseEntity {
    private String dictCode;
    private String itemValue;
    private String itemLabel;
    private Integer sort;
    private Integer status;
    private String remark;
}
