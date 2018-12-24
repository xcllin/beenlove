package com.xcl.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BootException extends RuntimeException {

	/**
	 * @author xiangchunlin
	 * @description 
	 * @date 2018年12月24日
	 * @version 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	private String errcode;

	/**
	 * 消息
	 */
	private String message;

	public BootException(String errcode, String message) {
		this.errcode = errcode;
		this.message = message;
	}
	public BootException(String message) {
		this.message = message;
	}
	

}
