/**
 * @projectName boot
 */
package com.xcl.mapper;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.xcl.bean.TYh;

/**
 * mapper类
 * @description mapper
 * @author auto
 * @date 2018-12-25 14:04
 * @version 1.0
 */
public interface TYhMapper {

    /**
     * 插入一条数据
     * @param tYh 
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    public int insertTYh(TYh tYh);

    /**
     * 通过主键物理数据
     * @param cbh 主键编号
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    public int deleteTYhByPk(String cbh);
    
    /**
     * 通过条件删除数据
     * @param tYh 查询条件
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    public int deleteTYhByQuery(TYh tYh);
    
    /**
     * 通过主键修改TYh数据
     * @param tYh 更新实体
     * @return 影响行数
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    public int updateTYhByPk(TYh tYh);
    
     /**
      * 通过条件查询多条数据
      * @param tYh 查询条件
      * @param pageBounds 分页条件
      * @return 结果集
      * @author auto
      * @date 2018-12-25 14:04
      * @version 1.0
      */
    public List<TYh> selectTYhsByQuery(TYh tYh, PageBounds pageBounds);

    /**
     * 通过主键查询信息
     * @param cbh 主键编号
     * @return
     * @author auto
     * @date 2018-12-25 14:04
     * @version 1.0
     */
    public TYh selectTYhByPk(String cbh);
}