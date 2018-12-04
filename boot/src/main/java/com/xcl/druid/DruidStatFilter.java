package com.xcl.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName="druidWebStatFilter",  
urlPatterns="/*",  
initParams={  
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源  
})
/**
 * 
 * @author xiangchunlin
 * @description 过滤不需要监控的后缀
 * @date 2018年12月4日
 * @version 1.0.0
 */
public class DruidStatFilter extends WebStatFilter {
	
}
 


