<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="https://github.com/d8bitr/packtag" prefix="pack" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% 
	response.setHeader("Cache-Control", "no-cache, no-store"); 
	response.setHeader("Expires", "-1");
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<pack:style src="/bootstrap/css/bootstrap.css" />
<pack:style src="/bootstrap/ui/themes/base/jquery.ui.all.css" />

<!-- css若无图片引用，可pack到一起，减少请求数量 -->
<pack:style>
	<src>/bootstrap/css/bootstrap-responsive.css</src>
	<src>/bootstrap/plugin/datepicker/datepicker.css</src>
	<src>/bootstrap/plugin/tablecloth/bootstrap-tables.css</src>
	<src>/bootstrap/plugin/tablecloth/tablecloth.css</src>
	<src>/bootstrap/plugin/tablecloth/prettify.css</src>
	<src>/bootstrap/plugin/modal/bootstrap-modal.css</src>
	<src>/bootstrap/plugin/notify/bootstrap-notify.css</src>
</pack:style>

<pack:script>
	<src>/commonJS/jquery/jquery-1.8.3.js</src>	
	<src>/commonJS/jquery/jquery-ui-1.8.custom.min.js</src>	
	<src>/commonJS/jquery/jquery.form.js</src>
	<src>/commonJS/jquery/sys_dialog.js</src>		
	<src>/commonJS/jqJson/jquery.json.js</src>
	<src>/bootstrap/js/bootstrap.js</src>
	<src>/commonJS/jqValidation/jquery.validate.js</src>
	<src>/commonJS/jqValidation/additional-methods.js</src>
	<src>/commonJS/jqValidation/messages_zh.js</src>
	<src>/bootstrap/plugin/datepicker/bootstrap-datepicker.js</src>
	<src>/bootstrap/plugin/bootbox.js</src>
	<src>/bootstrap/plugin/notify/bootstrap-notify.js</src>
	<src>/bootstrap/plugin/tablecloth/jquery.tablecloth.js</src>
	<src>/bootstrap/plugin/modal/bootstrap-modal.js</src>
	<src>/bootstrap/plugin/modal/bootstrap-modalmanager.js</src>
	<src>/bootstrap/plugin/components/public.js</src>
	<src>/bootstrap/plugin/components/cascade.js</src>
	<src>/bootstrap/plugin/components/combo.js</src>
	<src>/bootstrap/plugin/components/csvexport.js</src>
	<src>/bootstrap/plugin/components/print.js</src>
	<src>/bootstrap/plugin/components/fold.js</src>
	<src>/bootstrap/plugin/components/accounting.min.js</src>
	<src>/bootstrap/plugin/activator.js</src>
	<src>/bootstrap/plugin/uuid.js</src>
	<src>/bootstrap/plugin/jquery.fixedtableheader.js</src>
	<src>/bootstrap/plugin/components/wrapReport.js</src>
	<src>/commonJS/bizJs/util.js</src>
	<src>/commonJS/bizJs/format.js</src>
	<src>/commonJS/bizJs/PassGuardCtrl.js</src>
	<src>/commonJS/jquery/ajaxfileupload.js</src>    
</pack:script>
<style type="text/css">
  th{
  	white-space:nowrap
  }
.ocx_style_first_modify{
	background-color: #fff;
    border: 1px solid #ccc;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
    transition: border 0.2s linear 0s, box-shadow 0.2s linear 0s;
    border-radius: 4px;
    color: #555;
    height: 28px;
    line-height: 20px;
    padding: 4px 6px;
    width: 280px;
}
</style>
<noscript>
	<h1>本页需要浏览器支持（启用）JavaScript</h1>
</noscript>

	
