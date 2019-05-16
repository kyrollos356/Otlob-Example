<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/restaurant/newRestaurant.css" />
<script
	src="${pageContext.request.contextPath}/js/restaurant/newRestaurantValidation.js"></script>
<title>New Restaurant</title>
<header:header />
<div class="midcontainer">
	<div class="midwell">
		<p class="ptitle">New Restaurant</p>
		<div class="middle">
			<form action="RestaurantServlet" name="newRestaurant"
				onSubmit="return click_handler()" method="POST"
				enctype="multipart/form-data">
				<p>Restaurant name:</p>
				<input placeholder="Restaurant name" type="text" id="restaurantname"
					name="restaurantname" value="${restaurantname}" required> <br>
				<p>Phone:</p>
				<input placeholder="Phone" type="number" id="phone" name="phone"
					value="${phone}" required> <br>
				<p>Address:</p>
				<input placeholder="Address" type="text" id="address" name="address"
					value="${address}" required> <br>
				<p>Tag:</p>
				<input placeholder="Tag" type="text" id="tag" name="tag"
					value="${tag}" required> <br>
				<p>Menu URL:</p>
				<input placeholder="Menu URL" type="text" id="menuurl"
					name="menuurl" value="${menuurl}"> <br> <input
					type="file" name="file" id="file" /> <br>
				<button id="addRestaurant" name="addRestaurant" type="submit"
					value="submit" class="new-restaurant-btn badge-pill badge-success">Add
					Restaurant</button>
			</form>
		</div>
	</div>
</div>
</body>

</body>
</html>