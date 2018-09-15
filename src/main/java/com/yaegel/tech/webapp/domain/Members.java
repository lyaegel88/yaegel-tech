package com.yaegel.tech.webapp.domain;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class Members implements Serializable {
	
	private static final long serialVersionUID = 1482447289014543387L;

	private String customerId;
	private String customerFn;
	private String customerLn;
	private String customerAddress1;
	private String customerAddress2;
	private String customerCity;
	private String customerState;
	private String customerZip;
	private String customerPhone;
	private String customerImageUrl;
	private String customerPassword;
	private String customerRole;
	
	private MultipartFile customerImage;
	
	public Members() {
		super();
	}
	
	public Members(String customerId, String customerFn, String customerLn, String customerZip) {
		this.customerId = customerId;
		this.customerFn = customerFn;
		this.customerLn = customerLn;
		this.customerZip = customerZip;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFn() {
		return customerFn;
	}

	public void setCustomerFn(String customerFn) {
		this.customerFn = customerFn;
	}

	public String getCustomerLn() {
		return customerLn;
	}

	public void setCustomerLn(String customerLn) {
		this.customerLn = customerLn;
	}

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerZip() {
		return customerZip;
	}

	public void setCustomerZip(String customerZip) {
		this.customerZip = customerZip;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerImageUrl() {
		return customerImageUrl;
	}

	public void setCustomerImageUrl(String customerImageUrl) {
		this.customerImageUrl = customerImageUrl;
	}
	
	public MultipartFile getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(MultipartFile customerImage) {
		this.customerImage = customerImage;
	}
	
	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Members other = (Members) obj;
		if(customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 :
					customerId.hashCode());
		return result;
	}


}
