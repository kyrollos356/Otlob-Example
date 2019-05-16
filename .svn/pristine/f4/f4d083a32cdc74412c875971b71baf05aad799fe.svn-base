<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>

<link
	href="${pageContext.request.contextPath}/css/common/allUsersRestaurants.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/common/home.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/user/allUsers.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<header:header />

<title>Home</title>
<div class="container">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3">
			<form action="search" name="search" method="GET">
				<div id="custom-search-input">
					<div class="input-group col-md-12">
						<input type="text" class="form-control input-lg" name="search"
							placeholder="Search.." /> <span class="input-group-btn">
							<button class="btn btn-info btn-lg "
								style="background-color: #93b32d; border-color: #93b32d;"
								type="submit">
								<i class="glyphicon glyphicon-search"
									style="line-height: normal;"></i>
							</button>
						</span>
					</div>
				</div>
				<br>
				<div class="filterbuttons">
					<input type="radio" name="searchfilter" value="all" checked>&nbsp;All
					&emsp; <input type="radio" name="searchfilter"
						value="restaurantsonly">&nbsp;Restaurants &emsp; <input
						type="radio" name="searchfilter" value="usersonly">&nbsp;Users
				</div>
			</form>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-6 col-lg-offset-3">
			<div id="orderCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#orderCarousel" data-slide-to="0" class="active"></li>
					<c:forEach var="orderRequest" items="${orderRequests}">
						<li data-target="#orderCarousel" data-slide-to="2"></li>
					</c:forEach>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img src="${pageContext.request.contextPath}/img/padding.png">
						<div class="carousel-caption">
							<h1>Orders in progress</h1>
							<br> <br>
						</div>
					</div>
					<c:forEach var="orderRequest" items="${orderRequests}">
						<div class="item">
							<a href=/OrderRequest?id=${orderRequest.id}><img
								src="${pageContext.request.contextPath}/img/padding.png"></a>
							<div class="carousel-caption">
								<h2>${orderRequest.restaurantName}</h2>
								<p>${orderRequest.ownerName}</p>
							</div>
						</div>
					</c:forEach>
				</div>
				<a class="left carousel-control" href="#orderCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#orderCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</div>
