package com.utkucan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CARGO")
public class CargoModel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "CARGO_ID")
	private Integer CARGO_ID;

	@Column(name = "CARGO_NAME")
	private String CARGO_NAME;

	@Column(name = "DESI_PRICE")
	double DESI_PRICE;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo", cascade = CascadeType.ALL)
	private List<OrderModel> Orders;

	public Integer getCARGO_ID() {
		return CARGO_ID;
	}

	public void setCARGO_ID(Integer cARGO_ID) {
		CARGO_ID = cARGO_ID;
	}

	public String getCARGO_NAME() {
		return CARGO_NAME;
	}

	public void setCARGO_NAME(String cARGO_NAME) {
		CARGO_NAME = cARGO_NAME;
	}

	public double getDESI_PRICE() {
		return DESI_PRICE;
	}

	public void setDESI_PRICE(double dESI_PRICE) {
		DESI_PRICE = dESI_PRICE;
	}

	public CargoModel() {
		super();
	}

	public CargoModel(String cARGO_NAME, double dESI_PRICE) {
		super();
		CARGO_NAME = cARGO_NAME;
		DESI_PRICE = dESI_PRICE;
	}

	public CargoModel(Integer cARGO_ID, String cARGO_NAME, double dESI_PRICE) {
		super();
		CARGO_ID = cARGO_ID;
		CARGO_NAME = cARGO_NAME;
		DESI_PRICE = dESI_PRICE;
	}

	public CargoModel(Integer cARGO_ID2) {
		this.CARGO_ID = cARGO_ID2;
	}

}