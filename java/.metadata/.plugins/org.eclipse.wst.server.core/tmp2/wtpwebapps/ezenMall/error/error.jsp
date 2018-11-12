<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title> Error Page </title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
	  <!-- CUSTOM STYLE  -->
    <link href="${pageContext.request.contextPath}/css/error-style.css" rel="stylesheet" />
   
</head>
<jsp:useBean id="now" class="java.util.Date" />
<body>
 <div class="container">
     
   <div class="row pad-top text-center">
       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
           <h1> ERROR  </h1>
           <h2>관리자에게 문의해 주세요<BR>
				빠른시일내 복구하겠습니다.</h2>
			${now}<p>
           <a href="../index.jsp" class="btn btn-default btn-lg">  <strong> BACK TO HOME </strong></a>
       </div>

   </div>
 </div>

</body>
</html>



