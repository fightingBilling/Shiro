package com.somnus.support.exception;

/**
 * @Description 基础应用平台业务异常
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BizException(String message) {
		super(message);
	}

}
