<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="com.somnus.module.maintenance.ShiroDbRealm.ShiroUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://packtag.sf.net" prefix="pack"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<pack:style src="/bootstrap/css/bootstrap.css" />
<pack:script>
	<src>/commonJS/jquery/jquery-1.8.3.js</src>
	<src>/bootstrap/js/bootstrap.js</src>
</pack:script>
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand"  href="<%=pageContext.getServletContext().getContextPath()%>/default.html"><font
				color="#0044cc" face="微软雅黑">管理系统</font></a>
			<div class="nav-collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
				</ul>
				<ul class="nav pull-right">	
					<li class="divider-vertical"></li>
					<li><a href="<%=pageContext.getServletContext().getContextPath()%>/secure/authentication.html?opt=logout">
						<i class="icon-off"></i>&nbsp;登出</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>