/**
 * @projectName boot
 * @package com.xcl.controller
 * @className com.xcl.controller.HomeController
 * @copyright Copyright 2018 XCL, Inc. All rights reserved.
 */
package com.xcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcl.bean.TYh;
import com.xcl.exceptions.BootException;
import com.xcl.service.IYhService;
import com.xcl.vo.ResultVo;

/**
 * HomeController
 * 
 * @description home
 * @author xiangchunlin
 * @date 2018年11月30日 下午12:43:20
 * @version 2.1
 */
@CrossOrigin
@RestController
@RequestMapping("api/hdd/home/")
public class HomeController extends BaseController {

    /**
     * 用户service
     */
    @Autowired
    private IYhService iYhService;

    /**
     * 
     * HomeController
     * @description 查询用户数据
     * @return 用户数据
     * @author xiangchunlin
     * @date 2018年11月30日 下午1:04:11
     * @version 1.0
     */
    @GetMapping("index")
    public ResponseEntity<ResultVo<TYh>> index(String cbh) throws BootException {
        ResultVo<TYh> result = new ResultVo<>(1, "成功", null);
        TYh yh = iYhService.selectOne(cbh);
        result.setData(yh);
        return ResponseEntity.ok(result);

    }
}
