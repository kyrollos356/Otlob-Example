<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<header:header />

<title>Create Order Request</title>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			<div class="basictext">
			<form id="order" action="/order/createRequest" method="POST"
			onsubmit="required()">
			<h1 style="font-weight: bold;">Order info:</h1>
			<hr>
			<p>Restaurant Name: ${restaurantName}</p>
			<p>Menu URL: ${restaurantMenuUrl}</p>
			<p>Phone Number: ${restaurantPhone}</p>
			<p>Address: ${restaurantAddress}</p>
			<p>Tag: ${restaurantTag}</p>

			<p>Order time out: <input id="timeout" type="datetime-local" name="timeout" required="required"/> </p>
			<h3 style="font-weight: bold;margin-bottom:20px">Add your order</h3>
			<div class="form-group">
			<textarea style="width:100%; height:85px" form="order" id="content" name="content" value="${content}"></textarea></div>
			<input type="hidden" id="restaurantid" name="restaurantid" value='${restaurantid}'>
			<button class="commonbtn" type="Submit"
				value="Submit">Create order request</button>
			

		</form>

	</div>
	</div>
	</div>
	</div>

</html>