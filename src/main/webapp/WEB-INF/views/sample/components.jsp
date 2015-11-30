<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>控件演示页</title>
	</head>
<body>	
	<jsp:include page="../common/header.jsp"/>
	<pack:script src="components.js" />
	
	<div class="container" style="width: 90%">
		<fieldset>
			<div id="legend">
				<legend>CSV导出</legend>
			</div>
			<form id="funcForm" class="form-search" method="post" action="components.html">
				<input type="hidden" name="opt" value="s200" />
				<button id="csvExport" class="btn btn-success" type="button"><i class="icon-share"></i>&nbsp;CSV本页导出</button>
				<button id="csvExportBk" class="btn btn-info" type="button"><i class="icon-share"></i>&nbsp;CSV后台导出</button>
				<button id="tableClear" class="btn" type="button"><i class="icon-trash"></i>&nbsp;清空表格数据</button>
				<!-- <button id="printBk" class="btn" type="button"><i class="icon-print"></i>&nbsp;打印</button> -->
				<table id="sample">
					<thead>
						<tr>
							<th>城市ID</th>
							<th>城市名称</th>
							<th>隶属ID</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="setCities" items="${pageList.list}">
							<tr>
								<td><c:out value="${setCities.id}"/></td>
								<td><c:out value="${setCities.cityName}"/></td>
								<td><c:out value="${setCities.parentCity}"/></td>
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
		<form class="form-horizontal" method="POST">
			<fieldset>
				<div id="legend">
					<legend>日历控件</legend>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="input-append date" id="calendar_comp_div">
							<input type="text" id="birthday" name="birthday"
								style="width:140px;" readonly /> 
								<span class="add-on"> 
									<i class="icon-calendar"></i>								
								</span>
						</div>
					</div>
				</div>
			</fieldset>
			<!-- 这里复用 cascadeCache，有需要请新增-->
			<fieldset>
				<div id="legend">
					<legend>Combo同步加载</legend>
				</div>
				<div class="control-group">
					<div class="controls">
						<select id="single_sync_city_lv1"></select>
					</div>
				</div>
			</fieldset>
			
			
			<!-- 同步数据缓存 -->
			<input id="cascadeCache" type="hidden" value='${requestScope.lstCities}'/> 
			<fieldset>
				<div id="legend">
					<legend>级联控件(同步)</legend>
				</div>
				<div class="control-group">
					<div class="controls">
						<select id="sync_city_lv1"></select>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<select id="sync_city_lv2"></select>
					</div>
				</div>
			</fieldset>
			
			<input id="contextpath" type="hidden" value='<%=pageContext.getServletContext().getContextPath()%>/'/> 
			<!-- 遮罩节点 -->
			<div id="selectModal"></div>
			<fieldset>
				<div id="legend">
					<legend>级联控件(异步)</legend>
				</div>
				<div class="control-group">
					<div class="controls">
						<select id="async_city_lv1"></select>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<select id="async_city_lv2"></select>
					</div>
				</div>
			</fieldset>
			
			<fieldset>
				<div id="legend">
					<legend>Label异步加载</legend>
				</div>
				<div class="row">
					<div class="control-group span3.1">
						<div class="controls">
							<input id="label_load_input" name="cityId" type="text"/>
						</div>
					</div>
					<div class="control-group span4">
						<div class="controls">
							<label id="label_load_label" style="padding-top:4px;"></label>
						</div>
					</div>
				</div>			
			</fieldset>
		</form>
		
		<form id="fileupload_form" class="form-horizontal"
			action="component.html" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="opt" value="s700"/>
			<fieldset>
				<div id="legend">
					<legend>文件上传</legend>
				</div>
				<div class="control-group">
					<label class="control-label" for="fileCover">选择文件</label>
					<div class="controls">
						<input id="lefile" name="file" type="file" style="display: none">
						<div class="input-append">
							<input id="photoCover" name="fileCover" class="input-large" type="text" readonly> 
							<a class="btn" onclick="$('input[id=lefile]').click();">浏览</a>
						</div>
					</div>
				</div>
				<div class="control-group">
					<!-- Button -->
					<div class="controls">
						<button type="button" class="btn btn-danger">上传</button>
					</div>
				</div>
			</fieldset>
		</form>
		
		
		
		<form id="date_range_form" class="form-horizontal" action="component.html?opt=s200" method="POST">
			<fieldset>
				<div id="legend">
					<legend>日期范围验证</legend>
				</div>
				<div class="row">
					<div class="control-group span5">
						<label class="control-label" for="beginDate">起始日期</label>
						<div class="controls">
							<div class="input-append date" id="beginDate_div">
								<input type="text" id="beginDate" name="beginDate"
									value="${param.beginDate}" style="width:140px;" readonly /> 
									<span class="add-on"> 
										<i class="icon-calendar"></i>								
									</span>
							</div>
						</div>
					</div>				
					<div class="control-group span5">
						<label class="control-label" for="endDate">结束日期</label>
						<div class="controls">
							<div class="input-append date" id="endDate_div">
								<input type="text" id="endDate" name="endDate"
									value="${param.endDate}" style="width:140px;" readonly /> 
									<span class="add-on"> 
										<i class="icon-calendar"></i>								
									</span>
							</div>
						</div>
					</div>
				</div>
				<div class="control-group">
                    <div class="controls">
                        <select id="province" name="province"></select>
                    </div>
                    <input id="selProvince" type="hidden" value="${param.province}" />
                </div>
                <div class="control-group">
                    <div class="controls">
                        <select id="city" name="city"></select>
                    </div>
                    <input id="selCity" type="hidden" value="${param.city}" />
                </div>
				<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>		
			</fieldset>
		</form>
		
		<form  class="form-horizontal">
			<fieldset>
				<div id="legend">
					<legend>控件的隐藏与展现</legend>
				</div>
				<div class="row">
					<div class="control-group span5">
						<label class="control-label">控件1</label>
						<div class="controls">
							<input type="text" />
						</div>
					</div>				
					<div class="control-group span5">
						<label class="control-label">控件2</label>
						<div class="controls">
							<input type="text" />
						</div>
					</div>		
				</div>	
				<div id="foldID">
					<div class="row">
						<div class="control-group span5">
							<label class="control-label">控件3</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>				
						<div class="control-group span5">
							<label class="control-label">控件4</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>		
					</div>	
					<div class="row">
						<div class="control-group span5">
							<label class="control-label">控件5</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>				
						<div class="control-group span5">
							<label class="control-label">控件6</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>		
					</div>
					<div class="row">
						<div class="control-group span5">
							<label class="control-label">控件7</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>				
						<div class="control-group span5">
							<label class="control-label">控件8</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>		
					</div>
					<div class="row">
						<div class="control-group span5">
							<label class="control-label">控件9</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>				
						<div class="control-group span5">
							<label class="control-label">控件10</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>		
					</div>
				</div>
				<div class="row">
					<div class="control-group span10">
						<div class="controls">
							<button id="foldBtnId" type="button" class="btn"></button>
						</div>
					</div>	
				</div>
			</fieldset>
		</form>
		
		<form  class="form-horizontal">
			<fieldset>
				<div id="legend">
					<legend>更多功能开发中......</legend>
				</div>
				<div class="row" style="height:150px;">
					
				</div>			
			</fieldset>
		</form>
	</div>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>