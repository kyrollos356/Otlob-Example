<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user/login.css" />
<script
	src="${pageContext.request.contextPath}/js/user/loginvalidation.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<header:emptyheader />
<title>Login</title>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="midcontainer ">
				<div class="midwell">
					<p class="ptitle">Login</p>
					<div class="middle">
						<form action="login" name="myform"
							onSubmit="return click_handler()" method="POST">
							<div style="margin-top: 25px; margin-bottom: 30px"
								class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input id="email"
									type="email" class="form-control" name="email" value=""
									placeholder="email">
							</div>
							<p>
								<%=request.getSession().getAttribute("alert")%></p>
							<div style="margin-top: 30px; margin-bottom: 30px"
								class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input id="password"
									type="password" class="form-control" name="password"
									placeholder="password">
							</div>
							<h1>
								<button style="margin-top: 15px; margin-bottom: 25px"
									type="submit" value="submit"
									class="signbtn badge-pill badge-success">Login</button>
								<br>
							</h1>
		
							<p>Don't have an account? <a href="Signup">Sign up here</a> </p>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</div>
