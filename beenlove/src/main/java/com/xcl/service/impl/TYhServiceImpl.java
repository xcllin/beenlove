/**
 * @projectName boot
 */
package com.xcl.service.impl;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.xcl.bean.TYh;
import com.xcl.mapperext.TYhMapperExt;
import com.xcl.service.ITYhService;
import com.xcl.utils.DataModelUtils;
import com.xcl.vo.PageBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * service接口实现类
 * @description service接口实现
 * @author xiangchunlin
 * @date 2018-12-25 14:04
 * @version 1.0
 */
 @Service
public class TYhServiceImpl extends BaseService implements ITYhService {

    @Autowired
    private TYhMapperExt tYhMapperExt;

    /**
     * 插入一条数据
     * @param tYh 
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    @Override
    public int insertTYh(TYh tYh){
        return tYhMapperExt.insertTYh(tYh);
    }

    /**
     * 通过主键物理数据
     * @param cBh 主键编号
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    @Override
    public int deleteTYhByPk(String cbh){
        return tYhMapperExt.deleteTYhByPk(cbh);
    }
    
    /**
     * 通过条件删除数据
     * @param tYh 查询条件
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    @Override
    public int deleteTYhByQuery(TYh tYh){
        return tYhMapperExt.deleteTYhByQuery(tYh);
    }
    
    /**
     * 通过主键修改TYh数据
     * @param tYh 更新实体
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    @Override
    public int updateTYhByPk(TYh tYh){
        return tYhMapperExt.updateTYhByPk(tYh);
    }
    
     /**
      * 通过条件查询多条数据
      * @param tYh 查询条件
      * @param page 分页条件 null不分页
      * @return 结果集
      * @author auto
      * @date 2018-12-25 14:04
      * @version 1.0
      */
    @Override
    public List<TYh> selectTYhsByQuery(TYh tYh){
        return tYhMapperExt.selectTYhsByQuery(tYh, new PageBounds());
    }
    
     /**
      * 通过条件查询多条数据并分页
      * @param tYh 查询条件
      * @param page 分页条件  不能传null
      * @return 结果集
      * @author auto
      * @date 2018-12-25 14:04
      * @version 1.0
      */
    @Override
    public PageBean<TYh> selectTYhsByQuery(PageBean<TYh> page){
    	if(page == null || page.getPageSize() == 0){
            throw new NullPointerException("分页参数不能为空");
        }
    	PageBounds pageBounds = new PageBounds(page.getPageNum(), page.getPageSize());
        String sort = DataModelUtils.getSort(page.getOrderBy());
        pageBounds.setOrders(Order.formString(sort));
        List<TYh> list= tYhMapperExt.selectTYhsByQuery(page.getCondition(), pageBounds);
        return new PageBean<TYh>(list);
    }

    /**
     * 通过主键查询信息
     * @param cbh 主键编号
     * @return 结果
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    @Override
    public TYh selectTYhByPk(String cbh){

        return tYhMapperExt.selectTYhByPk(cbh);
    }
}