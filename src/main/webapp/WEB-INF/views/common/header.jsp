<%@page import="com.somnus.module.maintenance.ShiroDbRealm.ShiroUser"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="com.somnus.module.defaults.web.DefaultController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<input id="HEAD_MENU" type="hidden" value="<shiro:principal property="menuInfo"/>" />	
<input id="HEAD_SERVLET_CTX_PATH" type="hidden" value="<%=pageContext.getServletContext().getContextPath()%>"/>
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a> 
			<a class="brand" href="<%=request.getContextPath()%>/default.html">
                <font color="#0044cc" face="微软雅黑">通用后台管理系统</font>
            </a>
			<div class="nav-collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
				</ul>
				<ul class="nav pull-right">
					<shiro:authenticated>
						<li class="divider-vertical"></li>
						<li><a href="#"><i class="icon-user"></i><b class="text-error">&nbsp;<shiro:principal property="userName"/></b></a></li>
					</shiro:authenticated>
					<li class="divider-vertical"></li>
					<li><a href="<%=request.getContextPath()%>/mt/user/user_read.html?opt=updatePwd">
						<i class="icon-th-list"></i>&nbsp;修改密码</a></li>	
					<li class="divider-vertical"></li>
					<li><a href="<%=request.getContextPath()%>/secure/authentication.html?opt=logout">
						<i class="icon-off"></i>&nbsp;登出</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

	var ctxPath = $("#HEAD_SERVLET_CTX_PATH").val();

	var buildMenu = function(md, r, el){
		if(r){
			$(md).each(function(i){
				$(el).append('<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-th-list"></i>&nbsp;'+ this.text +'<b class="caret"></b></a></li>');
				buildMenu(this.children, null, $(el).find("li[class=dropdown]").get(i));
			});
		}else{
			$(el).append('<ul class="dropdown-menu"></ul>');
			var ul = $(el).find("ul[class=dropdown-menu]");
			$(md).each(function(k){
				if(this.children){//叶子节点处理
					$('<li class="dropdown-submenu"><a href="#"> <i class="icon-list-alt"></i>'+ this.text +'</a></li>').appendTo(ul);

					buildMenu(this.children, null, $(ul).children("li[class=dropdown-submenu]").last());			
				}else{
					
					$('<li><a href="'+ ctxPath + this.url +'"><i class="icon-list-alt"></i>'+ this.text +'</a></li>').appendTo(ul);
				}
			});
		}
	}

	$(document).ready(function(){
		var menuData = eval($("#HEAD_MENU").val())[0].children;
		var startEl = $("ul[class=nav]").get(0);
		buildMenu(menuData, true, startEl);
	});
 
	
</script>
