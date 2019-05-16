$(document).ready(function() {
	$(function() {
	
	});
});
function clear_popup(){	$('#fullname').popover("hide");
$('#email').popover("hide");
$('#password').popover("hide");




}

function click_handler() {

	var fullname = document.forms["NewUser"]["fullname"].value;
	var email = document.forms["NewUser"]["email"].value;

	var skype = document.forms["NewUser"]["skypeID"].value;

	if (fullname == "") {
		alert("Please input fullname");
		return false;
	}

	if (email == "") {
		alert("Please input email");
		return false;
	}

	if (skype == "") {
		alert("Please input Skype ID");
		return false;
	}
	if (fullname.match("([a-zA-Z]+\\s+)([a-zA-Z]+\\s*)+") == null) {
		$('#fullname').popover("show");
		return false;
	}
	if(email.match("[a-zA-Z0-9._%+-]+\\@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")==null)
{	$('#email').popover("show");
return false;		
}

	return true;
}