<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<div id="main">
		<div class="box">
		
			<c:forEach items="${categoryList}" var="category">
			
				<div class="head">
					<h3>${category.name}</h3>
				</div>
				
				<c:forEach items="${productList}" var="product">
				
					<c:if test="${product.category_id == category.id}">
						<div class="movie">
							<div class="movie-image">
								<span class="play"><span class="name">${product.name}</span></span>
								<a href="#"><img src="resources/img/${product.name}.jpg" alt="" /></a>
							</div>
							<div class="rating">
								<p>RATING</p>
								<div class="stars">
									<div class="stars-in"></div>
								</div>
							</div>
						</div>
					</c:if>
					
				</c:forEach>
				
				<div class="cl">&nbsp;</div>
			
			</c:forEach>
			
		</div>
	<div class="cl">&nbsp;</div>
</div>
</body>
</html>