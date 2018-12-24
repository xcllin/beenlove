package com.xcl.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	private Logger logger = LoggerFactory.getLogger(BootExceptionHandler.class);

	 /**
	  * 
	  * @author xiangchunlin
	  * @description 统一异常返回
	  * @params ex 异常
	  * @params 
	  * @return Map
	  * @date 2018年12月24日
	  * @version 1.0
	  */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity errorHandler(Exception ex) {
        Map map = new HashMap(2);
        map.put("code", ExceptionTypeEnum.FAILOPERATE.getCode());
        map.put("msg", StringUtils.isNotBlank(ex.getMessage())?ex.getMessage():ExceptionTypeEnum.FAILOPERATE.getMessage());
        logger.warn("系统异常:", ex);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * 
     * @author xiangchunlin
     * @description 自定义异常返回
     * @params ex
     * @params 
     * @return Map
     * @date 2018年12月3日
     * @version 1.0
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
    @ExceptionHandler(value = BootException.class)
    public ResponseEntity myErrorHandler(BootException ex) {
        Map map = new HashMap(2);
        map.put("code", StringUtils.isNotBlank(ex.getErrcode())?ex.getMessage():ExceptionTypeEnum.FAILOPERATE.getCode());
        map.put("msg", StringUtils.isNotBlank(ex.getMessage())?ex.getMessage():ExceptionTypeEnum.FAILOPERATE.getMessage());
        logger.warn("操作异常:", ex);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
