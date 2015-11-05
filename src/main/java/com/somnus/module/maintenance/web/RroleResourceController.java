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

import com.somnus.module.maintenance.model.SetResource;
import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRroleResource;
import com.somnus.module.maintenance.service.RroleResourceService;
import com.somnus.module.maintenance.service.SetResourceService;
import com.somnus.support.constant.Constants;
import com.somnus.support.web.controller.BaseController;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;


public class RroleResourceController extends BaseController {
	
	
	/**
	 * @Description 显示角色管理页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView roleResourceDisplay(HttpServletRequest request, 
	        HttpServletResponse response) throws Exception{
		
        String searchRoleName = "_search_roleName";
		
        String roleName = this.findStringParameterValue(request, searchRoleName);

        String searchKey = null;
        String searchValue = null;
		if (roleName != null) {
            searchKey = searchRoleName;
            searchValue = roleName;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("resourceRoleName", roleName);
		
		Pageable pageable = null;
		
		if(request.getParameter("pageSize") == null){
			Integer start = findIntegerParameterValue(request, Constants._page);
			pageable = new PageRequest(start == null ? 1 : start,Constants.DEFAULT_LIMIT);
		} else {
			pageable = this.findPage(request);
		}
		
		// 查询分页记录
		Pageable result = rroleResourceService.queryPaged(pageable, params);
		
		//执行分页处理
		PaginatedList paginatedList = this.doPaging(result, pageable.getPageStart(), pageable.getPageLimit());
		
		return createMAV("/mt/role/role_resource_read")
				.addObject("_search_key", searchKey)
				.addObject("_search_value", searchValue)
				.addObject("pageList", paginatedList);
	}
	
	/**
	 * @Description 显示角色创建/编辑页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView roleResourcePersistenceDisplay(HttpServletRequest request,
	        HttpServletResponse response) throws Exception{
		String subBtn = this.findStringParameterValue(request, "subBtn");
		if(subBtn.equals(Constants._add)){
			return roleResourceAddDisPlay(request, response);
		} else if(subBtn.equals(Constants._update)){
			return roleResourceUpdateDisPlay(request, response);
		} else {
			return roleResourceDisplay(request, response);
		}
		
	}
	
	private ModelAndView roleResourceAddDisPlay(HttpServletRequest request,
	        HttpServletResponse response) throws Exception{
		List<SetResource> resources = setResourceService.queryAll(request.getParameter("urlPatten"));
		return createMAV("/mt/role/role_resource_create").addObject("resources", resources);
	}
	
	
	private ModelAndView roleResourceUpdateDisPlay(HttpServletRequest request,
	        HttpServletResponse response) throws Exception{			
		BigDecimal resourceRoleId = this.findBigDecimalParameterValue(request, "resourceRoleId");
        String urlPatten = this.findStringParameterValue(request, "urlPatten");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("resourceId", resourceRoleId);
        params.put("urlPattern", urlPatten);
		List<SetResource> candidateResources = setResourceService.queryCandidateResource(params);
		List<SetResource> selectedResources = setResourceService.querySelectedResource(resourceRoleId);	
		return createMAV("/mt/role/role_resource_update")
					.addObject("candidate_resources", candidateResources)
					.addObject("selected_resources", selectedResources)
					.addObject("roleName", this.findStringParameterValue(request,
					        "resourceRoleName"))
					.addObject("roleId", resourceRoleId);
	}
	
	/**
	 * @Description 角色创建
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView roleResourceCreate(HttpServletRequest request,
	        HttpServletResponse response) throws Exception{
		String idStr = this.findStringParameterValue(request,"ids");
		String roleName = this.findStringParameterValue(request,"roleName");
		
		if(StringUtils.isBlank(roleName)){
			return roleResourceAddDisPlay(request, response).addObject(Constants._message, "角色姓名为空");
		}
		
		if(StringUtils.isBlank(idStr)){
			return roleResourceAddDisPlay(request, response).addObject(Constants._message, "角色菜单主键串为空");
		}
		
		String[] ids = idStr.split(",");
		if(ArrayUtils.isEmpty(ids)){
			return roleResourceAddDisPlay(request, response).addObject(Constants._message, "角色菜单为空");
		}
		
		String roleSeq = rroleResourceService.queryRoleSeq();
		BigDecimal roleId = NumberUtils.createBigDecimal(roleSeq);
		
		List<SetRroleResource> list = new ArrayList<SetRroleResource>();
		
		for(String resourceId : ids){
			SetRroleResource setRroleResource = new SetRroleResource();
			setRroleResource.setResourceId(NumberUtils.createBigDecimal(resourceId));
			setRroleResource.setResourceRoleId(roleId);
			list.add(setRroleResource);
		}
		
		SetResourceRole role = new SetResourceRole();
		role.setResourceRoleId(roleId);
		role.setResourceRoleName(roleName);
		role.setStatus(Constants.ROLE_EFFECT);
		
		rroleResourceService.create(role, list);
		
		return roleResourceAddDisPlay(request, response).addObject(Constants._message, "创建成功");
		
	}
	
	/**
	 * @Description 角色编辑
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView roleResourceUpdate(HttpServletRequest request,
	        HttpServletResponse response) throws Exception{
		String idStr = this.findStringParameterValue(request,"ids");
		String roleName = this.findStringParameterValue(request,"roleName");
		String roleid = this.findStringParameterValue(request,"roleId");
		
		if(StringUtils.isBlank(roleid)){
			return roleResourceUpdateDisPlay(request, response).addObject(Constants._message, "角色主键为空");
		}
		
		if(StringUtils.isBlank(roleName)){
			return roleResourceUpdateDisPlay(request, response).addObject(Constants._message, "角色姓名为空");
		}
		
		if(StringUtils.isBlank(idStr)){
			return roleResourceUpdateDisPlay(request, response).addObject(Constants._message, "角色菜单主键串为空");
		}
		
		String[] ids = idStr.split(",");
		if(ArrayUtils.isEmpty(ids)){
			return roleResourceUpdateDisPlay(request, response).addObject(Constants._message, "角色菜单为空");
		}
		
		BigDecimal roleId = NumberUtils.createBigDecimal(roleid);
		
		List<SetRroleResource> list = new ArrayList<SetRroleResource>();
		
		for(String resourceId : ids){
			SetRroleResource setRroleResource = new SetRroleResource();
			setRroleResource.setResourceId(NumberUtils.createBigDecimal(resourceId));
			setRroleResource.setResourceRoleId(roleId);
			list.add(setRroleResource);
		}
		
		SetResourceRole role = new SetResourceRole();
		role.setResourceRoleId(roleId);
		role.setResourceRoleName(roleName);
		role.setStatus(Constants.ROLE_EFFECT);
		
		rroleResourceService.update(role, list);
		
		return roleResourceDisplay(request, response).addObject(Constants._message, "编辑成功");
	}
	
	/**
	 * @Description 角色删除
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView roleResourceDelete(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
        String delData = this.findStringParameterValue(request, Constants._delData);
        if (StringUtils.isBlank(delData)) {
			return roleResourceDisplay(request, response).addObject(Constants._message, "主键为空");
		}
		
        BigDecimal roleId = NumberUtils.createBigDecimal(delData);
		
		rroleResourceService.delete(roleId);
		
		return roleResourceDisplay(request, response).addObject(Constants._message, "删除成功");
	}
	
	//注入rroleResourceService
	private RroleResourceService rroleResourceService;
	//注入setResourceService
	private SetResourceService setResourceService;

	public void setRroleResourceService(RroleResourceService rroleResourceService) {
		this.rroleResourceService = rroleResourceService;
	}

	public void setSetResourceService(SetResourceService setResourceService) {
		this.setResourceService = setResourceService;
	}

}
