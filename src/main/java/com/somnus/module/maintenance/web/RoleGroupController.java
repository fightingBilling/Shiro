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

import com.somnus.module.maintenance.model.SetFuncRole;
import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRgroupFrole;
import com.somnus.module.maintenance.model.SetRgroupRrole;
import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.module.maintenance.service.RoleGroupSerivce;
import com.somnus.support.constant.Constants;
import com.somnus.support.web.controller.BaseController;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;

public class RoleGroupController extends BaseController {
	
	/**
	 * @Description 显示角色组管理页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView roleGroupDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String _search_rgroupName = "_search_rgroupName";
		
		String rgroupName = this.findStringParameterValue(request,_search_rgroupName);
		log.info("search menuName: {}", new Object[] { rgroupName });

		String _search_key = null, _search_value = null;
		if (rgroupName != null) {
			_search_key = _search_rgroupName;
			_search_value = rgroupName;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupName", rgroupName);
		
		Pageable pageable = null;
		
		if(request.getParameter("pageSize") == null){
			Integer start = findIntegerParameterValue(request, Constants._page);
			pageable = new PageRequest(start == null ? 1 : start,Constants.DEFAULT_LIMIT);
		} else {
			pageable = this.findPage(request);
		}
		
		// 查询分页记录
		Pageable result = roleGroupSerivce.queryPaged(pageable, params);
		
		//执行分页处理
		PaginatedList paginatedList = this.doPaging(result, pageable.getPageStart(), pageable.getPageLimit());
		
		return createMAV("/mt/rgroup/rgroup_read")
				.addObject("_search_key", _search_key)
				.addObject("_search_value", _search_value)
				.addObject("pageList", paginatedList);
	}
	
	/**
	 * @Description 显示角色组创建/编辑页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView groupPersistenceDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String subBtn = this.findStringParameterValue(request, "subBtn");
		if(subBtn.equals(Constants._add)){
			return groupAddDisPlay(request, response);
		} else if(subBtn.equals(Constants._update)){
			return groupUpdateDisPlay(request, response);
		} else {
			return roleGroupDisplay(request, response);
		}
		
	}
	
	private ModelAndView groupAddDisPlay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<SetFuncRole> fRoles = roleGroupSerivce.queryFrAll();
		List<SetResourceRole> rRoles = roleGroupSerivce.queryRrAll();
		return createMAV("/mt/rgroup/rgroup_create").addObject("fRoles", fRoles).addObject("rRoles", rRoles);
	}
	
	private ModelAndView groupUpdateDisPlay(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		BigDecimal rgroupId = this.findBigDecimalParameterValue(request, "rgroupId");
		List<SetFuncRole> fcandidateResources = roleGroupSerivce.queryFCandidateResource(rgroupId);
		List<SetFuncRole> fselectedResources = roleGroupSerivce.queryFSelectedResource(rgroupId);
		
		List<SetResourceRole> rcandidateResources = roleGroupSerivce.queryRCandidateResource(rgroupId);
		List<SetResourceRole> rselectedResources = roleGroupSerivce.queryRSelectedResource(rgroupId);	
		
		return createMAV("/mt/rgroup/rgroup_update")
					.addObject("fcandidate_resources", fcandidateResources)
					.addObject("fselected_resources", fselectedResources)
					.addObject("rcandidate_resources", rcandidateResources)
					.addObject("rselected_resources", rselectedResources)
					.addObject("roleType", this.findStringParameterValue(request, "roleType"))
					.addObject("groupName", this.findStringParameterValue(request, "groupName"))
					.addObject("rgroupId", rgroupId);
	}
	
	/**
	 * @Description 角色组创建
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView groupCreate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ridStr = this.findStringParameterValue(request,"rids");
		String fidStr = this.findStringParameterValue(request,"fids");
		String groupName = this.findStringParameterValue(request,"groupName");
		
		if(StringUtils.isBlank(groupName)){
			return groupAddDisPlay(request, response).addObject(Constants._message, "角色组名称为空");
		}
		
		String groupSeq = roleGroupSerivce.queryGroupSeq();
		BigDecimal rgroupId = NumberUtils.createBigDecimal(groupSeq);
		
		String[] rids = null;
		String[] fids = null;
		if(!StringUtils.isBlank(ridStr)){
			rids = ridStr.split(",");
		}
		
		if(!StringUtils.isBlank(fidStr)){
			fids = fidStr.split(",");
		}
		
		List<SetRgroupRrole> rrList = new ArrayList<SetRgroupRrole>();
		List<SetRgroupFrole> frList = new ArrayList<SetRgroupFrole>();
		
		if(!ArrayUtils.isEmpty(rids)){
			for(String roleId : rids){
				SetRgroupRrole setRgroupRrole = new SetRgroupRrole();
				setRgroupRrole.setResourceRoleId(NumberUtils.createBigDecimal(roleId));
				setRgroupRrole.setRgroupId(rgroupId);
				rrList.add(setRgroupRrole);
			}
		}
		if(!ArrayUtils.isEmpty(fids)){
			for(String roleId : fids){
				SetRgroupFrole setRgroupFrole = new SetRgroupFrole();
				setRgroupFrole.setFuncRoleId(NumberUtils.createBigDecimal(roleId));
				setRgroupFrole.setRgroupId(rgroupId);
				frList.add(setRgroupFrole);
			}
		}
		
		if(frList.isEmpty() && rrList.isEmpty()) {
			return groupAddDisPlay(request, response).addObject(Constants._message, "资源角色和功能角色不能同时为空");
		}
		
		SetRoleGroup setRoleGroup = new SetRoleGroup();
		setRoleGroup.setRgroupId(rgroupId);
		setRoleGroup.setRgroupName(groupName);
		
		roleGroupSerivce.create(setRoleGroup, frList, rrList);
		
		return groupAddDisPlay(request, response).addObject(Constants._message, "创建成功");
		
	}
	
	/**
	 * @Description 角色组编辑
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView groupUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ridStr = this.findStringParameterValue(request,"rids");
		String fidStr = this.findStringParameterValue(request,"fids");
		String groupName = this.findStringParameterValue(request,"groupName");
		BigDecimal rgroupId = this.findBigDecimalParameterValue(request,"rgroupId");
		
		if(rgroupId == null){
			return groupUpdateDisPlay(request, response).addObject(Constants._message, "角色组主键为空");
		}
		
		if(StringUtils.isBlank(groupName)){
			return groupUpdateDisPlay(request, response).addObject(Constants._message, "角色组名称为空");
		}
		
		String[] rids = null;
		String[] fids = null;
		if(!StringUtils.isBlank(ridStr)){
			rids = ridStr.split(",");
		}
		
		if(!StringUtils.isBlank(fidStr)){
			fids = fidStr.split(",");
		}
		
		List<SetRgroupRrole> rrList = new ArrayList<SetRgroupRrole>();
		List<SetRgroupFrole> frList = new ArrayList<SetRgroupFrole>();
		
		if(!ArrayUtils.isEmpty(rids)){
			for(String roleId : rids){
				SetRgroupRrole setRgroupRrole = new SetRgroupRrole();
				setRgroupRrole.setResourceRoleId(NumberUtils.createBigDecimal(roleId));
				setRgroupRrole.setRgroupId(rgroupId);
				rrList.add(setRgroupRrole);
			}
		}
		if(!ArrayUtils.isEmpty(fids)){
			for(String roleId : fids){
				SetRgroupFrole setRgroupFrole = new SetRgroupFrole();
				setRgroupFrole.setFuncRoleId(NumberUtils.createBigDecimal(roleId));
				setRgroupFrole.setRgroupId(rgroupId);
				frList.add(setRgroupFrole);
			}
		}
		
		if(frList.isEmpty() && rrList.isEmpty()) {
			return groupUpdateDisPlay(request, response).addObject(Constants._message, "资源角色和功能角色不能同时为空");
		}
		
		SetRoleGroup setRoleGroup = new SetRoleGroup();
		setRoleGroup.setRgroupId(rgroupId);
		setRoleGroup.setRgroupName(groupName);
		
		roleGroupSerivce.update(setRoleGroup, frList, rrList, rgroupId);
		
		return roleGroupDisplay(request, response).addObject(Constants._message, "编辑成功");
	}
	
	/**
	 * @Description 角色删除
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView groupDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String _delData = this.findStringParameterValue(request, Constants._delData);
		if(StringUtils.isBlank(_delData)){
			return roleGroupDisplay(request, response).addObject(Constants._message, "主键为空");
		}
		
		BigDecimal rgroupId = NumberUtils.createBigDecimal(_delData);
		
		roleGroupSerivce.delete(rgroupId);
		
		return roleGroupDisplay(request, response).addObject(Constants._message, "删除成功");
	}
	
	//注入roleGroupSerivce
	private RoleGroupSerivce roleGroupSerivce;

	public void setRoleGroupSerivce(RoleGroupSerivce roleGroupSerivce) {
		this.roleGroupSerivce = roleGroupSerivce;
	}

}
