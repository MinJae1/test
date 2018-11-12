<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title> 404-error page </title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
	  <!-- CUSTOM STYLE  -->
    <link href="${pageContext.request.contextPath}/css/error-style.css" rel="stylesheet" />
   
</head>
<body>
 <div class="container">
     
   <div class="row pad-top text-center">
       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
           <h1><strong> 404 ! </strong> ERROR  </h1>
           <h3>Resource Not Found</h3>
           <a href="../index.jsp" class="btn btn-default btn-lg">  <strong> BACK TO HOME </strong></a>
       </div>

   </div>
 </div>

</body>
</html>

