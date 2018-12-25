/**
 * @projectName boot
 */
package com.xcl.bean;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类
 * @description bean
 * @author  auto
 * @date 2018-12-25 14:04
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("实体类")
public class TYh implements Serializable{

    /**
     * serialVersionUID
     */
	private static final long serialVersionUID = 1L;

    
    /** 编号 */
    @ApiModelProperty("编号 ")
    private String cbh;
    
    /** 姓名 */
    @ApiModelProperty("姓名 ")
    private String cxm;
    
    /** 性别 */
    @ApiModelProperty("性别 ")
    private Integer nxb;
    
    /** 年龄 */
    @ApiModelProperty("年龄 ")
    private Date dcsrq;
    
    /** 详细地址 */
    @ApiModelProperty("详细地址 ")
    private String cxxdz;
    
    /** 状态 */
    @ApiModelProperty("状态 ")
    private Integer nzt;
    
    /** 插入时间 */
    @ApiModelProperty("插入时间 ")
    private Date dcrsj;
    
    /** 更新时间 */
    @ApiModelProperty("更新时间 ")
    private Date dgxsj;
    
    /** 账号 */
    @ApiModelProperty("账号 ")
    private String czh;
    
    /** 密码 */
    @ApiModelProperty("密码 ")
    private String cmm;
}