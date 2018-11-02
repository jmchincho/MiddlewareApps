package com.middleware.app.cow.domain;

import java.util.Date;
import java.util.List;

public class Order {

	private Long id;

	private boolean deleted;

	private Date createDate;
	private Date modifyDate;

    private String paymentType;
	private String paidOrder;
	private String observations;
	private String state;

    private Double priceTotal;

	private Address address;
	
	private List<OrderDetail> orderDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaidOrder() {
		return paidOrder;
	}

	public void setPaidOrder(String paidOrder) {
		this.paidOrder = paidOrder;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}

