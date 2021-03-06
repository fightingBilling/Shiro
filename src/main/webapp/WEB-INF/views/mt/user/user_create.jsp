<%@page import="java.util.List"%>
<%@page import="com.somnus.support.util.JsonUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建用户</title>
</head>
<body>
	<jsp:include page="../../common/header.jsp" />
	<pack:script src="user_create.js" />
	<form id="user_create_form" method="POST" action="user_read.html">
	<input type="hidden" id="mcrypt_key" name="mcrypt_key" value="${mcrypt_key}" />
	<!-- userName -->
	<div class="container" style="width:90%">
		<div class="control-group span2.2">
			<label class="control-label" for="user_name">用户名称</label>
			<div class="controls">
				<div class="input-prepend">
					<input type="text" id="user_name" name="user_name" maxlength="32" />
					<input name="groups" type="hidden" value='<%=JsonUtils.list2JsonString((List)(request.getAttribute("groups")))%>'/>
				</div>
			</div>
		</div>
	</div>
	<!-- password -->
	<div class="container" style="width:90%">
		<div class="control-group span2.2">
			<label class="control-label" for="userPassword">用户密码</label>
			<div class="controls">
				<div class="input-prepend">
					<input type="password" id="userPassword" name="userPassword" maxlength="32" autocomplete="off" />
				</div>
				<span style="color: #468847;margin-left: 0px;">密码长度必须大于等于8位字符，且需要由大小写字母和数字组成。</span>
			</div>
			
		</div>
	</div>
	<!-- status -->
	<div class="container" style="width:90%">
		<div class="control-group span2.2">
			<label class="control-label">状态</label>
			<div class="controls">
				<div class="btn-group" data-toggle="buttons-radio">
					<button type="button" value="1" class="btn active" >启用</button>
					<button type="button"  value="0" class="btn" >禁用</button>	
					<input name="isLeaf" type="hidden" value="1"/>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container" style="width:90%">
		<div class="control-group span2.2">
				<input type="hidden" name="opt" value="s7002" />
				<label style="text-align:center;">分配角色组</label>
				<select  size="10" style="height:200px;"></select>
				<input type="hidden" id="userName" name="userName" />
				<input type="hidden" id="password" name="password" />
				<input type="hidden" id="status" name="status"  />
				<input type="hidden" id="gids" name="gids" />
		</div>
		<div class="span0.5">
			<label style="text-align:center;">&nbsp;</label>
			<div style="padding-top:60px;">
			<button type="button" class="btn"><i class="icon-chevron-left"></i></button>
			<br/><br/>
			<button type="button" class="btn"><i class="icon-chevron-right"></i></button>
			</div>
		</div>
		<div class="span2.1">
			<label style="text-align:center;">角色组菜单</label>
			<select  size="10" style="height:200px;">
			</select>
		</div>
	</div>
	
	<!-- Button -->
	<div class="container" style="width:90%">
		<div class="span2.2">
			<button name="user_create_submit"  type="button" class="btn btn-success">创建</button>
			<a class="btn" href="user_read.html?opt=s7000" >返回</a>
		</div>
	</div>
	</form>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>