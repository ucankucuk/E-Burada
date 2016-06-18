package com.utkucan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_ORDER")
public class OrderModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID", unique = true, nullable = false)
	private int ORDER_ID;

	@Column(name = "PIECE", nullable = false)
	private int PIECE;

	@Column(name = "PRICE", nullable = false)
	private double PRICE;

	@Column(name = "ORDER_ADDRESS", nullable = false, length = 90)
	private String ORDER_ADDRESS;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_DATE", nullable = false)
	private Date ORDER_DATE;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CARGO_ID", nullable = false)
	private CargoModel cargo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserModel USER_ID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private ProductModel product;

	public int getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public int getPIECE() {
		return PIECE;
	}

	public void setPIECE(int pIECE) {
		PIECE = pIECE;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public String getORDER_ADDRESS() {
		return ORDER_ADDRESS;
	}

	public void setORDER_ADDRESS(String oRDER_ADDRESS) {
		ORDER_ADDRESS = oRDER_ADDRESS;
	}

	public Date getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(Date oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}

	public UserModel getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(UserModel uSER_ID) {
		USER_ID = uSER_ID;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public CargoModel getCargo() {
		return cargo;
	}

	public void setCargo(CargoModel cargo) {
		this.cargo = cargo;
	}

}
