package com.xcl.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcl.bean.TYh;
import com.xcl.exceptions.BootException;
import com.xcl.vo.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author xiangchunlin
 * @description 用户api
 * @date 2018年12月24日
 * @version 1.0.0
 */
@Api(value = "用户相关接口", tags = "用户相关接口")
@CrossOrigin
@RestController
@RequestMapping(value = "api/xcl/user/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserApi extends BaseController {

	/**
	 * 
	 * @author xiangchunlin
	 * @description 测试接口
	 * @param cbh 用户编号
	 * @return
	 * @throws BootException
	 * @date 2018年12月22日
	 * @version 1.0.0
	 */
	@ApiOperation(value = "查询用户byPK",response=TYh.class)
	@GetMapping("{id}")
	public ResponseEntity<ResultVo<TYh>> getUserByPk(
			@PathVariable(value = "id", required = true) @ApiParam(name = "id", value = "用户编号", required = true) String id)
			throws BootException {
		TYh yh = (TYh) redisTemplate.opsForValue().get(id);
		if(null == yh){
			yh = itYhService.selectTYhByPk(id);
			redisTemplate.opsForValue().set(id,yh,5,TimeUnit.MINUTES);
		}
		return ResponseEntity.ok(new ResultVo<TYh>(yh));
	}
}
