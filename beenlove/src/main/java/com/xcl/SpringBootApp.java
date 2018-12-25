/**
 * @projectName boot
 * @package com.xcl
 * @className com.xcl.SpringBootApp
 * @copyright Copyright 2018 XCL, Inc. All rights reserved.
 */
package com.xcl;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * SpringBootApp
 * @description 启动类
 * @author xiangchunlin
 * @date 2018年4月19日 下午4:36:15
 * @version 2.1
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ServletComponentScan
@ComponentScan(basePackages = {"com.xcl"})
@MapperScan(basePackages = {"com.xcl.mapper","com.xcl.mapperext"})
public class SpringBootApp  {
	/**
	 * 
	 * @author xiangchunlin
	 * @description 使用阿里的数据源
	 * @params 
	 * @return DataSource
	 * @date 2018年12月4日
	 * @version 1.0
	 */
	@Bean("duridDatasource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() { return new DruidDataSource(); }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
