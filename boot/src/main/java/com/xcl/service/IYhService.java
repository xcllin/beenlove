/**
 * @projectName boot
 * @package com.xcl.service
 * @className com.xcl.service.TYhService
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.xcl.service;

import com.xcl.bean.TYh;
import com.xcl.exceptions.BootException;

/**
 * TYhService
 * 
 * @description TODO
 * @author xiangchunlin
 * @date 2018年4月20日 上午9:28:16
 * @version 2.1
 */
public interface IYhService {
    /**
     * 查询单个用户
     * 
     * @param yh
     * @return
     */
    public TYh selectOne(String cbh) throws BootException;
}
