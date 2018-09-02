package com.sudev;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banks")
public class Bank {
	//ifsc,bank_id,branch,address,city,district,state,bank_name
	@Id
	private String ifsc;
	private int bankid;
	private String branch;
	private String address;
	private String city;
	private String district;
	private String state;
	private String bankname;
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public int getBankid() {
		return bankid;
	}
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "Bank [ifsc=" + ifsc + ", bankid=" + bankid + ", branch=" + branch + ", address=" + address + ", city="
				+ city + ", district=" + district + ", state=" + state + ", bankname=" + bankname + "]";
	}
	
	
}
