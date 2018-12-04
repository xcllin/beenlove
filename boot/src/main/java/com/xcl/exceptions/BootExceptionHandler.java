package com.xcl.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author xiangchunlin
 * @description 全局异常处理
 * @date 2018年12月3日
 * @version 1.0
 */
@ControllerAdvice
public class BootExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(BootException.class);

	 /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        return map;
    }
    
    /**
     * 
     * @author xiangchunlin
     * @description 统一异常返回
     * @params @param ex
     * @params @return
     * @return Map
     * @date 2018年12月3日
     * @version 1.0
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
    @ExceptionHandler(value = BootException.class)
    public Map myErrorHandler(BootException ex) {
        Map map = new HashMap();
        if (null == ex.getErrcode()) {
        	map.put("code", 0);
        	map.put("msg", "操作异常");
		}else{
			map.put("code", ex.getErrcode());
			map.put("msg", ex.getMessage());
		}
        return map;
    }
    
}
