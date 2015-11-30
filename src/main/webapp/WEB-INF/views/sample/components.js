/** 日历控件部分 **/
// 激活日历
Activator.activeCalendar("calendar_comp_div", {
	//显示格式
	format : "yyyy-mm-dd",
	//是否开启清空按钮
	enableClear: true
});
// 激活日历
Activator.activeCalendar("beginDate_div", {
	//显示格式
	format : "yyyy-mm-dd",
	//是否开启清空按钮
	enableClear: true
});

// 激活日历
Activator.activeCalendar("endDate_div", {
	//显示格式
	format : "yyyy-mm-dd",
	//是否开启清空按钮
	enableClear: true
});

Activator.activeValidation("fileupload_form",
// 校验字段
{
	fileCover : {
		required : true

	}
},
// 消息描述
{

});	

$(document).ready(function(){
	setDefaultDate('beginDate',new Date());
	
	setDefaultDate('endDate',new Date());
	
	/** combo同步加载 **/
	Component.comboBox({
		id : "single_sync_city_lv1",
		cacheId : "cascadeCache",
		fieldMapping : {value:"id", text:"cityName"}
	});
	
	/** 同步级联 **/
	Component.cascade({
		async : false,
		parentId : "sync_city_lv1",
		childId : "sync_city_lv2",
		syncConfig : {
			cacheId : "cascadeCache",
			parentFilter : function(cache){
				return $.grep(cache, function(n,i){
					return n.parentCity == "0";
				});
			},
			parentMapping : {value:"id", text:"cityName"},
			childMapping : {value:"id", text:"cityName", ref:"parentCity"}
		}
	});
	
	/** 异步级联 **/
	Component.cascade({
		async : true,
		parentId : "async_city_lv1",
		childId : "async_city_lv2",
		asyncConfig : {
			parentBaseUrl: $("#contextpath").val() + "sample/component.html?opt=s400",
			childBaseUrl: $("#contextpath").val() + "sample/component.html?opt=s400",
			parentMapping : {value:"id", text:"cityName"},
			childMapping : {value:"id", text:"cityName"}
		}
	});
	Component.cascade({
		async : true,
		parentId : "province",
		childId : "city",
		asyncConfig : {
			parentBaseUrl: $("#contextpath").val() + "sample/component.html?opt=s400",
			childBaseUrl: $("#contextpath").val() + "sample/component.html?opt=s400",
			parentMapping : {value:"id", text:"cityName"},
			childMapping : {value:"id", text:"cityName"}
		},
		callback : function(data){
			$("#province").val($("#selProvince").val());
			$("#province").change();
		},
		
		childrenCallback : function(data){
			if($("#selCity").val()){
				$("#city").val($("#selCity").val());
			}
			$("#city").valid();
		}
	});
	
	/** Label 异步加载 **/
	Component.labelLoad({
		baseUrl: $("#contextpath").val() + "sample/component.html?opt=s500",
		baseParam: {},
		parentId: "label_load_input",
		childId: "label_load_label",
		callback : function(result, child){
			var data = $.evalJSON(result);
			child.html(data.cityName);
		}
	});
	
	/** CSV 导出**/
	$("#sample").tablecloth({
			formId : "funcForm",
			theme : "default",
			striped : true,
			bordered : true,
			
			checkboxConfig : {
				checkbox : true,
				handler : function(line, checked){
					if(console){
						console.log($(line[1]).html())
						console.log(checked)
					}
				}
			},
			
			//自定动作项
			customOperationConfig : [
				{
					bindSubmitElement: "csvExport",
					type : "add",//跳过勾选检查
					action : function(table){
						//导出当页数据
						Component.csvExportCurrentPage($("#contextpath").val(), table);
					}
				},
				{
					bindSubmitElement: "csvExportBk",
					type : "add",//跳过勾选检查
					action : function(table){
						//后台数据导出
						Component.csvExport({
							baseUrl: $("#contextpath").val() + "sample/component.html",
							baseParam : {opt:"s600", aa:"test"}
						});
					}
				},
				{
					bindSubmitElement: "tableClear",
					type : "add",//跳过勾选检查
					action : function(table){
						//清空表格数据
						table.clearAll();
					}
				}/*,
				{
					bindSubmitElement: "printBk",
					type : "add",//跳过勾选检查
					action : function(table){
						Component.print({
							baseUrl: $("#contextpath").val() + "sample/print.html",
							baseParam : {opt:"s800", aa:"test"}
						});
					}
				}*/
				
			],
			

			// 分页栏设置项
			paginationConfig : {
				// 分页工具栏
				paginationBar : true,
				// 绑定含有提交分页数据的div id
				bindSubmitElement : "exPageData"
			}
		});
		
		/** 上传 **/
		$('input[id=lefile]').change(function() {
			$('#photoCover').val($(this).val());
		});
		$("#fileupload_form").find("button").click(function(){
			try{
				if($("#fileupload_form").valid()){
					$('body').modalmanager('loading');
					$("#fileupload_form").submit();			
				}				
			}catch(e){
				$('body').modalmanager('loading');
			}		
		});
		
		/** 打印 **/
		//出款文件-多页
		$("#tp1").click(function(){
			Component.print({
				baseUrl: $("#contextpath").val() + "sample/print.html",
				baseParam : {opt:"s800", total:"137", reprint: $("#drawFileReprintID").hasClass("active")}
			});		
		});
		
		//出款文件-单页
		$("#tp2").click(function(){
			Component.print({
				baseUrl: $("#contextpath").val() + "sample/print.html",
				baseParam : {opt:"s800", total:"10", reprint: $("#drawFileReprintID").hasClass("active")}
			});		
		});
		
		//退款-多页
		$("#tp3").click(function(){
			Component.print({
				baseUrl: $("#contextpath").val() + "sample/print.html",
				baseParam : {opt:"s801", total:"137", reprint: $("#refundReprintID").hasClass("active")}
			});		
		});
		
		//退款-单页
		$("#tp4").click(function(){
			Component.print({
				baseUrl: $("#contextpath").val() + "sample/print.html",
				baseParam : {opt:"s801", total:"10", reprint: $("#refundReprintID").hasClass("active")}
			});		
		});
		
		
		//折叠
		Component.fold({
			blockId : "foldID",
			foldBtnId : "foldBtnId",
			initHide : true,
			collapseText : "收起高级选项",
			expandText : "展开高级选项"
		});
		
});

/** 日期范围校验 **/
Activator.activeValidation("date_range_form",
// 校验字段
{
	beginDate : {
		required : true,
		dateRange : "#endDate"

	},
	endDate : {
		required : true
	}
},
// 消息描述
{

});