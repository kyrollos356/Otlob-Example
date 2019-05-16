
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="header" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/profile.css" />
<link
	href="${pageContext.request.contextPath}/css/common/allUsersRestaurants.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/user/allUsers.css"
	rel="stylesheet">

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script
	src="${pageContext.request.contextPath}/js/common/EditableContent.js"></script>
<title>Order Request</title>
<header:header />


<c:if
	test="${orderRequest.status == 'Open' || (orderRequest.status == 'Closed' && orderRequest.userId == user.id)}">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title">
					Order Page: <i class="name">${restaurant.name}</i>
				</div>
				<c:if
					test="${orderRequest.status != 'Open' || (orderRequest.status == 'Closed' && orderRequest.userId != user.id)}">
<%-- 					<p>${orderRequest.status}</p>
 --%>
					<div class="title">
					<i class="name" style="color:#d9534f; ">Order closed</i>
					</div>
				</c:if>
			</div>
			<div class="col-sm-2 col-sm-offset-5">
				
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3 col-sm-offset-1">
				<img class="profile-img" src="/img/restaurantplaceholder.gif">
			</div>

			<div class="col-sm-6 ">
				<div class="skypeemail">
					<c:choose>
						<c:when test="${not empty restaurant.menuUrl}">
							<p>
								Menu URL: <a href="${restaurant.menuUrl}" target="_blank">Menu</a>
							</p>
						</c:when>
					</c:choose>

					<c:choose>
						<c:when test="${not empty restaurant.menuImage}">
							<p>
								Menu Image: <a href="${restaurant.menuImage}" target="_blank">Menu
									Image</a>
							</p>
						</c:when>
					</c:choose>
					<p>Addresses: ${addresses}</p>
					<p>Tags: ${tags}</p>
					<p>Phone Numbers: ${phoneNumbers}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2 col-sm-offset-10">
				<c:if test="${orderRequest.userId == user.id}">


					<form action="/OrderRequest" method="post">
						<input type="hidden" name="Cancel" value="CancelOrderRequest">
						<input type="hidden" name="orderRequestId"
							value="${orderRequest.id}">
						<button id="cancelButton" class="greenbtn">Cancel Order</button>
					</form>

				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2 col-sm-offset-10">
				<c:if
					test="${closeRequestButton != '' && orderRequest.userId == user.id}">
					<form action="/order/createRequest" name="closeRequestFrom"
						method="post">
						<input type="hidden" name="orderRequestId"
							value="${orderRequest.id}">
						<button id="SubscribeButton" name="closeRequest"
							value="${closeRequestButton}" class="subbtn">${closeRequestButton}</button>
					</form>
				</c:if>
			</div>
		</div>
		<c:set var="OrderSubmitted" scope="session"
			value="${userOrderSubmitted}" />
		<c:if test="${orderRequest.status == 'Open'}">
			<c:if test="${userOrderSubmitted == false}">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">

						<div class="subtitle">Place your order below</div>
						<form action="/OrderRequest" method="post">
							<textarea class="form-control" rows="5" id="OrderContent"
								name="OrderContent" required></textarea>
							<input type="hidden" name="SubmitOrder" value="AddOrder">
							<input type="hidden" name="orderRequestId"
								value="${orderRequest.id}">
							<button id="submitButton" class="greenbtn">Submit Order</button>
						</form>

					</div>
				</div>
			</c:if>
		</c:if>
		<br> <br>

		<div class="row">

			<table class="tableb" id="table" cellpadding="30">
				<thead>
					<tr class="tablehead">
						<th class="tabled">User name</th>
						<th class="tabled">Order Content</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="order" items="${listOrders}">
						<tr class="tablebody">
							<td class="tabled"><a class="UserURL"
								href="/profile?id=${order.userId}"> ${order.userName} </a></td>
							<td class="tabled">
								<div id="EditContent">${order.content}</div>
							</td>
							<td class="tabled"><c:if
									test="${orderRequest.status == 'Open'}">
									<c:if test="${loggedInUser.userId == order.userId}">
										<div class="row">
											<div class="col-md-12">
												<!-- <div class="well well-sm"
													style="padding: 1px; border-radius: 3px;"> -->
												<div class="text-right">
													<a class="reviewbtn" href="#reviews-anchor"
														id="open-review-box">Edit Order</a>
												</div>

												<!-- <div class="row" id="post-review-box"
														style="display: none;"> -->
												<div id="post-review-box" style="display: none;">
													<form accept-charset="UTF-8" action="/OrderRequest"
														method="post">
														<input type="hidden" name="orderRequestId"
															value="${orderRequest.id}"> <input type="hidden"
															name="EditOrder" value="EditOrder">
														<textarea class="form-control animated" cols="50"
															id="new-review" name="EditContent" rows="5">${order.content}
																</textarea>
														<div class="text-right" style="margin-top: 10px">
															<a class="btn cancelbtn" href="#" id="close-review-box"
																style="display: none;"> <span
																class="glyphicon glyphicon-remove"></span></a>
															<button class="reviewbtn" type="submit">Save</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</c:if>
								</c:if></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</div>
</c:if>
</body>
</html>