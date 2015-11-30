package com.somnus.support.tag;

import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.support.util.DisplayPropUtil;


public class ColumnTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(ColumnTag.class);

	private static Properties display = null;

	private String name;

	private String value;

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		if (display == null) {
			try {
				display = DisplayPropUtil.getDisplayProp();
			} catch (Exception e) {
				log.error("display.properties load error:" + e);
			}
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspTagException {
		String content = (String) display.get(name + value);
		try {
			if (content != null) {
				pageContext.getOut().write(content);
			} else {
				pageContext.getOut().write(value);
			}
		} catch (Exception e) {
			log.error("pageContext write error:" + e);
		}

		return EVAL_PAGE;
	}
}
