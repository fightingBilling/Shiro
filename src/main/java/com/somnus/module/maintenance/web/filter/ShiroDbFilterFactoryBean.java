package com.somnus.module.maintenance.web.filter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.somnus.module.maintenance.model.SFilter;
import com.somnus.module.maintenance.service.ShiroDbService;

public class ShiroDbFilterFactoryBean extends ShiroFilterFactoryBean implements InitializingBean {

	private transient final Logger log = LoggerFactory.getLogger(this.getClass());

	public ShiroDbFilterFactoryBean() {
		super();
		appendChainDefinition = new LinkedHashMap<String, String>();
	}

	@Override
	public void setFilterChainDefinitions(String definitions) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFilterChainDefinitionMap(
			Map<String, String> filterChainDefinitionMap) {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		List<SFilter> lstFilters = shiroDbService.findAllFilters();
		if (lstFilters != null && !lstFilters.isEmpty()) {
			for (SFilter f : lstFilters) {
				StringBuilder valueBuilder = new StringBuilder();
				valueBuilder.append(f.getSecurityFilter().equals("anon") ? "anon"
								: String.format("%s,cRoles[%s]",
										f.getSecurityFilter(),
										f.getResourceId()));
				log.debug("read filter definition: {}",
						new Object[] { valueBuilder.toString() });
				filterChainDefinitionMap.put(f.getUrlPattern(),
						valueBuilder.toString());
			}
			filterChainDefinitionMap.putAll(appendChainDefinition);
		}
		super.setFilterChainDefinitionMap(filterChainDefinitionMap);
	}

	private ShiroDbService shiroDbService;

	// 追加到filterChainDefinition中的匹配定义
	private Map<String, String> appendChainDefinition;

	/**
	 * @param shiroDbService
	 *            the shiroDbService to set
	 */
	public void setShiroDbService(ShiroDbService shiroDbService) {
		this.shiroDbService = shiroDbService;
	}

	/**
	 * @param appendChainDefinition
	 *            the appendChainDefinition to set
	 */
	public void setAppendChainDefinition(Map<String, String> appendChainDefinition) {
		this.appendChainDefinition = appendChainDefinition;
	}

	/**
	 * @return the appendChainDefinition
	 */
	public Map<String, String> getAppendChainDefinition() {
		return appendChainDefinition;
	}

}
