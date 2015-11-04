package com.somnus.maintenance;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.somnus.AbstractTestSupport;
import com.somnus.module.maintenance.dao.DefaultDao;
import com.somnus.module.maintenance.model.SetFuncMenu;

/**
 * @Description 
 * @author Somnus
 * @date 2015-11-04
 * @version 1.0
 */
public class DefaultDaoTestcase extends AbstractTestSupport{
	
	@Test
	public void findAllMenu(){
		List<SetFuncMenu> lstFuncMenu = defaultDao.findAllMenu();
		log.info("lstFuncMenu ==> {}", new Object[]{lstFuncMenu});
	}
	
	@Autowired
	private DefaultDao defaultDao;
}
