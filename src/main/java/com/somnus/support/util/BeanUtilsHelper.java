package com.somnus.support.util;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

public class BeanUtilsHelper {

	public BeanUtilsHelper() {
		// 这里一定要注册默认值，使用null也可以
		BigDecimalConverter bd = new BigDecimalConverter(null);
		ConvertUtils.register(bd, java.math.BigDecimal.class);
	}
}
