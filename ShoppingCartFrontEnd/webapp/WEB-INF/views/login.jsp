<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>

<div class="container" >

    <div id="login" class="col-lg-3 well">
        <div class="row">
        <form action="validate" method="POST">
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-sm-12 form-group">
                            <h4>E-mail ID</h4>
                                <input type="text" placeholder="Enter E-Mail Id.."
                                    class="form-control" name="emailId" required ></input>
                            </div>

                            <div class="col-sm-12 form-group">
                            <h4>Password</h4>
                                <input type="password" placeholder="Enter Password."
                                    class="form-control" name="password" required></input>
                            </div>


                            <div class="form-actions">
                            <center><button type="submit"  value="login" class="btn  btn-lg btn ">Login</button></center>
                       		</div>
                            </div>

                            </div>
        </form>
  </div>
      </div>   
       </div>    


</body>
</html>