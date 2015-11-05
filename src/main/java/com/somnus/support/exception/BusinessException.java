package com.somnus.support.exception;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;

import com.somnus.support.holder.ApplicationContextHolder;

/**
 * @Description 基础应用平台业务异常
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msgCode;

	private String message;

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BusinessException(String msgCode, Object[] params) {
		ApplicationContext context = ApplicationContextHolder.getApplicationContext();
		MessageSourceAccessor msa = (MessageSourceAccessor) context.getBean("msa");
		msgCode = msa.getMessage(msgCode, params);
	}

}
