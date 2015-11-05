package com.somnus.module.maintenance.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;

import com.somnus.module.maintenance.model.SetFroleFmenu;
import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.module.maintenance.model.SetFuncRole;
import com.somnus.module.maintenance.service.RoleMenuService;
import com.somnus.module.maintenance.service.SetFuncMenuService;
import com.somnus.support.constant.Constants;
import com.somnus.support.web.controller.BaseController;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;

public class RoleMenuController extends BaseController {
	
	/**
	 * @Description 显示角色管理页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView roleMenuDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String _search_roleName = "_search_roleName";
		
		String roleName = this.findStringParameterValue(request,_search_roleName);

		String _search_key = null, _search_value = null;
		if (roleName != null) {
			_search_key = _search_roleName;
			_search_value = roleName;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleName", roleName);
		
		Pageable pageable = null;
		
		if(request.getParameter("pageSize") == null){
			Integer start = findIntegerParameterValue(request, Constants._page);
			pageable = new PageRequest(start == null ? 1 : start,Constants.DEFAULT_LIMIT);
		} else {
			pageable = this.findPage(request);
		}
		
		// 查询分页记录
		Pageable result = roleMenuService.queryPaged(pageable, params);
		
		//执行分页处理
		PaginatedList paginatedList = this.doPaging(result, pageable.getPageStart(), pageable.getPageLimit());
		
		return createMAV("/mt/role/role_menu_read")
				.addObject("_search_key", _search_key)
				.addObject("_search_value", _search_value)
				.addObject("pageList", paginatedList);
	}
	
	/**
	 * @Description 显示角色创建/编辑页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView roleMenuPersistenceDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String subBtn = this.findStringParameterValue(request, "subBtn");
		if(subBtn.equals(Constants._add)){
			return roleAddDisPlay(request, response);
		} else if(subBtn.equals(Constants._update)){
			return roleUpdateDisPlay(request, response);
		}   else {
			return roleMenuDisplay(request, response);
		}
		
	}
	
	private ModelAndView roleAddDisPlay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<SetFuncMenu> menus = setFuncMenuService.queryAll();
		return createMAV("/mt/role/role_menu_create").addObject("menus", menus);
	}
	
	private ModelAndView roleUpdateDisPlay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BigDecimal roleId = this.findBigDecimalParameterValue(request, "roleId");
		List<SetFuncMenu> candidateResources = setFuncMenuService.queryAll();
		List<SetFuncMenu> selectedResources = setFuncMenuService.querySelectedResource(roleId);
		return createMAV("/mt/role/role_menu_update")
					.addObject("candidate_resources", candidateResources)
					.addObject("selected_resources", selectedResources)
					.addObject("roleName", this.findStringParameterValue(request, "roleName"))
					.addObject("roleId", roleId);
	}
	
	/**
	 * @Description 角色创建
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView roleMenuCreate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String mids = this.findStringParameterValue(request,"mids");
		String roleName = this.findStringParameterValue(request,"roleName");
		
		if(StringUtils.isBlank(roleName)){
			return roleAddDisPlay(request, response).addObject(Constants._message, "角色姓名为空");
		}
		
		if(StringUtils.isBlank(mids)){
			return roleAddDisPlay(request, response).addObject(Constants._message, "角色菜单主键串为空");
		}
		
		String[] ids = mids.split(",");
		if(ArrayUtils.isEmpty(ids)){
			return roleAddDisPlay(request, response).addObject(Constants._message, "角色菜单为空");
		}
		
		String roleSeq = roleMenuService.queryRoleSeq();
		BigDecimal roleId = NumberUtils.createBigDecimal(roleSeq);
		
		List<SetFroleFmenu> list = new ArrayList<SetFroleFmenu>();
		
		for(String menuId : ids){
			SetFroleFmenu roleMenu = new SetFroleFmenu();
			roleMenu.setFuncMenuId(NumberUtils.createBigDecimal(menuId));
			roleMenu.setFuncRoleId(roleId);
			list.add(roleMenu);
		}
		
		SetFuncRole role = new SetFuncRole();
		role.setFuncRoleId(roleId);
		role.setFuncRoleName(roleName);
		role.setStatus(Constants.ROLE_EFFECT);
		
		roleMenuService.create(role, list);
		
		return roleAddDisPlay(request, response).addObject(Constants._message, "创建成功");
		
	}
	
	
	/**
	 * @Description 角色编辑
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView roleMenuUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String mids = this.findStringParameterValue(request,"mids");
		String roleName = this.findStringParameterValue(request,"roleName");
		BigDecimal roleId = this.findBigDecimalParameterValue(request, "roleId");
		
		if(roleId == null){
			return roleUpdateDisPlay(request, response).addObject(Constants._message, "角色主键空");
		}
		
		if(StringUtils.isBlank(roleName)){
			return roleUpdateDisPlay(request, response).addObject(Constants._message, "角色姓名为空");
		}
		
		if(StringUtils.isBlank(mids)){
			return roleUpdateDisPlay(request, response).addObject(Constants._message, "角色菜单主键串为空");
		}
		
		String[] ids = mids.split(",");
		if(ArrayUtils.isEmpty(ids)){
			return roleUpdateDisPlay(request, response).addObject(Constants._message, "角色菜单为空");
		}
		
		
		List<SetFroleFmenu> list = new ArrayList<SetFroleFmenu>();
		
		for(String menuId : ids){
			SetFroleFmenu roleMenu = new SetFroleFmenu();
			roleMenu.setFuncMenuId(NumberUtils.createBigDecimal(menuId));
			roleMenu.setFuncRoleId(roleId);
			list.add(roleMenu);
		}
		
		SetFuncRole role = new SetFuncRole();
		role.setFuncRoleId(roleId);
		role.setFuncRoleName(roleName);
		role.setStatus(Constants.ROLE_EFFECT);
		
		roleMenuService.update(role, list);
		
		return roleMenuDisplay(request, response).addObject(Constants._message, "编辑成功");
	}
	
	public ModelAndView roleMenuDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BigDecimal roleId = this.findBigDecimalParameterValue(request, Constants._delData);
		if(roleId == null){
			return roleMenuDisplay(request, response).addObject(Constants._message, "主键为空");
		}
		roleMenuService.delete(roleId);
		return roleMenuDisplay(request, response).addObject(Constants._message, "删除成功");
	}
	
	
	//注入roleMenuService
	private RoleMenuService roleMenuService;
	//注入setFuncMenuService
	private SetFuncMenuService setFuncMenuService;

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setSetFuncMenuService(SetFuncMenuService setFuncMenuService) {
		this.setFuncMenuService = setFuncMenuService;
	}

}
