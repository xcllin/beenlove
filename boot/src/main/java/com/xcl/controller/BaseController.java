/**
 * @projectName boot
 * @package com.xcl.controller
 * @className com.xcl.controller.BaseController
 * @copyright Copyright 2018 XCL, Inc. All rights reserved.
 */
package com.xcl.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.xcl.service.ITYhService;



/**
 * BaseController
 * @description 基础controller
 * @author xiangchunlin
 * @date 2018年4月20日 上午10:07:42
 * @version 2.1
 */
public class BaseController {
    
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * redisTemplate
	 */
	@Autowired
	protected RedisTemplate redisTemplate;
	
    /**
     * 用户service
     */
    @Autowired
    protected ITYhService itYhService;

}
