<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Detail APP</title>
</head>
<body>
<form action="getBankDetails">
Enter bank IFSC: <input type="text" name="ifsc" value="KARB0000122"></input>
<input type="submit" value="getBankDetailsByIfsc" />
</form>

<form action="getBankDetailsByName">
Enter bank name: <input type="text" name="bankname" value="KARNATAKA BANK LIMITED"></input>
<input type="submit" value="getBankDetailsByName"/>
</form>

<form action="getBankDetailsByCity">
Enter bank city: <input type="text" name="city" value="BANGALORE"></input>
<input type="submit" value="getBankDetailsByCity"/>
</form>

<form action="getBankDetailsByNameandCity">
Enter bank name: <input type="text" name="bankname" value="KARNATAKA BANK LIMITED"></input>
Enter bank city: <input type="text" name="city" value="BANGALORE"></input>
<input type="submit" value="getBankDetailsByNameandCity"/>
</form>

</body>
</html>