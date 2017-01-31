<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>MovieLibrary</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-func.js"></script>

<!--[if IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script>
	function initializeDropdown() {
		$('.dropdown-toggle').dropdown();
	}
</script>

</head>
<body onload="initializeDropdown();">
	<!-- START PAGE SOURCE -->
	<div id="shell">
		<div id="header">
			<h1 id="logo">
				<a href="#">MovieLibrary</a>
			</h1>
			<div class="social">
				<span>FOLLOW US ON:</span>
				<ul>
					<li><a class="twitter" href="#">twitter</a></li>
					<li><a class="facebook" href="#">facebook</a></li>
					<li><a class="vimeo" href="#">vimeo</a></li>
					<li><a class="rss" href="#">rss</a></li>
				</ul>
			</div>
			<div id="navigation">
				<ul>
					<li><a class="active" href="#">HOME</a></li>
					<li><a href="#">CONTACT</a></li>
					<li><a href="#">SIGN UP</a></li>
					<li><a href="#">LOGIN</a></li>
				</ul>
			</div>
			<div id="sub-navigation">
				<ul>
					<c:forEach items="${categoryList}" var="category">
						<li class="dropdown">
						<a class="dropdown-toggle" id="dLabel-${category.name}" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
							<ul class="dropdown-menu" aria-labelledby="dLabel-${category.name}">
								<c:forEach items="${subcategoryList}" var="subcategory">
									<li ><a style="color:BLACK;" href="<c:url value='/displayProduct?categoryId=${category.id}&subCategoryId=${subcategory.id}'/>">${subcategory.name}</a></li>
								</c:forEach>
							</ul></li>
					</c:forEach>
				</ul>
				<div id="search">
					<form action="#" method="get" accept-charset="utf-8">
						<label for="search-field">SEARCH</label> <input type="text"
							name="search field" value="Enter search here" id="search-field"
							class="blink search-field" /> <input type="submit" value="GO!"
							class="search-button" />
					</form>
				</div>
			</div>
		</div>
		<div id="main">
			<div id="content">
			
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
		<div id="footer">
			<p class="lf">
				Copyright &copy; 2017 <a href="#">SiteName</a> - All Rights Reserved
			</p>
			<p class="rf">
				Design by <a href="#">Deepika Patne</a>
			</p>
			<div style="clear: both;"></div>
		</div>
	</div>
	<!-- END PAGE SOURCE -->
</body>
</html>