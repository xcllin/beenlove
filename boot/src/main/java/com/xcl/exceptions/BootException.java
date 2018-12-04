package com.xcl.exceptions;

public class BootException extends RuntimeException {

	/**
	 * 错误码
	 */
	private Integer errcode;

	/**
	 * 消息
	 */
	private String message;

	public BootException(Integer errcode, String message) {
		this.errcode = errcode;
		this.message = message;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
