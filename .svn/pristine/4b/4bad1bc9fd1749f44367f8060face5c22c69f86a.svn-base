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
<title>Search Results</title>
<div class="container">
	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">
			<c:if test="${not empty restaurants}">
				<table class="tableb" id="restaurants">
					<thead>
						<tr class="tablehead" style="font-size: 22px;">
							<th class="tabled">Restaurant Name</th>
							<th class="tabled">Menu URL</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="restaurant" items="${restaurants}">
							<tr class="tablebody">
								<td class="tabled"><a
									href="/restaurantProfile?id=<c:out value='${restaurant.id}' />"><c:out
											value="${restaurant.name}" /></a></td>
								<td class="tabled"><a href="${restaurant.menuUrl}" target="_blank" >Menu</a></td>
								<td class="tabled">
								<form action="/order/createRequest" method="get">
								<input type="hidden" id="restaurantid" name="restaurantid" value='${restaurant.id}'>
									<button class="subbtn">Create Order</button>
								</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

			<c:if
				test="${(not empty nonsubscriptions or not empty subscriptions)}">
				<table class="tableb" id="users">
					<thead>
						<tr class="tablehead" style="font-size: 22px;">
							<th class="tabled">User Name</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${nonsubscriptions}">
							<tr class="tablebody">
								<td class="tabled"><a
									href="/profile?id=<c:out value='${user.id}' />"><c:out
											value="${user.fullname}" /></a></td>
								<td></td>
								<td class="tabled">
									<form action="search" method="post">
										<input type="hidden" id="searchentry" name="searchentry"
											value="${searchentry}"> <input type="hidden"
											name="selectedUserId" value="${user.id}"> <input
											type="hidden" name="subscribedOrNot" value="Subscribe">
										<input type="hidden" name="searchfilter" id="searchfilter"
											value="${searchfilter}">
										<button id="SubscribeButton" class="subbtn">&ensp;&nbsp;Subscribe&ensp;&nbsp;</button>
									</form>
								</td>
							</tr>
						</c:forEach>
						<c:forEach var="user" items="${subscriptions}">
							<tr class="tablebody">
								<td class="tabled"><a
									href="/profile?id=<c:out value='${user.id}' />"><c:out
											value="${user.fullname}" /></a></td>
								<td></td>
								<td class="tabled">
									<form action="search" method="post">
										<input type="hidden" id="searchentry" name="searchentry"
											value="${searchentry}"> <input type="hidden"
											name="selectedUserId" value="${user.id}"> <input
											type="hidden" name="subscribedOrNot" value="Unsubscribe">
										<input type="hidden" name="searchfilter" id="searchfilter"
											value="${searchfilter}">
										<button id="SubscribeButton" class="subbtn">&nbsp;Unsubscribe</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
</body>
</html>