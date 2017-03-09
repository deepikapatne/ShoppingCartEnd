<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <!-- Css -->
<spring:url value="/resources/css" var="css" />
<spring:url value="/Resources/Images" var="images" />
<!--  Javascript -->
<spring:url value="/resources/js" />
 --%>
<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/lib/js/jquery.js" />"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/lib/js/bootstrap.js" />"></script>
<!-- Font-awesome -->
<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">

<head>

</head>

<body>

	<div class="message">
		<h2>Congratulations your order is successfull !!!</h2>
	</div>

	<form:form action="${flowExecutionUrl}&_eventId=finalIndex"> 
		<input type="submit" value="Continue Shopping" class="btn btn-md btn-success" />
	</form:form>
</body>
</html>