package com.somnus.support.exception;

/**
 * @Description 系统异常
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class SysException extends Exception {

	private static final long serialVersionUID = -5582771999787282608L;
	
	public SysException() {
		super();
	}

	public SysException(String message) {
		super(message);
	}

	public SysException(String message, Throwable cause) {
		super(message, cause);
	}

	public SysException(Throwable cause) {
		super(cause);
	}

}
