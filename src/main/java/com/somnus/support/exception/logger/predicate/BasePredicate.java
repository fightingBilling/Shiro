package com.somnus.support.exception.logger.predicate;

import org.apache.commons.collections.Predicate;

import com.somnus.support.exception.logger.context.ExceptionLoggerContext;

/**
 * @Description predicate抽象基类
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public abstract class BasePredicate implements Predicate{

	/**
	 * @Description 输入obj转为异常日志上下文
	 * @param input
	 * @return
	 * @author Somnus
	 */
	protected ExceptionLoggerContext toContext(Object input){
		return  input == null ? new ExceptionLoggerContext(null) : (ExceptionLoggerContext)input;
	}

}
