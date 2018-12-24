
package com.xcl.utils;

import org.springframework.util.StringUtils;

/**
 * 
 * @author xiangchunlin
 * @description sql处理
 * @date 2018年12月24日
 * @version 1.0
 */
public class DataModelUtils {
    
    /**
     * DataModelUtils
     * @description 私有化构造器
     * @author xiangchunlin
     * @date 2018年12月24日
     * @version 2.1.1
     */
    private DataModelUtils() {
    }

    /**
     * 
     * restful风格排序字段（-name）返回order by后面的sql
     * 
     * @description 转换排序字段的-为sql需要的desc
     * @param sortString 用逗号隔开的排序字段属性，"-"表示倒序
     * @return sql需要的排序格式
     * @author xiangchunlin
     * @date 2018年12月24日
     * @version 1.0
     */
    public static String getSortSql(String sortString) {
        StringBuffer sortSqlbff = new StringBuffer();
        if (StringUtils.isEmpty(sortString)) {
            return sortSqlbff.toString();
        }
        // 获取属性
        String[] sortArray = sortString.split(",");
        // 排序规则asc或者desc
        String order = null;
        // 单个属性
        String property = null;
        for (String str : sortArray) {
            if (StringUtils.isEmpty(str)) {
                continue;
            }
            property = str;
            // 默认升序
            order = " asc";
            if ("-".equals(String.valueOf(str.charAt(0)))) {
                order = " desc";
                // 倒序需要去掉第一个字符串
                property = str.substring(1);
            }

            sortSqlbff.append(property).append(order).append(",");
        }
        return sortSqlbff.substring(0, sortSqlbff.length() - 1);
    }

    /**
     * 
     * DataModelUtils
     * 
     * @description restful排序字段（-name）返回order by后面的sql
     * @param sortString 用逗号隔开的排序字段属性，"-"表示倒序
     * @return sql需要的排序格式
     * @author xiangchunlin
     * @date 2018年12月24日
     * @version 1.0
     */
    public static String getSort(String sortString) {
        StringBuffer sortSqlbff = new StringBuffer();
        if (StringUtils.isEmpty(sortString)) {
            return sortSqlbff.toString();
        }
        // 获取属性
        String[] sortArray = sortString.split(",");
        // 排序规则asc或者desc
        String order = null;
        // 单个属性
        String property = null;
        for (String str : sortArray) {
            if (StringUtils.isEmpty(str)) {
                continue;
            }
            property = str;
            // 默认升序
            order = ".asc";
            if ("-".equals(String.valueOf(str.charAt(0)))) {
                order = ".desc";
                // 倒序需要去掉第一个字符串
                property = str.substring(1);
            }

            sortSqlbff.append(property).append(order).append(",");
        }
        return sortSqlbff.substring(0, sortSqlbff.length() - 1);
    }
}
