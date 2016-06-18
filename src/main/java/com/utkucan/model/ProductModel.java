package com.utkucan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCT")
public class ProductModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PRODUCT_ID;

	@Column(name = "PRODUCT_INFO", nullable = false, length = 45)
	private String PRODUCT_INFO;

	@Column(name = "PRICE", nullable = false)
	private double PRICE;

	@Column(name = "IMAGE_RESOURCE", nullable = false)
	private String IMAGE_RESOURCE;

	@Column(name = "PRODUCT_NAME", nullable = false, length = 45)
	private String PRODUCT_NAME;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SUB_CATEGORY_ID", nullable = false)
	private SubCategoryModel subCategoryId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderModel> Orders;

	public ProductModel(int parseInt) {
		this.PRODUCT_ID = parseInt;
	}

	public ProductModel() {
		// TODO Auto-generated constructor stub
	}

	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_INFO() {
		return PRODUCT_INFO;
	}

	public void setPRODUCT_INFO(String pRODUCT_INFO) {
		PRODUCT_INFO = pRODUCT_INFO;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public String getIMAGE_RESOURCE() {
		return IMAGE_RESOURCE;
	}

	public void setIMAGE_RESOURCE(String iMAGE_RESOURCE) {
		IMAGE_RESOURCE = iMAGE_RESOURCE;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public SubCategoryModel getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategoryModel subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	@Override
	public String toString() {
		return "ProductModel [PRODUCT_ID=" + PRODUCT_ID + ", PRODUCT_INFO=" + PRODUCT_INFO + ", PRICE=" + PRICE
				+ ", IMAGE_RESOURCE=" + IMAGE_RESOURCE + ", PRODUCT_NAME=" + PRODUCT_NAME + ", subCategoryId="
				+ subCategoryId.getSubCategoryId() + "]";
	}

}
