package com.xcl.bean;

import java.util.Date;

/**
 * 实体类
 * author: create by template
 * Company: xcl
 * date:2018-12-03 15:03
 */
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

    /**
     * 获取编号的值
     * @return cbh 
     */
    public String getcbh(){
        return cbh;
    }

    /**
     * 设置属性 编号的值
     * @param cbh 
     */
    public void setcbh(String cbh){
        this.cbh = cbh;
    }
    /**
     * 获取姓名的值
     * @return cxm 
     */
    public String getcxm(){
        return cxm;
    }

    /**
     * 设置属性 姓名的值
     * @param cxm 
     */
    public void setcxm(String cxm){
        this.cxm = cxm;
    }
    /**
     * 获取性别的值
     * @return nxb 
     */
    public Integer getnxb(){
        return nxb;
    }

    /**
     * 设置属性 性别的值
     * @param nxb 
     */
    public void setnxb(Integer nxb){
        this.nxb = nxb;
    }
    /**
     * 获取年龄的值
     * @return dcsrq 
     */
    public Date getdcsrq(){
        return dcsrq;
    }

    /**
     * 设置属性 年龄的值
     * @param dcsrq 
     */
    public void setdcsrq(Date dcsrq){
        this.dcsrq = dcsrq;
    }
    /**
     * 获取详细地址的值
     * @return cxxdz 
     */
    public String getcxxdz(){
        return cxxdz;
    }

    /**
     * 设置属性 详细地址的值
     * @param cxxdz 
     */
    public void setcxxdz(String cxxdz){
        this.cxxdz = cxxdz;
    }
    /**
     * 获取状态的值
     * @return nzt 
     */
    public Integer getnzt(){
        return nzt;
    }

    /**
     * 设置属性 状态的值
     * @param nzt 
     */
    public void setnzt(Integer nzt){
        this.nzt = nzt;
    }
    /**
     * 获取插入时间的值
     * @return dcrsj 
     */
    public Date getdcrsj(){
        return dcrsj;
    }

    /**
     * 设置属性 插入时间的值
     * @param dcrsj 
     */
    public void setdcrsj(Date dcrsj){
        this.dcrsj = dcrsj;
    }
    /**
     * 获取更新时间的值
     * @return dgxsj 
     */
    public Date getdgxsj(){
        return dgxsj;
    }

    /**
     * 设置属性 更新时间的值
     * @param dgxsj 
     */
    public void setdgxsj(Date dgxsj){
        this.dgxsj = dgxsj;
    }
    /**
     * 获取账号的值
     * @return czh 
     */
    public String getczh(){
        return czh;
    }

    /**
     * 设置属性 账号的值
     * @param czh 
     */
    public void setczh(String czh){
        this.czh = czh;
    }
    /**
     * 获取密码的值
     * @return cmm 
     */
    public String getcmm(){
        return cmm;
    }

    /**
     * 设置属性 密码的值
     * @param cmm 
     */
    public void setcmm(String cmm){
        this.cmm = cmm;
    }

}