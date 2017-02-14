package com.cof.poc.cust.mgmt.controllers;

 
 
import java.net.*;
import java.io.*;
 
 
public class CallUSPSWebservice{
      
       public static void main(String[] args) throws IOException {
             //String url = "http://production.shippingapis.com/ShippingAPI.dll?API=Verify&xml=%3CAddressValidateRequest%20USERID=%22190CAPIT3898%22%3E%20%3CIncludeOptionalElements%3Etrue%3C/IncludeOptionalElements%3E%20%3CReturnCarrierRoute%3Etrue%3C/ReturnCarrierRoute%3E%20%3CAddress%20ID=%220%22%3E%20%3CFirmName%20/%3E%20%3CAddress1%20/%3E%20%3CAddress2%3E3800%20Golf%20Road%3C/Address2%3E%20%3CCity%3ERolling%20Meadows%3C/City%3E%20%3CState%3EIL%3C/State%3E%20%3CZip5%3E60008%3C/Zip5%3E%20%3CZip4%3E%3C/Zip4%3E%20%3C/Address%3E%20%3C/AddressValidateRequest%3E";
             String url ="http://production.shippingapis.com/ShippingAPI.dll?API=Verify&xml=<AddressValidateRequest USERID=\"190CAPIT3898\"> <IncludeOptionalElements>true</IncludeOptionalElements> <ReturnCarrierRoute>true</ReturnCarrierRoute> <Address ID=\"0\"> <FirmName /> <Address1 /> <Address2>3800 Golf Road</Address2> <City>Rolling Meadows</City> <State>IL</State> <Zip5>60008</Zip5> <Zip4></Zip4> </Address> </AddressValidateRequest>";
            
             getResponse(url);
       }
 
 
 
 
public static URL getURL(String url) throws IOException  {
            
       URL calling_url = new URL(url);
       //System.out.print(equity_url);
       return calling_url;
 
       }
public static String getHttpData(URL url) throws IOException  {
            
             BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
             String inputLine;
             StringBuffer strbuf = new StringBuffer();
 
       while ((inputLine = in.readLine()) != null)
       {
         
             strbuf.append(inputLine);
             strbuf.append("\n");
       }
          in.close();
                
        return strbuf.toString();
       
 
       }
      
public static String getResponse(String url) throws IOException  {
      
       String temp = getHttpData(getURL(url));
       System.out.println(temp);
       return temp;
    //System.out.println(Double.parseDouble((temp.replace(",", "")).trim()));
      
 
       }
 
      
}
      
 
 
