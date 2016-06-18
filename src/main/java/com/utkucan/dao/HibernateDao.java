package com.utkucan.dao;

import java.util.List;

import com.utkucan.model.CargoModel;
import com.utkucan.model.MainCategoryModel;
import com.utkucan.model.ProductModel;
import com.utkucan.model.SubCategoryModel;
import com.utkucan.model.UserModel;

public interface HibernateDao {
	public void save(Object entity);

	public void delete(Object entity);

	public void update(Object entity);

	public List findAll(Class type);

	public int getAjax();

	public List<MainCategoryModel> getCategoryById(int ID);

	public List<SubCategoryModel> getSubCategoryById(int ID);

	public List<UserModel> getUserByUserEmail(String email);

	public List<UserModel> getAllUser();

	public List<UserModel> getAllUser2();

	public List<CargoModel> getAllCargo();

	public List<CargoModel> getCargoByID(int ID);

	public ProductModel getProductByID(int ID);
}
