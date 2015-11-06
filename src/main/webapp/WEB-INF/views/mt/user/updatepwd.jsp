<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>通用后台管理系统-修改密码</title>
	</head>
<body>	
	<pack:script src="updatepwd.js" />
	<div class="container" style="width: 90%">
		<form id="pwd_form" class="form-horizontal" action="user_read.html" method="POST">
			<input type="hidden" name="opt" value="updatePwd" />
			<fieldset>
			<legend>修改密码</legend>
			<input id="contextpath" type="hidden" value='<%=pageContext.getServletContext().getContextPath()%>/'/> 
			<input id="flag" type="hidden" value='${flag}'/>
			<div class="control-group">
				<label class="control-label" for="oldpwd">原密码</label>
				<div class="controls">
					<input type="password" id="oldpwd" name="oldpwd" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="newpwd">新密码</label>
				<div class="controls">
					<input type="password" id="newpwd" name="newpwd" />
					<span style="color: #468847;margin-left: 10px;">密码长度必须大于等于8位字符，且需要由大小写字母和数字组成。</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="surenewpwd">确认新密码</label>
				<div class="controls">
							<!-- <input type="password" name="surenewpwd" maxlength="32" id="surenewpwd" autocomplete="off" /> -->
					<input type="password" id="surenewpwd" name="surenewpwd" />
				</div>
			</div>
			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<input type="button" id="formsubmit" class="btn btn-primary" value="确定"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" id="back" class="btn btn-danger" value="返回"/>
				</div>
			</div>
		</fieldset>
		</form>
	</div>
	
	<jsp:include page="../../common/login-footer.jsp"/>
</body>
</html>