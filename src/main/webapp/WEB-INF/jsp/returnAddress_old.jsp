
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>USPS Return</title>
</head>
<%@ page import="java.util.Date" %>

<body>
<CENTER>
<img src="co1.png" alt="VerifyAddress" class="default-logo" height="100" width="250">
<H1 CLASS="TableTitlePar">Address Verification Service</H1>


<form action="submitAddress.html" method="get">
<h3>Status:</h3>
<p>${msg}</p>

<p>
<c:if test="${not empty Address2}">
Address         : ${Address2}
</c:if>

</p>

<p>
<c:if test="${not empty Address1}">
	          ${Address1}
</c:if>
</p>
<p>
<c:if test="${not empty City}">
City         : ${City}
</c:if>
</p>
<p>
<c:if test="${not empty State}">
State         : ${State}
</c:if>
</p>
<p>
<c:if test="${not empty Zip5}">
Zip5         : ${Zip5}
</c:if>
</p>
<p>
<c:if test="${not empty Zip4}">
Zip4         : ${Zip4}
</c:if>
</p>
<input type="submit" value="Verify Another Address">
</form>

<br><br>
<br><br>
<br><br>
</form>

<strong>Current Time is</strong>: <%=new Date() %>
</CENTER>
</body>
</html>