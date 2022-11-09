package com.persistent.consumer.model;

import java.io.Serializable;

public class payment implements Serializable{

	private static final long serialVersionUID = 1L;
	private String paymentId;
	private String paymentDescriptions;
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentDescriptions() {
		return paymentDescriptions;
	}
	public void setPaymentDescriptions(String paymentDescriptions) {
		this.paymentDescriptions = paymentDescriptions;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDescriptions=" + paymentDescriptions + "]";
	}
	
}
