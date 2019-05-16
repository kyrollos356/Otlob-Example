<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/basic.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/profile.css" />
<title>Profile</title>
<header:header />
<div class="container">
	<div class="row">
		<div class="title">
			<c:choose>
				<c:when test="${userSelected.id==user.id}">	Hi,<i
						class="name"> ${user.firstname}</i>
					&emsp;
					<a href="/profile/edit" style="color: black;"><span
						class="glyphicon glyphicon-edit"></span></a>
				</c:when>
				<c:otherwise>
				<div class="col-sm-3 col-sm-offset-9">
					<form action="/profile?id=${userSelected.id}" method="post">

						<button name="subscribed" class="bigsubbtn"
							value="${subscribed ? 'Unscubscribe' :'Subscribe'}">${subscribed ? 'Unscubscribe' :'Subscribe'}</button>
					</form>
				
				</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<c:choose>
				<c:when test="${userSelected.picture=='http://nb-fawad:9090/usersProfileImages/null'}">
						<img class="profile-img" src="http://nb-fawad:9090/usersProfileImages/user.jpg">
				</c:when>
				<c:otherwise>
				<img class="profile-img" src="${userSelected.picture}">
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-sm-6 ">
			<div class="username">
				<p>${userSelected.fullname }</p>
			</div>
			<div class="skypeemail">
				<p>Skype ID: ${userSelected.skypeID}</p>
				<p>Email: ${userSelected.email}</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="panelcustom">

				<div class="panel-heading">Subscriptions</div>
				<div class="scrollbox">
					<c:forEach var="user2" items="${Subscriptions}">


						<a class="list-group-item" href="/profile?id=${user2.id}">${user2.fullname}</a>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 col-sm-offset-9">
			<div class="panelcustom">
				<div class="panel-heading">Subscribers</div>
				<div class="scrollbox">
					<c:forEach var="user2" items="${Subscribers}">

						<a class="list-group-item" href="/profile?id=${user2.id}">${user2.fullname}</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="well" style="display: inline-block;">
			<div class="media">
				<a class="pull-left" href="#"> </a>
				<div class="media-body">
					<h4 class="media-heading">Restaurant Name:
						<a href=/OrderRequest?id=${orderRequest.id}>${orderRequest.restaurantName}</a></h4>
					<p>Expires: ${orderRequest.timeout}</p>
					<p>Currently: ${orderRequest.status}</p>
				</div>
			</div>
		</div>
	</div>
</div>
</html>