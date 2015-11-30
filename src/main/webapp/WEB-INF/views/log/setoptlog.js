Activator.activeCalendar("beginDate_dateDiv", {
	// 显示格式
	format : "yyyy-mm-dd"
});

Activator.activeCalendar("endDate_dateDiv", {
	// 显示格式
	format : "yyyy-mm-dd"
});


/** 日期范围校验 * */
Activator.activeValidation("form",
// 校验字段
{
	beginDate : {
		required:true,
		dateRange : "#endDate",
	    dateRange30 : "#endDate"
	},
	endDate : {
		required:true
	}
},
// 消息描述
{
});

$(document).ready(function() {
	
	setDefaultDate('beginDate',new Date());
	
	setDefaultDate('endDate',new Date());
	
	$("#listDiff").tablecloth({
			formId : "form",
			theme : "default",
			striped : true,
			bordered : true,
			hideColumns : null,
			// 自定动作项
			customOperationConfig : [
			{
				bindSubmitElement : "csvExportBk",
				type : "add",// 跳过勾选检查
				action : function(table) {
					var data = hiddenFormData('form_result');
					data["opt"] = "logCSV";
					data["csv"] = "logCSV";
			
					// 后台数据导出
					Component.csvExport({
								baseUrl : "setoptlog_read.html?opt=setOptLogCSV",
								baseParam : data
							});
				}
			},
			{
				bindSubmitElement : "tableClear",
				type : "add",// 跳过勾选检查
				action : function(table) {
					clear('form',table);
					setDefaultDate('beginDate',new Date());
					setDefaultDate('endDate',new Date());
				}
			}],

			// 分页栏设置项
			paginationConfig : {
				// 分页工具栏
				paginationBar : true,
				// 绑定含有提交分页数据的div id
				bindSubmitElement : "exPageData"
			}

		});
		
});
