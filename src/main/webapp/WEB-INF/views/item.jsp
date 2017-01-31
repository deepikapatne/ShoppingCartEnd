<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Product Page</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.product{
	width: 100%;
	height: 800px;
}

.product-image {
	width: 620px;
	height: 620px;
	padding-top: 40px;
	padding-left: 80px;
}

.product-details{
	width: 500px;
	height: 620px;
	background-color: white;
	float: right;
	margin-top: -580px;
    margin-right: 90px;
}

.product-details h1,h2,h3,h4,h5,p{
	margin:0;
text-transform: uppercase;
    max-width: 380px;
    letter-spacing: -1px;
    line-height: 1.1;
    padding-top: 10px;
    padding-left: 10px;
}



</style>
<body>
<div class="product">
<c:if test="${!empty selectedProduct.id}">
	<div class="product-image">
		<img src="resources/img/${product.id}.jpg">
	</div>

	<div class="product-details">
	<h1>${selectedProduct.name}</h1>
	<h5>${subcategory.name}</h5>
	<h3>price ${selectedProduct.price}</h3>
	<div style="border-bottom: 1px solid grey"></div>
	<p>${selectedProduct.description}</p>
		<br>
		<br>
	
<div class="container">

  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="background-color:grey;">QTY
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">1</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">8</a></li>
    </ul>
  </div>
</div>
<br>

<div class="col-sm-4" style="margin-left:0px;">

                          <button class="btn btn-danger btn-md" type="button" href="<c:url value='cart/add/${selectedProduct.id}'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Add to Cart</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          
                      </div>

                      <div class="col-sm-4" style="margin-left:0px;">

                          <button class="btn btn-success btn-md" type="button" href="cart_checkout">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Checkout</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          
                      </div>

	<br>
	<br>
	<br>
			<div style="border-bottom: 1px solid grey"></div>



</div>
</c:if>
</div> 
	


</body>
</html>