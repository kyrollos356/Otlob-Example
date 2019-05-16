<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<!DOCTYPE>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/signup.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/user/signupvalidation.js"></script>
<header:emptyheader />
<title>Signup</title>
	<div class="midcontainer">
		<div class="midwell">
			<p class="ptitle">Sign Up</p>
			<div class="middle">
				<form action="Signup" name="NewUser"
					onSubmit="return click_handler()" method="POST"
					enctype='multipart/form-data'>
					<div class="form-group">
						<br>
						<p>Full name:</p>
						<input type="text" id="fullname" name="fullname" value="${fullname}"
							 data-toggle="popover"
							data-content="Enter Your Fullname Correctly"
							data-placement="right" onfocus="clear_popup()">
						<p>Email:</p>
						<input type="text" id="email" name="email" value="${email}"
							data-toggle="popover" data-content="Invalid Email"
							data-placement="right" onfocus="clear_popup()">
						<p>${duplicateEmail}</p>
						<p>Password:</p>
						<input type="password" id="password" name="password"
							data-content="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							onfocus="clear_popup()">
						<p>Re-enter Password:</p>
						<input type="password" id="RE-pass" name="RE-pass">
						<p>Skype ID:</p>
						<input type="text" id="skypeID" name="skypeID" value="${skypeID}"
							>
							<input type="file" name="image" id="image" />
							
						<h1>
							<button type="submit" value="submit"
								class="signbtn badge-pill badge-success">Sign Up</button>
						</h1>
					</div>
				</form>
			</div>
		</div>
	</div>
