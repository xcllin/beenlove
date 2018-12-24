package com.xcl.bean;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 实体类
 * author: create by template
 * Company: xcl
 * date:2018-12-03 15:03
 */
@Getter
@Setter
@NoArgsConstructor
public class TYh {

    
    /** 编号 */
    private String cbh;
    
    /** 姓名 */
    private String cxm;
    
    /** 性别 */
    private Integer nxb;
    
    /** 年龄 */
    private Date dcsrq;
    
    /** 详细地址 */
    private String cxxdz;
    
    /** 状态 */
    private Integer nzt;
    
    /** 插入时间 */
    private Date dcrsj;
    
    /** 更新时间 */
    private Date dgxsj;
    
    /** 账号 */
    private String czh;
    
    /** 密码 */
    private String cmm;
}