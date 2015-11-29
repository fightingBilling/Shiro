<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ include file="../common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审计日志查询</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<pack:script src="setoptlog.js" />
	<div class="container" style="width: 90%">
		<form id="form" class="form-horizontal" action="setoptlog_view.html"
			method="POST">
			<input type="hidden" name="opt" value="optlogQuery" />
			<fieldset>
				<legend>审计日志查询</legend>
				<div class="row" >
					<div class="control-group span6" >
						<label class="control-label">用户名</label>
						<div class="controls">
							<div class="input-prepend">
								<input type="text" id="optUserName" name="optUserName"
									maxlength="40"
									value="<c:out value="${param.optUserName}" />" />
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="control-group span6">
						<label class="control-label">日志状态</label>
						<div class="controls">
						  <c:out value="${param.status}" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span6">
						<label class="control-label">日志类型</label>
						<div class="controls">
						  <c:out value="${param.logType}" />
						</div>
					</div>
				</div>
				<div class="row" >
                    <div class="control-group span6">
                        <label class="control-label">起始日期</label>
                        <div class="controls">
                            <div class="input-append date" id="dateBegin_dateDiv">
                                <input type="text" id="dateBegin" name="dateBegin"
                                    value="<c:out value="${param.dateBegin}"/>" class="span2 "
                                    readonly /> <span class="add-on"> <i
                                    class="icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                       <div class="control-group span6">
                        <label class="control-label">截止日期</label>
                        <div class="controls">
                             <div class="input-append date" id="dateEnd_dateDiv">
                                <input type="text" id="dateEnd" name="dateEnd"
                                    value="<c:out value="${param.dateEnd}"/>" class="span2"
                                    readonly /> <span class="add-on"> <i
                                    class="icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
				<div class="row">
					<div class="control-group">
						<!-- Button -->
						<div class="controls">
							<button type="submit" class="btn btn-success">查询</button>
						</div>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<div style="position:relative; left:5%;">
		<fieldset>
			<legend>查询结果</legend>
			<c:if test="${pageList.fullListSize > 0}">
	            <div class="row" id="optRow2">
	                 <div class="control-group span10">
	                      <button id="csvExportBk" class="btn btn-info" type="button">
	                         <i class="icon-share"></i>&nbsp;CSV后台导出
	                      </button>
<!-- 	                      <ol class="text-error"> -->
<!-- 	                         <li>下载CSV按钮将下载所有符合条件的记录，默认下载的最大数量为1000条记录</li> -->
<!-- 	                      </ol> -->
	                 </div>
	                
	            </div>
            </c:if>
			<form id="form_result" class="form-horizontal"
				action="setoptlog_view.html" method="POST">
				<input type="hidden" name="opt" value="optlogQuery" /> 
				<input type="hidden" name="dateBegin" value="${param.dateBegin }" />
				<input type="hidden" name="dateEnd" value="${param.dateEnd }" />
				<input type="hidden" name="optUserName" value="${param.optUserName }" />
				<input type="hidden" name="status" value="${param.status }" />
				<input type="hidden" name="logType" value="${param.logType }" />
				<table id="listDiff" style="white-space: nowrap;">
					<thead>
						<tr>             
							<th>登录名</th>
							<th>登录IP</th>
							<th>操作时间</th>
							<th>日志状态</th>
							<th>日志类型</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="soptlog" items="${pageList.list}">
							<tr>
								<td><c:out value="${soptlog.optUserName }" /></td>
								<td><c:out value="${soptlog.optIp }" /></td>
								<td style="white-space: nowrap;"><fmt:formatDate value="${soptlog.optDate }" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
								<td style="white-space: nowrap;">
									<c:if test="${soptlog.status == 1 }">成功</c:if>
									<c:if test="${soptlog.status == 0 }">失败</c:if>
								</td>
								<td style="white-space: nowrap;">
									<c:out value="${param.logType}" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 配合分页参数使用 -->
				<div id="exPageData">
					<input type="hidden" value="${pageList.fullListSize}" /> 
					<input name="pageSize" type="hidden" value="${pageList.objectsPerPage}" />
					<input name="page" type="hidden"
						value='<c:choose><c:when test="${pageList.pageNumber > 0}">${pageList.pageNumber}</c:when><c:otherwise>1</c:otherwise></c:choose>' />
				</div>
			</form>
		</fieldset>
	</div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>