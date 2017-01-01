
function showHiddenForm(){
	$("#checkDiv").show();
}

function isAvailable(vehicleId){	
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
	var startDate = $("#checkoutDate").val();
	var endDate = $("#returnDate").val();
	$.ajax({
		url : contextRoot + '/vehicleRest/checkAvailability',
		type : 'POST',
		data : {
			'vehicleId' : vehicleId,
			'checkoutDate' : startDate,
			'returnDate' : endDate
		},
		success : function(successObject){			
			console.log("Success");
			console.log(successObject);
			if(successObject){
				$("#yes").show();
				$("#book").show();
			}else{
				$("#no").show();
			}
		},
		error: function(jqXHR,  textStatus,  exception ){
			alert("Error...!");	
			}
	});
	
}