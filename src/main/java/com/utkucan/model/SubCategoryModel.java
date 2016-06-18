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
@Table(name = "TBL_SUB_CATEGORY")
public class SubCategoryModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_CATEGORY_ID")
	private int subCategoryId;

	@Column(name = "SUB_CATEGORY_NAME")
	private String subCategoryName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MAIN_CATEGORY_ID", nullable = false)
	private MainCategoryModel mainCategoryId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subCategoryId", cascade = CascadeType.ALL)
	private List<ProductModel> Products;

	public SubCategoryModel() {
		super();
	}

	public SubCategoryModel(String subCategoryName, MainCategoryModel mainCategoryId) {
		super();
		this.subCategoryName = subCategoryName;
		this.mainCategoryId = mainCategoryId;
	}

	public SubCategoryModel(int parseInt) {
		this.subCategoryId = parseInt;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public MainCategoryModel getMainCategoryId() {
		return mainCategoryId;
	}

	public void setMainCategoryId(MainCategoryModel mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}
}
