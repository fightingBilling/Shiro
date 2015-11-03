package com.somnus.support.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.somnus.msg.Message;
import com.somnus.support.constant.Constants;
import com.somnus.support.exception.BizException;
import com.somnus.support.message.Errors;
import com.somnus.support.message.Msa;


public class ExceptionUtil {
	// 日志
	private static final Logger log = LoggerFactory.getLogger(ExceptionUtil.class);

	public static void exceptionHandle(ModelAndView view, Msa msa, Exception e) {
		if (e instanceof BizException) {
			log.error(Constants.EXECUTE_ERROR + e.getMessage(), e);
			view.addObject(Constants._message, msa.getMessage(Errors.ERROR_BIZ, new Object[] { e.getMessage() }));
		} else {
			log.error(Constants.EXECUTE_ERROR, e);
			view.addObject(Constants._message, msa.getMessage(Errors.ERROR_SYS));
		}
	}

	public static void exceptionHandle(Exception e) {
		if (e instanceof BizException) {
			log.error(Constants.EXECUTE_ERROR + e.getMessage(), e);
		} else {
			log.error(Constants.EXECUTE_ERROR, e);
		}
	}

	public static void exceptionHandle(Message msg, Exception e) {
		if (e instanceof BizException) {
			log.error(Constants.EXECUTE_ERROR + e.getMessage(), e);
			msg.setRepCode(Errors.ERROR_BIZ);
			msg.setRepMsg(e.getMessage());
		} else {
			log.error(Constants.EXECUTE_ERROR, e);
			msg.setRepCode(Errors.ERROR_SYS);
			msg.setRepMsg(e.getMessage());
		}
	}
}
