<%@page import="java.util.List"%>
<%@page import="com.somnus.support.util.JsonUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑功能角色</title>
</head>
<body>
	
	<jsp:include page="../../common/header.jsp" />
	<pack:script src="role_menu_update.js" />
	<form id="role_menu_update_form" method="POST" action="role_menu_read.html">
	<!-- roleName -->
	<div class="container" style="width:99%">
		<div class="control-group span2.2">
			<label class="control-label" for="role_name">角色名称</label>
			<div class="controls">
				<div class="input-prepend">
					<input type="text" id="role_name" name="role_name" value="${roleName}" maxlength="128" />
					<input id="candidate_resources" type="hidden" value=<%=JsonUtils.list2JsonString((List)(request.getAttribute("candidate_resources")))%> />
					<input id="selected_resources" type="hidden" value=<%=JsonUtils.list2JsonString((List)(request.getAttribute("selected_resources")))%> />
				</div>
			</div>
		</div>
	</div>
	<div class="container" style="width:99%">
		<div class="control-group span1.5">
				<input type="hidden" name="opt" value="s4003" />
				<label style="text-align:center;">已加入菜单</label>
				<select size="10" style="height:200px;"></select>
				<input type="hidden" name="roleId" value="${roleId}" />
				<input type="hidden" id="roleName" name="roleName" />
				<input type="hidden" id="mids" name="mids" />
		</div>
		<div class="span0.5">
			<label style="text-align:center;">&nbsp;</label>
			<div style="padding-top:60px;">
			<button type="button" class="btn"><i class="icon-chevron-left"></i></button>
			<br/><br/>
			<button type="button" class="btn"><i class="icon-chevron-right"></i></button>
			</div>
		</div>
		<div class="span1.5">
			<label style="text-align:center;">一级菜单</label>
			<select  size="10" style="height:200px;width:170px;">
			</select>
		</div>
		<div class="span1.5">
			<label style="text-align:center;">二级菜单</label>
			<select  size="10" style="height:200px;width:170px;">
			</select>
		</div>
		<div class="span1.5">
			<label style="text-align:center;">三级菜单</label>
			<select size="10" style="height:200px;width:170px;">
			</select>
		</div>		
		<div class="span1.5">
			<label style="text-align:center;">四级菜单</label>
			<select size="10" style="height:200px;width:170px;">
			</select>
		</div>	
	</div>
	<!-- Button -->
	<div class="container" style="width:90%">
		<div class="span2.2">
			<button name="role_update_submit"  type="button" class="btn btn-success">提交</button>
			<a class="btn" href="role_menu_read.html?opt=s4000" >返回</a>
		</div>
	</div>
	</form>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>