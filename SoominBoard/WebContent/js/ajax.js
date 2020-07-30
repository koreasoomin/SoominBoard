//  Ajax JavaScript Library v1.0.0
  
function result_message(result_box, msg) {
	$(result_box).val(msg);	
}

function ajaxJson(url, result_box, jobj, sCB, eCB) {
    $.ajax({
        type: "post",
        url: url,
        data: JSON.stringify(jobj),
        success: function(data) {
    		if(result_box) result_message(result_box, $.trim(data));
    		if(sCB) sCB($.trim(data));
        },
        error: function(jqXHR, textStatus, errorThrown) {
        	if(result_box) result_message(result_box, $.trim(jqXHR + "\n" + textStatus + "\n" + errorThrown));
    		if(eCB) eCB($.trim(jqXHR + "\n" + textStatus + "\n" + errorThrown));
        }
      });	
}


