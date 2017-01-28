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
		
		<jsp:include page="header.jsp" />
		
			<c:if test="${ShowMainPage}">
				<jsp:include page="mainpage.jsp" />
			</c:if>
			
			<c:if test="${ShowLoginPage}">
				<jsp:include page="login.jsp" />
			</c:if>	
			
			<c:if test="${ShowRegistrationPage}">
				<jsp:include page="registration.jsp" />
			</c:if>	
			
			<c:if test="${ShowProductsForSubCategory}">
				<jsp:include page="productdisplay.jsp" />
			</c:if>	
			
			<c:if test="${ShowMessage}">
				<jsp:include page="message.jsp" />
			</c:if>	
			
			<c:if test="${ShowCategory}">
				<jsp:include page="category.jsp" />
			</c:if>
			
			<c:if test="${ShowCategoryTable}">
				<jsp:include page="categorytable.jsp" />
			</c:if>
			
			<c:if test="${ShowSubCategory}">
				<jsp:include page="subcategory.jsp" />
			</c:if>
			
			<c:if test="${ShowSubCategoryTable}">
				<jsp:include page="subcategorytable.jsp" />
			</c:if>
			
			<c:if test="${ShowSupplier}">
				<jsp:include page="supplier.jsp" />
			</c:if>
			
			<c:if test="${ShowSupplierTable}">
				<jsp:include page="suppliertable.jsp" />
			</c:if>

			<c:if test="${ShowProduct}">
				<jsp:include page="product.jsp" />
			</c:if>	
			
			<c:if test="${ShowProductTable}">
				<jsp:include page="producttable.jsp" />
			</c:if>		
		<jsp:include page="footer.jsp" />
		
	</div>
	<!-- END PAGE SOURCE -->
</body>
</html>