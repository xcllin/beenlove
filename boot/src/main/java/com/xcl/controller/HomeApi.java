/**
 * @projectName boot
 * @package com.xcl.controller
 * @className com.xcl.controller.HomeController
 * @copyright Copyright 2018 XCL, Inc. All rights reserved.
 */
package com.xcl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xcl.bean.TYh;
import com.xcl.exceptions.BootException;
import com.xcl.vo.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * HomeController
 * 
 * @description home
 * @author xiangchunlin
 * @date 2018年11月30日 下午12:43:20
 * @version 2.1
 */
@Api(value ="主页相关接口",tags = "主页相关接口")
@CrossOrigin
@RestController
@RequestMapping("api/xcl/home/")
public class HomeApi extends BaseController {

	/**
	 * 
	 * @author xiangchunlin
	 * @description 主页
	 * @return
	 * @throws BootException
	 * @date 2018年12月16日
	 * @version 1.0.0
	 */
	@ApiOperation(value = "主页",notes="主页接口")
	@GetMapping("index")
	public ResponseEntity<ResultVo<String>> index()
			throws BootException {
		ResultVo<String> result = new ResultVo<>(1, "成功", "主页");
		return ResponseEntity.ok(result);
	}

}
