package com.somnus.support.repository.mybatis._annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 以注解方式来标识MyBatis的DAO,
 * 				{@link org.mybatis.spring.mapper.MapperScannerConfigurer}进行扫描
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyBatisRepository {

}
