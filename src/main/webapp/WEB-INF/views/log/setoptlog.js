Activator.activeCalendar("dateBegin_dateDiv", {
	// 显示格式
	format : "yyyy-mm-dd"
});

Activator.activeCalendar("dateEnd_dateDiv", {
	// 显示格式
	format : "yyyy-mm-dd"
});



/** 日期范围校验 * */
Activator.activeValidation("form",
// 校验字段
{
	dateBegin : {
		required:true,
		dateRange : "#dateEnd",
	    dateRange30 : "#dateEnd"
	},
	dateEnd : {
		required:true
	}
},
// 消息描述
{
});

$(document).ready(function() {
	
	setDefaultDate('dateBegin',new Date());
	setDefaultDate('dateEnd',new Date());
		$("#listDiff").tablecloth({
			formId : "form_result",
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
								baseUrl : "setoptlog_view.html?opt=setOptLogCSV",
								baseParam : data
							});
				}
			},
			{
				bindSubmitElement : "tableClear",
				type : "add",// 跳过勾选检查
				action : function(table) {
					clear('form',table);
					setDefaultDate('dateBegin',new Date());
					setDefaultDate('dateEnd',new Date());
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
