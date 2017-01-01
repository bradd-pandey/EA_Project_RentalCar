$(document).ready(function() {
	$(function() {
		$("#checkoutDate").datepicker({
			onSelect : function(selected) {
				$("#returnDate").datepicker("option", "minDate", selected)
			}
		});

		$("#returnDate").datepicker({
			onSelect : function(selected) {
				$("#checkoutDate").datepicker("option", "maxDate", selected)
			}

		});
	});
});