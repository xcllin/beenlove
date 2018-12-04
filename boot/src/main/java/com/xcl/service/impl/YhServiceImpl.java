/**
 * @projectName boot
 * @package com.xcl.service.impl
 * @className com.xcl.service.impl.YhServiceImpl
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.xcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcl.bean.TYh;
import com.xcl.exceptions.BootException;
import com.xcl.mapper.TYhMapper;
import com.xcl.service.IYhService;

/**
 * YhServiceImpl
 * @description TODO
 * @author xiangchunlin
 * @date 2018年4月20日 上午9:30:08
 * @version 2.1
 */
@Service
public class YhServiceImpl extends BaseService implements IYhService {

    @Autowired
    private TYhMapper tYhMapper;
    
    @Override
    public TYh selectOne(String cbh) throws BootException {
        return tYhMapper.selectTYhByPk(cbh);
    }

}
