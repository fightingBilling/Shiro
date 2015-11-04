//禁用此按钮
function disableButton(id) {
	$("#" + id).attr("disabled", "disabled");
}
//启用此按钮
function enableButton(id) {
	$("#" + id).removeAttr("disabled");
}

//CSV按钮灰显设置
function showCSCButton(resultShowId,csvButtonId) {
	if ($("#" + resultShowId).val() == "true") {
		enableButton(csvButtonId);
	} else {
		disableButton(csvButtonId);
	}
}

//检查Tbody勾选项，设置按钮禁用，启用
function hasCheckInTBody(buttonId) {
	if ($("table").find("tbody>tr>td>input:checkbox")) {
		var hasCheck = false;
		$("table").find("tbody>tr>td>input:checkbox").each(function() {
			if ($(this).prop("checked")) {
				enableButton(buttonId);
				hasCheck = true;
			}
		});
		if (!hasCheck) {
			disableButton(buttonId);
		}
	} else {
		disableButton(buttonId);
	}
}

/**
 * 选中select的值
 * selectId为select标签的id
 * valueId为储存select值的标签的id
 * @param buttonId
 */
function setSelectValue(selectId,valueId) {
	var mdval = $('#'+valueId).val();
	$('#'+selectId).children().each(function(){
		if($(this).val()===mdval){
			$(this).attr("selected",'true');
		}
	});
}

/**
 * 勾选多项，将隐藏域构建成json数据
 * @param formId
 */
function buildDataForCheckbox(formId) {
	//操作当前页面选中项
	var hasChecked = false;
	var storageIds = [];
	var tableData = $("table");
	var trs = tableData.find("tbody>tr");
	tableData.find("tbody>tr>td>input:checkbox").each(function(i){
		var line = {};
		if($(this).prop("checked")) {
			hasChecked = true;
			$(trs[i]).children().each(function(j){
				if(j == 0)return;
				var columns = [1];
				
				if($.inArray(j, columns) == -1)return;
				
				line["col" + j] = $(this).html();
			});		
			storageIds.push(line);
		}; 
	});
	if (!hasChecked) {
		bootbox.alert("请选择一条记录");
		return;
	}
	$("#"+ formId).append("<input name='_storage' type='hidden' value='"+ $.toJSON({'_storage' : storageIds}) +"'/>");
}


/**
 * @param formId
 */
function hiddenFormData(formId) {
	var data = {};
	$("#"+formId+" input:hidden").each(function(i) {
		var value = $(this).val();
		if (value != '') {
			data[this.name] = value;
		}
	});
	return data;
}


function formatDate(date){
	var val = {
		d: date.getDate(),
		m: date.getMonth() + 1,
		yy: date.getFullYear().toString().substring(2),
		yyyy: date.getFullYear()
	};
	val.dd = (val.d < 10 ? '0' : '') + val.d;
	val.mm = (val.m < 10 ? '0' : '') + val.m;
	
	return val.yyyy+'-'+val.mm+'-'+val.dd;
}


function setDefaultDate(dateId,date){
    var dateObj = $("#"+ dateId);
    var dateDivObj = dateObj.parent("div");
	var curDate = dateObj.val();
	if(curDate == ''){
		var appointDate = formatDate(date);
		dateObj.val(appointDate);
		dateDivObj.datepicker("updateInput");
	}else{
		dateDivObj.datepicker("updateInput");
	}
}


function setInOfDate(dateId,dateDivId,date){
    var dateObj = $("#"+ dateId);
    var dateDivObj = $("#"+ dateDivId);
	var curDate = dateObj.val();
	if(curDate == ''){
		var appointDate = formatDate(date);
		dateObj.val(appointDate);
		dateDivObj.datepicker("updateInput");
	}
}


function selPage(listId) {
		var table = $("#"+listId);
		
		var allchkbox = $(table).find("tr>th>input:checkbox");
		var checkboxs = $(table).find("tr>td>input:checkbox");
		
		if($(allchkbox).attr("checked")){
			allchkbox.attr("checked", false);
			checkboxs.attr("checked", false);
			checkboxs.parent("td").parent("tr").children().each(function(){
				$(this).css({background:""});
			});
		}else{
			allchkbox.attr("checked", true);
			checkboxs.attr("checked", true);
			checkboxs.parent("td").parent("tr").children().each(function(){
				$(this).css({background:"#B5DAE3"});
			});
		}
}

function selPage(listId,allSel) {
		var table = $("#"+listId);
		
		var allchkbox = $(table).find("tr>th>input:checkbox");
		var checkboxs = $(table).find("tr>td>input:checkbox");
		
		if($(allchkbox).attr("checked")){
			allchkbox.attr("checked", false);
			checkboxs.attr("checked", false);
			enableButton(allSel);
			checkboxs.parent("td").parent("tr").children().each(function(){
				$(this).css({background:""});
			});
		}else{
			allchkbox.attr("checked", true);
			checkboxs.attr("checked", true);
			disableButton(allSel);
			checkboxs.parent("td").parent("tr").children().each(function(){
				$(this).css({background:"#B5DAE3"});
			});
		}
}

function selAll(listId,allName,pageSelId) {
	var table = $("#"+listId);
	
	var allchkbox = $(table).find("tr>th>input:checkbox");
	var checkboxs = $(table).find("tr>td>input:checkbox");
	
	var all = $("input[name='"+allName+"']");
	
	if($(all).val() == 'false'){
		$(all).val('true');
		allchkbox.attr("checked", true);
		checkboxs.attr("checked", true);
		disableButton(pageSelId);
		allchkbox.hide();
		checkboxs.hide();
		checkboxs.parent("td").parent("tr").children().each(function(){
			$(this).css({background:"#B5DAFF"});
		});
	}else{
		$(all).val('false');
		enableButton(pageSelId);
		allchkbox.attr("checked", false);
		checkboxs.attr("checked", false);
		allchkbox.show();
		checkboxs.show();
		checkboxs.parent("td").parent("tr").children().each(function(){
			$(this).css({background:""});
		});
	}
}

function clear(formId,table,hiddenId){
	var form = $("#"+formId);
	form.find(":text,select").each(function(i) {
			$(this).val("");
			$(this).parents('.control-group').removeClass('success');
			$(this).parents('.control-group').removeClass('error');
	});
	form.find("p").remove(".help-block");
	// 清空表格数据
	table.clearAll();
	
	if(hiddenId == 'none'){
		return;
	}
	
	$("#"+hiddenId).hide();
}

function clearOf(formId,table){
	// 清空表格数据
	table.clearAll();
}
