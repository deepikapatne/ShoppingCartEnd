 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">

		<div class="box">
		
			<div class="head">
				<h3>${productCountMsg}</h3>
			</div>
				
			<c:forEach items="${productListBySubCategory}" var="product">
			
				<div class="movie">
					<div class="movie-image">
						<span class="play"><span class="name">${product.name}</span></span>
						<a href="#"><img src="resources/img/${product.name}.jpg" alt="" /></a>
					</div>
					<div class="rating">
						<p>${product.name} : Rs ${product.price}.</p>
						<p></p>
					</div>
					<div>
						<c:if test="${loggedOut == false  && isAdmin == false}">
					 		<a href="<c:url value='/addToCart?productId=${product.id}'/>">Add to cart</a>
						</c:if>
					</div>
				</div>
         	</c:forEach>
		</div>

	</div>

</body>
</html>
