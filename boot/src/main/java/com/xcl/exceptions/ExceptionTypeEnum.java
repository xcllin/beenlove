package com.xcl.exceptions;

import lombok.Getter;

/**
 * 
 * @author xiangchunlin
 * @description 异常统一返回枚举类型
 * @date 2018年12月24日
 * @version 1.0
 */
@Getter
public enum ExceptionTypeEnum {
	
	FAILOPERATE("1","操作失败"),
	NOTPERMISSON("2","没有权限");
	/**
	 * 状态码
	 */
	private String code;
	/**
	 * 异常消息
	 */
	private String message;
	
	private ExceptionTypeEnum (String code,String message){
		this.code = code;
		this.message = message;
	}
}
