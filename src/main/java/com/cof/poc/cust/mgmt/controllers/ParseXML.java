package com.cof.poc.cust.mgmt.controllers;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {


	public static String read(String inputXML,String node,String elem) {

		//System.out.println("Inside ParseXML Method");
		System.out.println("input xml :"+inputXML);
		String retval = null;   
		//InputStream in;

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			InputStream	in = IOUtils.toInputStream(inputXML, "UTF-8");
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);


			doc.getDocumentElement().normalize();
			retval= readElementValue(doc,node,elem);



		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//System.out.println("retrun value " +retval);
		return retval;
	}



	private static String readElementValue(Document doc,String node,String elem) {
		NodeList credentials = doc.getElementsByTagName(node);
		Element cred = null;
		String val = null;

		for(int i=0; i<credentials.getLength();i++){
			cred = (Element) credentials.item(i);
			Node user = null;
			try{
				 user = cred.getElementsByTagName(elem).item(0).getFirstChild();
			}
			catch(Exception e){
				user = null;
			}
			
			if(user != null){
			val = user.getNodeValue();
			}
			else{
				val =null;
			}

		}
		return val;
	}

}

