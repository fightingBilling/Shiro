package com.somnus.module.maintenance.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.ModelAndView;

import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.module.maintenance.model.SetUser;
import com.somnus.module.maintenance.model.SetUserRgroup;
import com.somnus.module.maintenance.service.UserGroupService;
import com.somnus.support.constant.Constants;
import com.somnus.support.shiro.ShiroHelper;
import com.somnus.support.web.controller.BaseController;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;

public class UserGroupController extends BaseController {
	
	/**
	 * @Description 显示用户组管理页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView userGroupDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
        String searchUserName = "_search_userName";
		
        String searchGroup = "_search_group";

        String userName = this.findStringParameterValue(request, searchUserName);
        String roleGroup = this.findStringParameterValue(request, searchGroup);
		log.info("search menuName: {}", new Object[] { userName });

        String searchKey = null;
        String searchValue = null;
		if (userName != null) {
		    searchKey = searchUserName;
            searchValue = userName;
        } else if (roleGroup != null) {
            searchKey = searchGroup;
            searchValue = roleGroup;
		}

		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", userName);
        params.put("roleGroup", roleGroup);
		
		Pageable pageable = null;
		
		
		if(request.getParameter("pageSize") == null){
			Integer start = findIntegerParameterValue(request, Constants._page);
			pageable = new PageRequest(start == null ? 1 : start,Constants.DEFAULT_LIMIT);
		} else {
			pageable = this.findPage(request);
		}
		
		// 查询分页记录
		Pageable result = userGroupService.queryPaged(pageable, params);
		
		//执行分页处理
		PaginatedList paginatedList = this.doPaging(result, pageable.getPageStart(), pageable.getPageLimit());
		
		return createMAV("/mt/user/user_read")
				.addObject("_search_key", searchKey)
                .addObject("_search_value", searchValue)
				.addObject("pageList", paginatedList);
	}
	
	/**
	 * @Description 显示角色组创建/编辑页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView userPersistenceDisplay(HttpServletRequest request,
	        HttpServletResponse response) throws Exception{
		String subBtn = this.findStringParameterValue(request, "subBtn");
		if(subBtn.equals(Constants._add)){
			return userAddDisPlay(request, response);
		} else if(subBtn.equals(Constants._update)){
			return userUpdateDisPlay(request, response);
		}  else {
			return userGroupDisplay(request, response);
		}
		
	}
	
	private ModelAndView userAddDisPlay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<SetRoleGroup> groups = userGroupService.queryAll();
		HttpSession session = request.getSession();
		return createMAV("/mt/user/user_create").addObject("groups", groups);
	}
	
	private ModelAndView userUpdateDisPlay(HttpServletRequest request, 
	        HttpServletResponse response) throws Exception{
		BigDecimal userId = this.findBigDecimalParameterValue(request, "userId");
		List<SetRoleGroup> candidateResources = userGroupService.queryCandidateResource(userId);
		List<SetRoleGroup> selectedResources = userGroupService.querySelectedResource(userId);
		HttpSession session = request.getSession();
		return createMAV("/mt/user/user_update")
					.addObject("candidate_resources", candidateResources)
					.addObject("selected_resources", selectedResources)
					.addObject("userName", this.findStringParameterValue(request, "userName"))
					.addObject("status", this.findStringParameterValue(request, "status"))
					.addObject("password", this.findStringParameterValue(request, "password"))
					.addObject("userId", userId);
	}
	
	/**
	 * @Description 角色组创建
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView userGroupCreate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String gids = this.findStringParameterValue(request,"gids");
		String userName = this.findStringParameterValue(request,"userName");
		String password = request.getParameter("userPassword");
		String status = this.findStringParameterValue(request,"status");
		Date updateTime = new Date();
		
		if(StringUtils.isBlank(userName)){
			return userAddDisPlay(request, response).addObject(Constants._message, "用户名称为空");
		}
		if(StringUtils.isBlank(password)){
			return userAddDisPlay(request, response).addObject(Constants._message, "密码为空");
		}
		if(StringUtils.isBlank(status)){
			return userAddDisPlay(request, response).addObject(Constants._message, "用户状态为空");
		}
		
		
		if(StringUtils.isBlank(gids)){
			return userAddDisPlay(request, response).addObject(Constants._message, "角色组主键串为空");
		}
		
		String[] ids = gids.split(",");
		if(ArrayUtils.isEmpty(ids)){
			return userAddDisPlay(request, response).addObject(Constants._message, "角色组菜单为空");
		}
		
        SetUser setUser = userGroupService.selectByUsername(userName);

        if (setUser != null) {
            return userAddDisPlay(request, response).addObject(Constants._message, "用户名已被使用");
        }
        if(password.matches("[A-Za-z0-9]+")){
            Pattern p1= Pattern.compile("[a-z]+");
            Pattern p2= Pattern.compile("[A-Z]+");
            Pattern p3= Pattern.compile("[0-9]+");
            Matcher m=p1.matcher(password);
            if(!m.find()) {
            	return userAddDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
            }
            else{
                m.reset().usePattern(p2);
                if(!m.find()) {
                	return userAddDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
                }
                else{
                    m.reset().usePattern(p3);
                    if(!m.find()) {
                    	return userAddDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
                    }
                }
            }
        }else if(!password.matches("[A-Za-z0-9]+")){
        	return userAddDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
        }
		String userSeq = userGroupService.queryUserSeq();
		BigDecimal userId = NumberUtils.createBigDecimal(userSeq);
		
		List<SetUserRgroup> list = new ArrayList<SetUserRgroup>();
		
		for(String rgroupId : ids){
			SetUserRgroup userGroup = new SetUserRgroup();
			userGroup.setRgroupId(NumberUtils.createBigDecimal(rgroupId));
			userGroup.setUserId(userId);
			list.add(userGroup);
		}
		
		SetUser user = new SetUser();
		user.setUserId(userId);
		user.setUsername(userName);
		user.setPassword(DigestUtils.md5Hex(password));
		user.setStatus(status);
		user.setLastUpdateTime(updateTime);
		user.setLastUpdator(ShiroHelper.getUsername());
		try{
			userGroupService.create(user, list);
		}catch(Exception e){
			log.error(Constants.EXECUTE_ERROR + e.getMessage(), e);
			return userAddDisPlay(request, response).addObject(Constants._message, "用户创建失败！");
		}
		
		return userAddDisPlay(request, response).addObject(Constants._message, "创建成功");
	}
	
	
	/**
	 * @Description 角色组编辑
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zhangbo
	 */
	public ModelAndView userGroupUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String gids = this.findStringParameterValue(request,"gids");
		String userName = this.findStringParameterValue(request,"userName");
		String password = request.getParameter("userPassword");
		String status = this.findStringParameterValue(request,"status");
		BigDecimal userId = this.findBigDecimalParameterValue(request, "userId");
		Date updateTime = new Date();
		if(userId == null) {
			return userUpdateDisPlay(request, response).addObject(Constants._message, "用户主键为空");
		}
		
