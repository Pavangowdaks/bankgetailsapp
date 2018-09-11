<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Details</title>
</head>
<body>
<%-- Bank Details = ${BankDetails }   --%>
<h1>Bank List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>IFSC</th><th>BankID</th><th>Branch</th><th>Address</th><th>City</th><th>District</th>
<th>State</th><th>BankName</th></tr>  
   <c:forEach items="${BankDetails }" var="bank" >   
   <tr>  
   <td>${bank.ifsc}</td>  
   <td>${bank.bankid}</td>  
   <td>${bank.branch}</td>  
   <td>${bank.address}</td> 
   <td>${bank.city}</td>  
   <td>${bank.district}</td>  
   <td>${bank.state}</td>  
   <td>${bank.bankname}</td>   
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   
   <a href="/">Home page</a>  

</body>
</html>