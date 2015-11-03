package com.somnus.support.exception.logger.predicate;

import com.somnus.support.exception.BizException;
import com.somnus.support.exception.logger.context.ExceptionLoggerContext;


/**
 * @Description 业务异常日志处理分支条件
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class BusinessExceptionLoggerPredicate extends BasePredicate {

	@Override
	public boolean evaluate(Object object) {
		ExceptionLoggerContext context = this.toContext(object);
		return context.getThrowable() instanceof BizException;

	}

}
