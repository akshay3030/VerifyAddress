<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>USPS Return Work</title>
</head>
<%@ page import="java.util.Date" %>

<body>
<CENTER>
<img src="co1.png" alt="VerifyAddress" class="default-logo" height="100" width="250">
<H1 CLASS="TableTitlePar">Address Verification Service</H1>

</CENTER>
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
<c:if test="${not empty Address2}">
  <head> 
   <meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
   <title>Google Maps Geocoding Demo 1</title> 
   <script src="http://maps.google.com/maps/api/js?sensor=false" 
           type="text/javascript"></script> 
</head> 
<body> 
   <div id="map" style="width: 400px; height: 300px;"></div> 

   <script type="text/javascript"> 

   /* var address = '3800 Golf Rd Rolling Meadows, IL 60008'; */
   var address = '${Address2} ${Address1} ${City} ${State} ${Zip5}';

   var map = new google.maps.Map(document.getElementById('map'), { 
       mapTypeId: google.maps.MapTypeId.TERRAIN,
       zoom: 15
   });

   var geocoder = new google.maps.Geocoder();

   geocoder.geocode({
      'address': address
   }, 
   function(results, status) {
      if(status == google.maps.GeocoderStatus.OK) {
         new google.maps.Marker({
            position: results[0].geometry.location,
            map: map
         });
         map.setCenter(results[0].geometry.location);
      }
   });

   </script> 
</body> 
</c:if>
<br><br>
</form>

<strong>Current Time is</strong>: <%=new Date() %>
</body>
</html>
