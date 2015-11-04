/**创建Dialog*/
function createDialog(dialogObjId,url,dialogTitile,settings,extend,locationUrl){
	var defaultProperty = {resizable: true,height:400,width:600,modal: true,
		buttons: {
			"保存": function() {
				$("#"+dialogObjId).find("form").submit(); 
			},
			"取消": function() {
				$("#"+dialogObjId).dialog("close");
			}
		}
	};
	
	var newProperty = $.extend(!extend?false:extend,{}, defaultProperty, settings=!settings?{}:settings);
	$("#"+dialogObjId).remove();
	$.get(url, function(result){
	    $("<div id=\""+dialogObjId+"\" title=\""+dialogTitile+"\">"+result+"</div>").appendTo("body");
	    CreateValidate(dialogObjId,settings,$("#"+dialogObjId).find("form"),locationUrl);
		$("#"+dialogObjId).dialog(newProperty);
	 },"html");
}

function CreateValidate(dialogObjId,opinion,forObj,locationUrl){
	forObj.validate({
		rules: opinion.rules,
		messages:opinion.messages,
		submitHandler : function() {
			forObj.ajaxSubmit( {
				dataType : opinion.dataType?opinion.dataType:'text',
				success : function(data){
					$("#"+dialogObjId).dialog("close");
					alert(eval(data)); 
					opinion.callback?opinion.callback(data):'';
					window.location.href = locationUrl;
				}
			});
			return false;
	}});
}
