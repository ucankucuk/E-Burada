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
@Table(name = "TBL_SUPER_CATEGORY")
public class SuperCategoryModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private int categoryId;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryId", cascade = CascadeType.ALL)
	private List<MainCategoryModel> mainCategories;

	public SuperCategoryModel() {
		super();
	}

	public SuperCategoryModel(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
