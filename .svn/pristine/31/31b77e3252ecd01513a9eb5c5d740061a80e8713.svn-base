<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/common/allUsersRestaurantsSearchFilter.js"></script>
<link
	href="${pageContext.request.contextPath}/css/common/allUsersRestaurants.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/user/allUsers.css"
	rel="stylesheet">
<header:header />
<script src="SubscribeBtn.js"></script>
<title>All Users</title>
<div class="container">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4">
			<input type="search" id="search" value="" class="form-control"
				placeholder="Search Users">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="tableb" id="table" cellpadding="30">
				<thead>
					<tr class="tablehead">
						<th class="tabled">User name</th>
						<th></th>
						<c:if test="${isAdmin == true}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${Unsubscribers}">
						<tr class="tablebody">
							<td class="tabled"><a
								href="/profile?id=<c:out value='${user.id}' />"><c:out
										value="${user.fullname}" /></a></td>
							<td class="tabled">
								<form action="/user/all" method="post">
									<input type="hidden" name="idOfUserFromJSP" value="${user.id}">
									<input type="hidden" name="SubscriberOrUnsubscriber"
										value="Subscribe">
									<button id="SubscribeButton" class="subbtn">Subscribe</button>
								</form>
							</td>
							<c:if test="${isAdmin == true}">
								<td class="tabled">
									<form action="/user/all" method="post">
										<input type="hidden" name="idOfUserFromJSP" value="${user.id}">
										<input type="hidden" name="DeleteFromAdminJSP"
											value="DeleteIt">
										<button id="DeleteButton" class="subbtn">Delete</button>
									</form>
								</td>
							</c:if>
						</tr>
					</c:forEach>

					<c:forEach var="user" items="${Subscribers}">
						<tr class="tablebody">
							<td class="tabled"><a
								href="/profile?id=<c:out value='${user.id}' />"><c:out
										value="${user.fullname}" /></a></td>
							<td class="tabled">
								<form action="/user/all" method="post">
									<input type="hidden" name="idOfUserFromJSP" value="${user.id}">
									<input type="hidden" name="SubscriberOrUnsubscriber"
										value="Unsubscribe">
									<button id="SubscribeButton" class="subbtn">Unsubscribe</button>
								</form>
							</td>
							<c:if test="${isAdmin == true}">
								<td class="tabled">
									<form action="/user/all" method="post">
										<input type="hidden" name="idOfUserFromJSP" value="${user.id}">
										<input type="hidden" name="DeleteFromAdminJSP"
											value="DeleteIt">
										<button id="DeleteButton" class="subbtn">Delete</button>
									</form>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>