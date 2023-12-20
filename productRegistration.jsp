<%-- 
    Document   : productRegistration
    Created on : Apr 10, 2022, 1:22:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
   
    
        <form action="ProcessBlockChainServlet" method="post">
            <div class="container"> 
                <center><h1>Product Registration Form</h1></center>
    <label for="pId"><b>Product ID:</b></label>
  <input type="text" id="pId" name="pId" placeholder="Product ID"><br><br> <br>
  <label for="pName"><b>Product Name:</b></label>
  <input type="text" id="pName" name="pName" placeholder="Product Name"><br> <br><br>
   <label for="cDetails"><b>Company Details:</b></label>
  <input type="text" id="cDetails" name="cDetails" placeholder="Company Details"> <br> <br><br>
 <label for="uDetails"><b>User Details:</b></label>
  <input type="text" id="uDetails" name="uDetails" placeholder="User Details"> <br> <br><br>
  <label for="aDetails"><b>Address Details:</b></label>
  <input type="text" id="aDetails" name="aDetails" placeholder="Address Details"><br> <br><br>
   <input type = "submit" value = "Register Product With Blockchain Entry" class="registerbtn" />
    </form>  
    </center>
    </body>
</html>
