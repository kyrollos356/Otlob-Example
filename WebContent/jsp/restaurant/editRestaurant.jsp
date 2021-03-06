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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/restaurant/newRestaurant.css" />
<header:header />
<title>Edit Restaurant</title>
<div class="midcontainer">
	<div class="midwell">
		<p class="ptitle">Edit Restaurant</p>
		<div class="middle">
			<form action="RestaurantServlet" name="editRestaurant"
				onSubmit="return click_handler()" method="POST"
				enctype="multipart/form-data">
				<input placeholder="Restaurant Id" type="hidden" id="restaurantId"
					name="restaurantId" value="${restaurantId}" required>
				<p>Restaurant name:</p>
				<input placeholder="Restaurant name" type="text" id="restaurantname"
					name="restaurantname" value="${restaurantName}" required>
				<p>Phone:</p>
				<input placeholder="Phone" type="text" id="phone" name="phone"
					value="${restaurantPhone}" required>
				<p>Address:</p>
				<input placeholder="Address" type="text" id="address" name="address"
					value="${restaurantAddress}" required>
				<p>Tag:</p>
				<input placeholder="Tag" type="text" id="tag" name="tag"
					value="${restaurantTag}" required>
				<p>Menu URL:</p>
				<input placeholder="Menu URL" type="text" id="menuurl"
					name="menuurl" value="${restaurantMenuUrl}" >
				<%-- 					<img src="D:\\restaurantimages\\<c:out value="${restaurantMenuImage}" />"/> --%>
				<br> <input type="file" name="file" id="file" /> <br>
				<button id="addRestaurant" name="addRestaurant" type="submit"
					value="edit" class="new-restaurant-btn badge-pill badge-success">Save</button>
			</form>
		</div>
	</div>
</div>
</html>