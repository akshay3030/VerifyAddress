package com.cof.poc.cust.mgmt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Address")
public class Address {
	
	@XmlElement(name = "Address1")
	private String Address1;
	@XmlElement(name = "Address2")
	private String Address2;
	@XmlElement(name = "City")
	private String City;
	@XmlElement(name = "State")
	private String State;
	@XmlElement(name = "Zip5")
	private int Zip5;
	@XmlElement(name = "Zip4")
	private int Zip4;
	
	
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String Address1) {
		this.Address1 = Address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String Address2) {
		this.Address2 = Address2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}
	public int getZip5() {
		return Zip5;
	}
	public void setZip5(int Zip5) {
		this.Zip5 = Zip5;
	}
	public int getZip4() {
		return Zip4;
	}
	public void setZip4(int Zip4) {
		this.Zip4 = Zip4;
	}
	
}
