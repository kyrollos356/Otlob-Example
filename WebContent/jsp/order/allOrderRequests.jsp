<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>

<!DOCTYPE>

<link
	href="${pageContext.request.contextPath}/css/common/allUsersRestaurants.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/user/allUsers.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<header:header />

<title>All Open Orders</title>

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-xs-offset-0">
			<table class="tableb" id="table">
				<thead>
					<tr class="tablehead">
						<th class="tabled">Restaurant</th>
						<th class="tabled">Created by</th>
						<th class="tabled">Expiry Time</th>
						<th class="tabled"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderRequest" items="${orderRequests}">
						<tr class="tablebody">

							<td class="tabled"><a
									href="/restaurantProfile?id=<c:out value='${orderRequest.restaurantId}' />">
										<c:out value="${orderRequest.restaurantName}" /></a></td>
							<td class="tabled"><a
									href="/profile?id=<c:out value='${orderRequest.userId}' />"><c:out
											value="${orderRequest.ownerName}" /></a></td>
							<td class="tabled">${orderRequest.timeout}</td>
							<td class="tabled">
								<form action="/OrderRequest" method="get">
									<input type="hidden" name="id" value="${orderRequest.id}">
									<button class="subbtn">
										Go to order &emsp;<span
											class="glyphicon glyphicon-arrow-right"></span>
									</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>