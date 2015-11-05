<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>资金管理系统-修改密码</title>
	</head>
	
	<script type="text/javascript">
	//密码控件处理
	var pgeditor = new $.pge({
	    pgePath: "<%=pageContext.getServletContext().getContextPath()%>/ocx/",  //控件文件目录
	    pgeId: "accTranPasswd",//控件ID
	    pgeEdittype: 0,//控件类型,0星号,1明文
	    pgeEreg1: "",//输入过程中字符类型限制
	    pgeEreg2: "",	//输入完毕后字符类型判断条件
	    pgeMaxlength: 20,//允许最大输入长度
	    pgeTabindex: 2,//tab键顺序，控件在当前表单中的tabindex顺序
	    pgeClass: "ocx_style_first_modify", //控件css样式，可以设置控件框高度、长度
	    tabCallback: "input3", //火狐控件Tab键回调，设置要跳转到的ID
	    pgeOnkeydown:"" //光标在密码框内按回车键后要调用的函数，比如：提交表单的函数
	});

	//密码控件处理
	var pgeditor1 = new $.pge({
	    pgePath: "<%=pageContext.getServletContext().getContextPath()%>/ocx/",  //控件文件目录
	    pgeId: "accTranPasswd1",//控件ID
	    pgeEdittype: 0,//控件类型,0星号,1明文
	    pgeEreg1: "",//输入过程中字符类型限制
	    pgeEreg2: "",	//输入完毕后字符类型判断条件
	    pgeMaxlength: 20,//允许最大输入长度
	    pgeTabindex: 2,//tab键顺序，控件在当前表单中的tabindex顺序
	    pgeClass: "ocx_style_first_modify", //控件css样式，可以设置控件框高度、长度
	    tabCallback: "input3", //火狐控件Tab键回调，设置要跳转到的ID
	    pgeOnkeydown:"" //光标在密码框内按回车键后要调用的函数，比如：提交表单的函数
	});
	//密码控件处理
	var pgeditor2 = new $.pge({
	    pgePath: "<%=pageContext.getServletContext().getContextPath()%>/ocx/",  //控件文件目录
	    pgeId: "accTranPasswd2",//控件ID
	    pgeEdittype: 0,//控件类型,0星号,1明文
	    pgeEreg1: "",//输入过程中字符类型限制
	    pgeEreg2: "",	//输入完毕后字符类型判断条件
	    pgeMaxlength: 20,//允许最大输入长度
	    pgeTabindex: 2,//tab键顺序，控件在当前表单中的tabindex顺序
	    pgeClass: "ocx_style_first_modify", //控件css样式，可以设置控件框高度、长度
	    tabCallback: "input3", //火狐控件Tab键回调，设置要跳转到的ID
	    pgeOnkeydown:"" //光标在密码框内按回车键后要调用的函数，比如：提交表单的函数
	});
	
	
	</script>
<body>	
	<pack:script src="updatepwd.js" />
	<div class="container" style="width: 90%">
		<form id="pwd_form" class="form-horizontal" action="user_read.html" method="POST">
			<input type="hidden" name="opt" value="updatePwd" />
			<input type="hidden" id="mcrypt_key" name="mcrypt_key" value="${mcrypt_key}" />
			<fieldset>
				<legend>修改密码</legend>
			<input id="contextpath" type="hidden" value='<%=pageContext.getServletContext().getContextPath()%>/'/> 
			<input id="flag" type="hidden" value='${flag}'/>
					<div class="control-group">
						<label class="control-label" for="oldpwd">原密码</label>
						<div class="controls">
							<script type="text/javascript">pgeditor2.generate();</script>
							<input type="hidden" id="oldpwd" name="oldpwd" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="newpwd">新密码</label>
					<div class="controls">
						<script type="text/javascript">pgeditor.generate();</script>
						<input type="hidden" id="newpwd" name="newpwd" />
						<span style="color: #468847;margin-left: 10px;">密码长度必须大于等于8位字符，且需要由大小写字母和数字组成。</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="surenewpwd">确认新密码</label>
					<div class="controls">
							<!-- <input type="password" name="surenewpwd" maxlength="32" id="surenewpwd" autocomplete="off" /> -->
						<script type="text/javascript">pgeditor1.generate();</script>
						<input type="hidden" id="surenewpwd" name="surenewpwd" />
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
	
	<jsp:include page="../../common/footerlogin.jsp"/>
</body>
</html>