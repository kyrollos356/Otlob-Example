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
	var password = document.forms["NewUser"]["password"].value;
	var confirm = document.forms["NewUser"]["RE-pass"].value;
	var skype = document.forms["NewUser"]["skypeID"].value;

	if (fullname == "") {
		alert("Please input fullname");
		return false;
	}

	if (email == "") {
		alert("Please input email");
		return false;
	}

	if (password == "") {
		alert("Please input password");
		return false;
	}

	if (confirm == "") {
		alert("Please renter password");
		return false;
	}

	if (skype == "") {
		alert("Please input Skype ID");
		return false;
	}

	if (confirm !== password) {
		alert("Passwords Dont match");
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
	if(password.match("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")==null)
		
		{      $('#password').popover("show");
return false;	                            }
		
	return true;
}