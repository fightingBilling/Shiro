<%@page import="java.util.Date"%>
<%@page import="com.somnus.module.maintenance.ShiroDbRealm.ShiroUser"%>
<%@page import="com.somnus.module.maintenance.model.SetUser"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<script type="text/javascript">
function checkpwd(){
    var pwd = $("#hidAccTranPasswd").val();
    if(pwd==null || pwd.length == 0){
    	bootbox.dialog("密码不能为空", [{
			"label" : "确定",	
			"class" : "btn-success",	
			"callback": function() {
			}
			}]);
    }else{
    	$("#login_form").submit();
    }
};
</script>
<body>
	<shiro:notAuthenticated>	
		<pack:script src="login.js" />
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<img alt="" src="images/logo/ips_chn.png" style="height: 45px; padding-top: 5px; padding-bottom: 5px;">
				</div>
			</div>
		</div>
		<center>
		  <br></br>
		  <h1>管理平台</h1>
		</center>
		<div class="container" style="width:620px; margin-top: 10px;">
			<div class="well">
				<form id="login_form" class="form-horizontal" action="secure/authentication.html" method="POST">
					<input type="hidden" name="opt" value="authenticate" />
					<input type="hidden" id="mcrypt_key" name="mcrypt_key" value="${mcrypt_key}" />
					<fieldset>
						<div id="legend">
							<legend>用户登录</legend>
						</div>
					</fieldset>
					<div class="control-group" style="margin-top: 20px;">
						<label class="control-label" for="username">用户名</label>
						<div class="controls">
							<input type="text" id="username" name="username" class="input-xlarge" maxlength="32" />
						</div>
					</div>
	
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
						  <input type="password" id="hidAccTranPasswd" name="hidAccTranPasswd"  />
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="captcha">验证码</label>
						<div class="controls">
							<div class="input-append">
								<input id="captcha" type="text" name="captcha" class="input-large" style="width:152px;" maxlength="32" />						
								<img id="captcha-img"  class="add-on" style="padding: 0px 0px;height:28px;">
								<input id="captcha-hidden" type="hidden" value="<%=pageContext.getServletContext().getContextPath()%>"/>
							</div>
						</div>
					</div> 
					
					<div class="control-group">
						<!-- Button -->
						<div class="controls" style="padding-left:10%;">
							<button type="button" onclick="javascript:checkpwd()" class="btn btn-primary">登&nbsp;&nbsp;录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</shiro:notAuthenticated>
	<jsp:include page="common/footer.jsp" />
</body>
</html>
