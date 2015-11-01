<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>.error{color:red;}</style>
</head>
<body>
	<div class="error">${error}</div>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<fieldset id="login" style="width:600px; border:1px solid #000;border-left:none;border-right:none">   
            <legend style="">用户登录</legend>   
            <p align="center">账号：<input type="text" name="username"/></p>   
            <p align="center">密码：<input type="password" name="password"/></p>   
            <p align="center"><input type="submit"  value="登录" /></p>   
        </fieldset> 
	</form>
</body>
</html>