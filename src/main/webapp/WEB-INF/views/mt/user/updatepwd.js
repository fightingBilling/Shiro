// 校验
Activator.activeValidation("pwd_form",
// 校验字段
{
	newpwd : {
		required : true
	},
	surenewpwd : {
		required : true
	}
},
// 消息描述
		{
		});

$(document).ready(function(){
	$("#formsubmit").click(function(){
	    if(oldpwd==null || oldpwd.length == 0){
	    	bootbox.dialog("原密码不能为空", [{
				"label" : "确定",	
				"class" : "btn-success",	
				"callback": function() {
					
				}
			}]);
	    }else if(newpwd==null || newpwd.length == 0){
	    	bootbox.dialog("新密码不能为空", [{
				"label" : "确定",	
				"class" : "btn-success",	
				"callback": function() {
					
				}
				}]);
	    }else if(newpwd != surenewpwd){
	    	bootbox.dialog("密码不一致", [{
				"label" : "确定",	
				"class" : "btn-success",	
				"callback": function() {
					
				}
			}]);
	    }
	});
	
	
	$("#back").click(function(){
		if($("#flag").val()== "true") {
			window.location.href=$("#contextpath").val()+"/secure/authentication.html?opt=logout";
		}else {
			window.location.href=$("#contextpath").val()+"default.html";
		}
		
	});
});
