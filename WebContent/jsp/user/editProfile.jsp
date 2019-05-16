<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user/signup.css" />
<script
	src="${pageContext.request.contextPath}/js/user/editprofilevalidation.js"></script>

<header:header />
<title>Edit Profile</title>
<div class="midcontainer">
	<div class="midwell">
		<p class="ptitle">Edit Profile</p>
		<div class="middle">

			<form action="/profile/edit" name="NewUser"
				onSubmit="return click_handler()" method="POST"
				enctype='multipart/form-data'>
				<div class="form-group">
					<br>
					<p>Full name:</p>
					<input type="text" id="fullname" name="fullname"
						value="${user.fullname}" data-toggle="popover"
						data-content="Enter Your Fullname Correctly"
						data-placement="right" onfocus="clear_popup()"><br> <br>
					<p>Email:</p>
					<input type="text" id="email" name="email" value="${user.email}"
						data-toggle="popover" data-content="Invalid Email"
						data-placement="right" onfocus="clear_popup()">
					<p><%=request.getAttribute("duplicateEmail")%></p>
					<p>Skype ID:</p>
					<input type="text" id="skypeID" name="skypeID"
						value="${user.skypeID}"><br> <input type="file"
						name="image" id="image" /> <br>
					<h1>
						<button type="submit" value="submit"
							class="signbtn badge-pill badge-success">Save</button>

					</h1>
				</div>
			</form>
		</div>
	</div>
</div>
</html>