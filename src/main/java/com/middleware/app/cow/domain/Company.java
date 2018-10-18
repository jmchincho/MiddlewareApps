package com.middleware.app.cow.domain;

import java.util.List;


public class Company {

	private Long id;

	private boolean deleted;

	private String name;
	private String logo;
	private String cif;
	private String url;
	private String urlState;

    private Integer telephone;

    private List<Subcription> subcriptions;
	
	private List<Item> items;
	
	private User user;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlState() {
		return urlState;
	}

	public void setUrlState(String urlState) {
		this.urlState = urlState;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public List<Subcription> getSubcriptions() {
		return subcriptions;
	}

	public void setSubcriptions(List<Subcription> subcriptions) {
		this.subcriptions = subcriptions;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

