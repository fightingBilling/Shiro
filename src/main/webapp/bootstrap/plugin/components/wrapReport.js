$.extend(Component, {
	/**
	 * 报表包装
	 * @param options {
	 * 		//绑定Table的ID
	 * 		bindTableID: "example",
	 *		//锁定表头行数
	 *		freezeHeaderRows: 4,
	 * 		//行可编辑
	 * 		editable : true, //true or false
	 * 		//忽略编辑列
	 * 		ignoreEditColumns : [1,2],
	 * 		//编辑后提交URL
	 * 		saveURL : "a.html",
	 * 		//发送参数
	 * 		sendParams : function(row, field){//row:当前行，field:当前更新单元格数据
	 * 			return {
	 * 				date: row.col1,
	 * 				acct: "xxxx",
	 * 				acctName: "yyyy",
	 * 				f:field
	 * 			}
	 * 		},
	 *		//列(col1...)与字段(后台传至前台的字段或数据库字段)映射
	 * 		fieldMapping : {
	 * 			col1 : "date",
	 * 			col2 : "amt1"
	 * 		}
	 * }
	 **/
	wrapReport : function(options){
		this.table = $("#" + options.bindTableID);
		if(this.table){
			this.options = options;
			//修正样式
			this._fixReportStyle();
			//表头固定
			this.table.fixedtableheader({ 
				headerrowsize: this.options.freezeHeaderRows
			}); 
			//色彩修正
			$("th").css("background-color", "#EBEBEB");
			//编辑调用
			if(this.options.editable){
				this._edit();
			}
		}
	},
	
	_fixReportStyle : function(){
		this.table.find("th").each(function(){
			$(this).css("vertical-align", "middle");
			$(this).css("text-align","center");	
		});
			
		this.table.find("td").each(function(){
			if($(this).find("input[type=checkbox]").length == 0){		
				$(this).css("text-align","right");	
			}
			$(this).css("vertical-align", "middle");
		});
		
		//间距修正
		this.table.css("margin-top","0px");
	},
	
	_edit : function(){
		var _e_me = this;
		//行编辑
		this.table.find("tr").each(function(k){
			if($(this).find("td").length > 0){
				$(this).find("td").each(function(g){
					if(_e_me.options.ignoreEditColumns != null && $.inArray(g + 1, _e_me.options.ignoreEditColumns) >= 0)return true;
					$(this).on("dblclick", function(){
						if($(this).find("input").length == 0){
							var ori = $(this).html();
							$(this).html('<input class="input-mini" type="text" value="' + ori + '" />');
							$(this).find("input").focus();
							var me = this;
							$(this).find("input").keypress(function(e){
								if(e.keyCode == 13){
									_e_me._afterEdit(me, this, g + 1, ori);
									e.preventDefault();				
								}
							});
							
							$(this).find("input").on("blur", function(){
								_e_me._afterEdit(me, this, g + 1, ori);
							});
						}						
					});
				});
			}
		});
	},
	
	_afterEdit : function(tdEl, inputEl, idx, ori){
		var me = this;
		
		var temp = $(inputEl).val();
		$(inputEl).remove();
		$(tdEl).html(temp);
		
		if($(tdEl).html() + "" == ori + "")return;
		
		var r = {};
		$(tdEl).parent("tr").find("td").each(function(l){
			r[me._mapField("col" + (l + 1))] = $(this).html();
		});
		
		var f = {};
		f[me._mapField("col" + idx)] = temp;
		this._saveData(r, f);
	},
	
	_saveData : function(r, f){
		var p = this.options.sendParams(r, f);
		$('body').modalmanager('loading');
		$.post(this.options.saveURL, p, function(data){
			var result = eval("(" + data + ")");
			
			if(result.success){
				$('.top-left').notify({
				    message: { text: '保存成功' },
				    type: "success"
				}).show();
			}else{
				$('.top-left').notify({
				    message: { text: '保存失败' },
				    type: "danger"
				}).show();
			}
			
			$('body').modalmanager('loading');
			
		}, "text");
	},
	
	_mapField : function(col){
		if(this.options.fieldMapping){
			return this.options.fieldMapping[col] != null ?  this.options.fieldMapping[col] : col;
		}else{
			return col;
		}	
	}
	
	
	
});