package com.somnus.support.exception;

import org.springframework.context.ApplicationContext;

import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.message.Msa;

/**
 * @Description 基础应用平台业务异常
 * @author caobin
 * @date 2012-11-19
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
		Msa msa = (Msa) context.getBean("msa");
		msgCode = msa.getMessage(msgCode, params);
	}

}
