package com.xcl.druid;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;


@WebServlet(urlPatterns = "/druid/*", initParams={  
    @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)  
    @WebInitParam(name="deny",value=""),// IP黑名单 (存在共同时，deny优先于allow)  
    @WebInitParam(name="loginUsername",value="xcllin"),// 用户名  
    @WebInitParam(name="loginPassword",value="123456"),// 密码  
    @WebInitParam(name="resetEnable",value="true")// 禁用HTML页面上的“Reset All”功能  
}) 
/**
 * 
 * @author xiangchunlin
 * @description 监控视图配置
 * @date 2018年12月4日
 * @version 1.0.0
 */
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 2359758657306626394L;
}
 


