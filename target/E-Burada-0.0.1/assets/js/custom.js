$(document).ready(function() {
	window.setInterval(function() {
		$.ajax({
			url : "getAjaxSiparisSayisi",
			type : "get",
			success : function(msg){
				$("#siparisNo").html(" (" + msg + ")")
			}
		});
	}, 3000);
});