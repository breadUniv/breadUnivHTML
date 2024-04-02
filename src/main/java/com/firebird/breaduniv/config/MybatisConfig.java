package com.firebird.breaduniv.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = "com.firebird.breaduniv", annotationClass = Mapper.class)
//public class MybatisConfig {
//}
@Configuration
@MapperScan(basePackages = "com.firebird.breaduniv", annotationClass = Mapper.class)
public class MybatisConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}



