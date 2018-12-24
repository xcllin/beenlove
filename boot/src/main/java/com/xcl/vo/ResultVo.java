/**
 * @projectName boot
 * @package com.xcl.bean.vo
 * @className com.xcl.bean.vo.ResultVo
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.xcl.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ResultVo
 * 
 * @description 返回体
 * @author xiangchunlin
 * @date 2018年4月19日 下午4:58:13
 * @version 2.1
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
public class ResultVo<T> {

	/**
	 * 返回码，默认为0
	 */
	private int code = 0;

	/**
	 * 消息
	 */
	private String message;

	/**
	 * 参数
	 */
	private T data;

	/**
	 * 
	 * ResultVo
	 * 
	 * @description 构造方法
	 * @param code
	 * @param message
	 * @author xiangchunlin
	 * @date 2018年4月19日 下午5:06:09
	 * @version 1.0
	 */
	public ResultVo(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 
	 * ResultVo
	 * 
	 * @description 构造方法
	 * @param code
	 * @param data
	 * @author xiangchunlin
	 * @date 2018年4月19日 下午5:06:12
	 * @version 1.0
	 */
	public ResultVo(int code, T data) {
		this.code = code;
		this.data = data;
	}

	/**
	 * 
	 * ResultVo
	 * 
	 * @description 构造方法
	 * @param code
	 * @param message
	 * @param data
	 * @author xiangchunlin
	 * @date 2018年4月19日 下午5:06:15
	 * @version 1.0
	 */
	public ResultVo(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

}
