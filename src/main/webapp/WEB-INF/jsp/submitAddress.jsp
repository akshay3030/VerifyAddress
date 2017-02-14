<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Verify Address Work</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<CENTER>
<img src="co1.png" alt="VerifyAddress" class="default-logo" height="100" width="250">
<H1 CLASS="TableTitlePar">Address Verification Service</H1>

<form action="submitAddress.html" method="post">
Address 1	: <input type="text" name="Address2" value="${Address2}"><br>
<br>
Address 2	: <input type="text" name="Address1" value="${Address1}"><br>
<br>
City	: <input type="text" name="City" value="${City}"><br>
<br>
State	: 
<select name = "State" >
       <option value="">Select A State</option>
       <option value="AL">Alabama</option>
       <option value="AK">Alaska</option>
       <option value="AZ">Arizona</option>
       <option value="AR">Arkansas</option>
       <option value="CA">California</option>
       <option value="CO">Colorado</option>
       <option value="CT">Connecticut</option>
       <option value="DE">Delaware</option>
       <option value="DC">District Of Columbia</option>
       <option value="FL">Florida</option>
       <option value="GA">Georgia</option>
       <option value="HI">Hawaii</option>
       <option value="ID">Idaho</option>
       <option value="IL">Illinois</option>
       <option value="IN">Indiana</option>
       <option value="IA">Iowa</option>
       <option value="KS">Kansas</option>
       <option value="KY">Kentucky</option>
       <option value="LA">Louisiana</option>
       <option value="ME">Maine</option>
       <option value="MD">Maryland</option>
       <option value="MA">Massachusetts</option>
       <option value="MI">Michigan</option>
       <option value="MN">Minnesota</option>
       <option value="MS">Mississippi</option>
       <option value="MO">Missouri</option>
       <option value="MT">Montana</option>
       <option value="NE">Nebraska</option>
       <option value="NV">Nevada</option>
       <option value="NH">New Hampshire</option>
       <option value="NJ">New Jersey</option>
       <option value="NM">New Mexico</option>
       <option value="NY">New York</option>
       <option value="NC">North Carolina</option>
       <option value="ND">North Dakota</option>
       <option value="OH">Ohio</option>
       <option value="OK">Oklahoma</option>
       <option value="OR">Oregon</option>
       <option value="PA">Pennsylvania</option>
       <option value="RI">Rhode Island</option>
       <option value="SC">South Carolina</option>
       <option value="SD">South Dakota</option>
       <option value="TN">Tennessee</option>
       <option value="TX">Texas</option>
       <option value="UT">Utah</option>
       <option value="VT">Vermont</option>
       <option value="VA">Virginia</option>
       <option value="WA">Washington</option>
       <option value="WV">West Virginia</option>
       <option value="WI">Wisconsin</option>
       <option value="WY">Wyoming</option>   
</select>                        
                        
<br> 
<br>
Zip 5	: <input type="text" name="Zip5" value="${Zip5}" ><br>
<br>
Zip 4	: <input type="text" name="Zip4" value="${Zip4}" ><br>
<br>
<input type="submit" value="Submit">
</form>
<br>
<br>
<strong>Current Time is</strong>: <%=new Date() %>
</CENTER>
</body>
</html>
