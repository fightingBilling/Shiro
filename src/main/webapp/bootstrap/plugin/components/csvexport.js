/** csv导出 - created by caobin * */
$.extend(Component, {
	xlsExport : function(options){
		this.csvExport(options);
	},
	
	csvExport : function(options){
		var config = {
			baseUrl: options.baseUrl,
			//{xx:"11",yy:"22"}
			baseParam : options.baseParam	
		};
		
		var hiddenInputs = "";
		var o = config.baseParam;
		for(var i in o){
			hiddenInputs += ("<input name='"+ i +"' type='hidden' value='"+ o[i] +"'/>");
		}
		
		$('body').append('<form method="POST" action="'+ config.baseUrl +'">'			
				+ hiddenInputs + '</form>');
		$('body').find("form").last().submit();
		$('body').find("form").last().remove();
	},
	
	csvExportCurrentPage : function(contextPath, table){
		if(table){
			var _store = [];
			var charset = "GBK";
			table.find("tr").each(function(i){
				var _l = {line : []};
				$(this).find("th,td").each(function(){
					_l.line.push({cell : $.trim($(this).html())});
				});		
				_store.push(_l);
			});
			//console.log(_store)
			$('body').append('<form method="POST" action="'+ contextPath +'export/csvExport.html?opt=ep1000">' +
					'<input name="csvdata" type="hidden" value=\''+ $.toJSON(_store) +'\'/><input name="charset" type="hidden" value="'+ charset +'"/></form>');
			$('body').find("form").last().submit();
			$('body').find("form").last().remove();
		}
	}
});