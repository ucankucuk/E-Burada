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
@Table(name = "TBL_MAIN_CATEGORY")
public class MainCategoryModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAIN_CATEGORY_ID")
	private int mainCategoryId;

	@Column(name = "MAIN_CATEGORY_NAME")
	private String mainCategoryName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private SuperCategoryModel categoryId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mainCategoryId", cascade = CascadeType.ALL)
	private List<SubCategoryModel> subCategories;

	public MainCategoryModel() {
		super();
	}

	public MainCategoryModel(String mainCategoryName, SuperCategoryModel categoryId) {
		super();
		this.mainCategoryName = mainCategoryName;
		this.categoryId = categoryId;
	}

	public int getMainCategoryId() {
		return mainCategoryId;
	}

	public void setMainCategoryId(int mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}

	public String getMainCategoryName() {
		return mainCategoryName;
	}

	public void setMainCategoryName(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
	}

	public SuperCategoryModel getSuperCategoryId() {
		return categoryId;
	}

	public void setSuperCategoryId(SuperCategoryModel categoryId) {
		this.categoryId = categoryId;
	}

}
