<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div id="header">
	<h1 id="logo">
		<a href="index">MovieLibrary</a>
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
			<li><a href="index">HOME</a></li>
			<li><a href="#">CONTACT</a></li>
			<c:choose>
		    <c:when test="${loggedOut}">
		        <li><a href="registration">SIGN UP</a></li>
      			<li><a href="login">LOGIN</a></li>
		    </c:when>    
		    <c:otherwise>
		    	<li><a>Welcome ${loggedInUser}</a></li>
		    	<c:if test="${isAdmin == false}">
			    	<li><a href="cartTable">Cart(${cartItemCount})</a></li>
		        </c:if>
		        <li><a href="logout">LOGOUT</a></li>
		        
		        
		    </c:otherwise>
		</c:choose>
			
		</ul>
	</div>
	<div id="sub-navigation">
		<ul>
		<c:choose>
		    <c:when test="${isAdmin}">
		    	<li><a href="category">Category</a></li>
			   	<li><a href="subcategory">SubCategory</a></li>
			   	<li><a href="supplier">Supplier</a></li>
			    <li><a href="product">Product</a></li>
		    </c:when>    
		    <c:otherwise>
		    	<c:forEach items="${categoryList}" var="category">
				<li class="dropdown">
				<a class="dropdown-toggle" id="dLabel-${category.name}" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
					<ul class="dropdown-menu" aria-labelledby="dLabel-${category.name}">
						<c:forEach items="${subcategoryList}" var="subcategory">
							<li ><a style="color:BLACK;" href="<c:url value='/displayProduct?categoryId=${category.id}&subCategoryId=${subcategory.id}'/>">${subcategory.name}</a></li>
						</c:forEach>
					</ul></li>
				</c:forEach>
		    </c:otherwise>
		</c:choose>
		</ul>
		<div id="search">
			<form action="search" method="get" accept-charset="utf-8">
				<label for="search-field">SEARCH</label> 
				<input type="text"name="searchKey" value="Enter search here" id="search-field"
					class="blink search-field" /> 
					<input type="submit" value="GO!"
					class="search-button" />
			</form>
		</div>
	</div>
</div>
</body>
</html>