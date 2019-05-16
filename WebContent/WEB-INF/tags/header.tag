<%@tag description="Header" pageEncoding="UTF-8"%>

<head>
<link rel="Shortcut Icon" type="image/ico" href="${pageContext.request.contextPath}/img/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Quicksand'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/basic.css" />

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-custom">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href=/home><img src="${pageContext.request.contextPath}/img/poet.png" alt="Logo"
				height="35"></a>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Orders <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/order/requests">View Orders in Progress</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Restaurants <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/RestaurantServlet">Add a new Restaurants</a></li>
					<li><a href="/AllRestaurants">View all Restaurants</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Users <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/user/all">View all Users</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"><span
					class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/profile">View My Profile</a></li>
					<li><a href="/profile/edit">Edit Profile</a></li>
					<li><a href="/logout">Logout</a></li>
				</ul></li>
		</ul>
	</div>
</nav>



