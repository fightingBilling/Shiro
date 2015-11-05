package com.somnus.support.exception.logger.context;

/**
 * @Description 异常日志上下文
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class ExceptionLoggerContext {

	public ExceptionLoggerContext(Throwable throwable){
		this.throwable = throwable;
	}
	
	private Throwable throwable;

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}
