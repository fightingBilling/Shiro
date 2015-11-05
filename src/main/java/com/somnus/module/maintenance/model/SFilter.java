package com.somnus.module.maintenance.model;

import java.math.BigDecimal;

public class SFilter {
	private BigDecimal resourceId;

	private String securityFilter;

	private String urlPattern;

	/**
	 * @return the resourceId
	 */
	public BigDecimal getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(BigDecimal resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the securityFilter
	 */
	public String getSecurityFilter() {
		return securityFilter;
	}

	/**
	 * @param securityFilter the securityFilter to set
	 */
	public void setSecurityFilter(String securityFilter) {
		this.securityFilter = securityFilter;
	}

	/**
	 * @return the urlPattern
	 */
	public String getUrlPattern() {
		return urlPattern;
	}

	/**
	 * @param urlPattern the urlPattern to set
	 */
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	
}
