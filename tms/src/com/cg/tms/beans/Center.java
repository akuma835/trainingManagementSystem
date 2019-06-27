package com.cg.tms.beans;

public class Center {

	public String centerId;
	public String centerName;
	public String centerAddress;

	public Center(String centerId, String centerName, String centerAddress) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.centerId==((Center)obj).centerId;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.centerId.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+centerId+" Center Name: "+centerName+" Address: "+centerAddress;
	}

}