<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 </head>
<body>
<body>
${message}
<div class="container" >

  <h1 class="well center"><center>Add Product</center></h1>
  <div class="col-lg-12 well">
    <div class="row">
    <form  action="addproduct"  method="post">  <!-- commandName="product" enctype = "multipart/form-data" -->
      <div class="col-sm-12">
        <div class="row">
          <div>
            <center><h2>Product Details</h2></center>
          </div>
          <div class="col-sm-6 form-group">
              <h4>ID</h4>
                <input type="text"  name="id" placeholder="ID" required>
              </div>

              <div class="col-sm-6 form-group">
              <h4>Name</h4>
                <input type="name" name="name" placeholder="Name" required>
              </div>
           <div class="col-sm-6 form-group">
              <h4>Stock</h4>
                <input type="number"  name="stock" placeholder="Stock" required>
              </div>


               <div class="col-sm-6 form-group">
              <h4>Price</h4>
            <input type="number"  name="price" placeholder="Price" required>
              </div>

                 <div class="col-sm-6 form-group">
              <h4>Category_Id</h4>
                 <input type="text"  name="category_id" placeholder="ID" required>
              </div>
              
              <div class="col-sm-6 form-group">
              <h4>SubCategory_Id</h4>
                 <input type="text"  name="subcategory_id" placeholder="ID" required>
              </div>

              <div class="col-sm-6 form-group">
              <h4>Supplier_Id</h4>
                <input type="text"  name="supplier_id" placeholder="ID" required>
              </div>


              <div class="col-sm-6 form-group">
              <h4>Description</h4>
                <textarea type="name"  name="description" placeholder="Description" required> </textarea>
              </div>
              
       <!--       <div class="col-sm-6 form-group">
              <h4>Image</h4>
                <input type="file"  name="image"  path="image" >
              </div>
            -->
            
            
            <div class="form-actions">
              <button type="submit" class="btn  btn-lg btn ">Add Product</button>
            </div>

        </div>
      </div>
    </form>

    <div class="form-actions " style="float: right">
              <a href="producttable">View Product</a>
            </div>
      
    </div>
  </div>
</div>

</body>
</html>




</body>
</html>