package com.cof.poc.cust.mgmt.controllers;

import java.util.Map;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.cof.poc.cust.mgmt.Address;

@Controller
@RequestMapping("/submitAddress")
public class CallSubmitAddressController {

	@Autowired private ApplicationContext applicationContext;
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(Model model)
	
	{
		Address addr = (Address)applicationContext.getBean("addr01");		
		
		model.addAttribute("Address1", addr.getAddress1());
		model.addAttribute("Address2", addr.getAddress2());
		model.addAttribute("City", addr.getCity());
		model.addAttribute("State", addr.getState());
		model.addAttribute("Zip5", addr.getZip5());
		model.addAttribute("Zip4", addr.getZip4());
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@RequestParam Map<String,String> allRequestParams,Model modelret)
	{
		try
		{
			Address addrInp = new Address();
			
			addrInp.setAddress1(allRequestParams.get("Address1"));
			addrInp.setAddress2(allRequestParams.get("Address2"));
			addrInp.setCity(allRequestParams.get("City"));
			addrInp.setState(allRequestParams.get("State"));
			addrInp.setZip5(Integer.parseInt(allRequestParams.get("Zip5")));
			addrInp.setZip4(Integer.parseInt(allRequestParams.get("Zip4")));
			
			String Zip4s="";
			if(Integer.parseInt(allRequestParams.get("Zip4")) != 0)
				Zip4s=allRequestParams.get("Zip4").toString();
			
		
			System.out.println("Calling USPS API...");
			
			//String uri = "http://production.shippingapis.com/ShippingAPI.dll?API=Verify&xml=<AddressValidateRequest USERID='190CAPIT3898'><Address> <Address1>{Address1}</Address1> <Address2>{Address2}</Address2> <City>{City}</City> <State>{State}</State> <Zip5>{Zip5}</Zip5> <Zip4>{Zip4}</Zip4> </Address> </AddressValidateRequest>";
			//String uri = "http://production.shippingapis.com/ShippingAPI.dll?API=Verify&xml=<AddressValidateRequest USERID=\"190CAPIT3898\"><Address> <Address1>"+allRequestParams.get("Address1")+"</Address1> <Address2>"+allRequestParams.get("Address2")+"</Address2> <City>"+allRequestParams.get("City")+"</City> <State>"+allRequestParams.get("State")+"</State> <Zip5>"+allRequestParams.get("Zip5")+"</Zip5> <Zip4>"+allRequestParams.get("Zip4")+"</Zip4> </Address> </AddressValidateRequest>";
			String uri   = "http://production.shippingapis.com/ShippingAPI.dll?API=Verify&xml=<AddressValidateRequest USERID=\"190CAPIT3898\"> <IncludeOptionalElements>true</IncludeOptionalElements> <ReturnCarrierRoute>true</ReturnCarrierRoute> <Address ID=\"0\"> <FirmName ></FirmName> <Address1 >"+allRequestParams.get("Address1")+"</Address1> <Address2>"+allRequestParams.get("Address2")+"</Address2> <City>"+allRequestParams.get("City")+"</City> <State>"+allRequestParams.get("State")+"</State> <Zip5>"+allRequestParams.get("Zip5")+"</Zip5> <Zip4>"+Zip4s+"</Zip4> </Address> </AddressValidateRequest>";
			System.out.println("uri is"+uri);
			RestTemplate restTemplate = new RestTemplate();
			
			//String response = restTemplate.getForObject(uri, String.class, allRequestParams);
			String response = restTemplate.getForObject(uri, String.class);
			//response="<?xml version=\"1.0\" encoding=\"UTF-8\"?><AddressValidateResponse><Address><Address2>761 CYPRESS LN</Address2><City>CAROL STREAM</City><State>IL</State><Zip5>60188</Zip5><Zip4>9197</Zip4></Address></AddressValidateResponse>";
			System.out.println("Response: " + response);
			
			
			//
			//System.out.println("Response Received...");
			//System.out.println("Address2 : "+ParseXML.read(response, "Address", "Address2"));
			//System.out.println("Response Processed...");
			
			try{
				if(ParseXML.read(response, "Error", "Number") == null)
				{
					modelret.addAttribute("msg", "Address found successfully");
					System.out.println("Address found successfully-1");
				} else{
					modelret.addAttribute("msg", "Address not found successfully");
					System.out.println("Address not found successfully-2");
				}
				//modelret.addAttribute("msg", "Address Not found successfully");
				//modelret.addAttribute("msg", ParseXML.read(response, "Error", "Description"));
				
				}
			catch(Exception e) 		
			{
				modelret.addAttribute("msg", "Address undecided");
				System.out.println("Address undecided -3");

			};
			
			
			try{
				ParseXML.read(response, "Address", "Address1");
				modelret.addAttribute("Address1", ParseXML.read(response, "Address", "Address1"));
				}
			catch(Exception e)	{};
			
			try{
				ParseXML.read(response, "Address", "Address2");
				modelret.addAttribute("Address2", ParseXML.read(response, "Address", "Address2"));
				}
			catch(Exception e)	{};
			try{
				ParseXML.read(response, "Address", "City");
				modelret.addAttribute("City", ParseXML.read(response, "Address", "City"));
				}
			catch(Exception e)	{};
			try{
				ParseXML.read(response, "Address", "State");
				modelret.addAttribute("State", ParseXML.read(response, "Address", "State"));
				}
			catch(Exception e)	{};
			
			try{
				ParseXML.read(response, "Address", "Zip5");
				modelret.addAttribute("Zip5", ParseXML.read(response, "Address", "Zip5").toString());
				}
			catch(Exception e)	{};
			
			try{
				ParseXML.read(response, "Address", "Zip4");
				modelret.addAttribute("Zip4", ParseXML.read(response, "Address", "Zip4").toString());
				}
			catch(Exception e)	{};
			
			try{
					if(ParseXML.read(response, "Address", "Address1") == null){
						System.out.println("Address1 not found in response");
						
					}else{
						System.out.println("Address1 found in response");
						modelret.addAttribute("Address1", ParseXML.read(response, "Address", "Address1").toString());
					}
				
				}
			catch(Exception e) 		{};
			
			
					
			//modelret.addAttribute("Address1", ParseXML.read(response, "Address", "Address1").toString());
			
			/*modelret.addAttribute("Address2", ParseXML.read(response, "Address", "Address2").toString());
			modelret.addAttribute("City", ParseXML.read(response, "Address", "City").toString());
			modelret.addAttribute("State", ParseXML.read(response, "Address", "State"));
			modelret.addAttribute("Zip5", ParseXML.read(response, "Address", "Zip5"));
			modelret.addAttribute("Zip4", ParseXML.read(response, "Address", "Zip4"));*/
		}
		catch(NoSuchBeanDefinitionException e)
		{
			modelret.addAttribute("msg", "Address not found");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
		
		return "returnAddress";
	}

		
}	