		if(StringUtils.isBlank(userName)){
			return userUpdateDisPlay(request, response).addObject(Constants._message, "用户名称为空");
		}
		if(StringUtils.isBlank(password)){
			return userUpdateDisPlay(request, response).addObject(Constants._message, "密码为空");
		}
		if(StringUtils.isBlank(status)){
			return userUpdateDisPlay(request, response).addObject(Constants._message, "用户状态为空");
		}
		
		
		if(StringUtils.isBlank(gids)){
			return userUpdateDisPlay(request, response).addObject(Constants._message, "角色组主键串为空");
		}
		
		String[] ids = gids.split(",");
		if(ArrayUtils.isEmpty(ids)){
			return userUpdateDisPlay(request, response).addObject(Constants._message, "角色组菜单为空");
		}
		
		SetUser user = userGroupService.queryById(userId);
		
		List<SetUserRgroup> list = new ArrayList<SetUserRgroup>();
		
		for(String rgroupId : ids){
			SetUserRgroup userGroup = new SetUserRgroup();
			userGroup.setRgroupId(NumberUtils.createBigDecimal(rgroupId));
			userGroup.setUserId(userId);
			list.add(userGroup);
		}
		
		user.setUsername(userName);
		if(!user.getPassword().equals(password)) {
			if(password.matches("[A-Za-z0-9]+")){
	            Pattern p1= Pattern.compile("[a-z]+");
	            Pattern p2= Pattern.compile("[A-Z]+");
	            Pattern p3= Pattern.compile("[0-9]+");
	            Matcher m=p1.matcher(password);
	            if(!m.find()) {
	            	return userUpdateDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
	            }
	            else{
	                m.reset().usePattern(p2);
	                if(!m.find()) {
	                	return userUpdateDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
	                }
	                else{
	                    m.reset().usePattern(p3);
	                    if(!m.find()) {
	                    	return userUpdateDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
	                    }
	                }
	            }
	        }else if(!password.matches("[A-Za-z0-9]+")){
	        	return userUpdateDisPlay(request, response).addObject(Constants._message, "密码必须要由大小写字母和数字组成");
	        }
			user.setPassword(DigestUtils.md5Hex(password));
			user.setLastUpdateTime(updateTime);
			user.setLastUpdator(ShiroHelper.getUsername());
		}
		user.setStatus(status);
		
