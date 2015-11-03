package com.somnus.support.exception.logger.closure;

import org.apache.commons.collections.Closure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.support.exception.logger.LoggerConstants;
import com.somnus.support.exception.logger.context.ExceptionLoggerContext;


/**
 * @Description closure抽象基类
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public abstract class BaseClosure implements Closure {

	/**
	 * @Description 输入obj转为异常日志上下文
	 * @param input
	 * @return
	 * @author caobin
	 */
	protected ExceptionLoggerContext toContext(Object input){
		return  input == null ? new ExceptionLoggerContext(null) : (ExceptionLoggerContext)input;
	}
	
	@Override
	public void execute(Object input) {
		ExceptionLoggerContext context = this.toContext(input);
		log.error(context.getThrowable().getMessage(), context.getThrowable());
	}

	protected transient Logger log = LoggerFactory.getLogger(LoggerConstants.PSFP_LOGGER);
}
