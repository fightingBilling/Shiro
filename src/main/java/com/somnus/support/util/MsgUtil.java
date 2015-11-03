package com.somnus.support.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.time.DateFormatUtils;

public class MsgUtil {
	/**
	 * 处理成功
	 */
	public static final String SUCCESS_000000 = "000000";

	/**
	 * 处理失败
	 */
	public static final String FAIL_999999 = "999999";

	private static String datePattern = "yyyy-MM-dd HH:mm:ss";

	private static String hostName = null;

	static {
		try {
			hostName = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	public static void setCommInfo(Object message) throws Exception {

		MethodUtils.invokeMethod(message, "setSysCode", new Object[] { SystemInfo.SYS_CODE });
		MethodUtils.invokeMethod(message, "setBrcCode", new Object[] { SystemInfo.BRC_CODE });
		MethodUtils.invokeMethod(message, "setChannelNo", new Object[] { SystemInfo.CHANNEL_NO });
		MethodUtils.invokeMethod(message, "setFrontNo", new Object[] { hostName });
		MethodUtils.invokeMethod(message, "setFrontTime",
				new Object[] { DateFormatUtils.format(new Date(), datePattern) });

	}

}