		userGroupService.update(user, list);
		
		return userGroupDisplay(request, response).addObject(Constants._message, "编辑成功");
	}
	
	
	public ModelAndView userGroupDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BigDecimal userId = this.findBigDecimalParameterValue(request, Constants._delData);
		if(userId == null){
			return userGroupDisplay(request, response).addObject(Constants._message, "主键为空");
		}
		userGroupService.delete(userId);
		return userGroupDisplay(request, response).addObject(Constants._message, "删除成功");
	}
	
    /**
     * 修改密码
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView updatePwdView(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
        return createMAV("mt/user/updatepwd").addObject("flag", this.findStringParameterValue(request,"flag"));
    }

    public ModelAndView updatePwd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = createMAV("/mt/user/updatepwd");
        SetUser setUser = userGroupService.selectByUsername(ShiroHelper.getUsername());
		String newpwd = request.getParameter("newpwd");
        String oldpwd = request.getParameter("oldpwd");
        Date updateTime = new Date();
       
        if (!DigestUtils.md5Hex(oldpwd).equals(setUser.getPassword())) {
            return view.addObject("message", "原密码错误").addObject("flag", "false");
        } else {
            
            if(newpwd.matches("[A-Za-z0-9]+")){
                Pattern p1= Pattern.compile("[a-z]+");
                Pattern p2= Pattern.compile("[A-Z]+");
                Pattern p3= Pattern.compile("[0-9]+");
                Matcher m=p1.matcher(newpwd);
                if(!m.find()) {
                	return view.addObject("message", "密码必须要由大小写字母和数字组成").addObject("flag", "false");
                }
                else{
                    m.reset().usePattern(p2);
                    if(!m.find()) {
                    	return view.addObject("message", "密码必须要由大小写字母和数字组成").addObject("flag", "false");
                    }
                    else{
                        m.reset().usePattern(p3);
                        if(!m.find()) {
                        	return view.addObject("message", "密码必须要由大小写字母和数字组成").addObject("flag", "false");
                        }
                    }
                }
                setUser.setLastUpdateTime(updateTime);
                setUser.setPassword(DigestUtils.md5Hex(newpwd));
                setUser.setLastUpdator(ShiroHelper.getUsername());
            }else if(!newpwd.matches("[A-Za-z0-9]+")){
            	return view.addObject("message", "密码必须要由大小写字母和数字组成").addObject("flag", "false");
            }
            if (userGroupService.updatePwd(setUser) > 0){
                SecurityUtils.getSubject().logout();
                return view.addObject("message", "更新成功").addObject("flag", "true");
            } else {
                return view.addObject("message", "更新失败").addObject("flag", "false");
            }
        }
    }

	//注入userGroupService
	private UserGroupService userGroupService;

	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}
}
