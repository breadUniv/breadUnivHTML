package com.firebird.breaduniv.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.firebird.breaduniv", annotationClass = Mapper.class)
public class MybatisConfig {
}
