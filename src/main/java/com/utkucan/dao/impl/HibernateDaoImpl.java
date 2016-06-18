package com.utkucan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utkucan.dao.HibernateDao;
import com.utkucan.model.CargoModel;
import com.utkucan.model.MainCategoryModel;
import com.utkucan.model.ProductModel;
import com.utkucan.model.SubCategoryModel;
import com.utkucan.model.UserModel;
import com.utkucan.util.HibernateUtil;

public class HibernateDaoImpl implements HibernateDao {

	@Override
	public void save(Object entity) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(entity);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Object entity) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public void update(Object entity) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public List findAll(Class clazz) {
		List objects = null;
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query query = session.createQuery("from " + clazz.getName());
			objects = query.list();

		} catch (Exception e) {
			transaction.rollback();// TODO: handle exception
		}
		transaction.commit();
		return objects;
	}

	@Override
	public List<UserModel> getUserByUserEmail(String email) {
		Session session = HibernateUtil.openSession();
		UserModel user = null;
		Transaction transaction = session.getTransaction();
		List<UserModel> list = new ArrayList<UserModel>();
		try {

			transaction.begin();
			String srg = "SELECT * FROM TBL_USER WHERE USER_EMAIL='" + email + "'";
			Query query = session.createSQLQuery(srg).addEntity(UserModel.class);
			list = (List<UserModel>) query.list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<MainCategoryModel> getCategoryById(int ID) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.getTransaction();
		List<MainCategoryModel> list = new ArrayList<MainCategoryModel>();
		try {

			transaction.begin();
			String hql = "FROM MainCategoryModel TBL WHERE TBL.mainCategoryId = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", ID);
			list = query.list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<SubCategoryModel> getSubCategoryById(int ID) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.getTransaction();
		List<SubCategoryModel> list = new ArrayList<SubCategoryModel>();
		try {

			transaction.begin();
			String hql = "FROM SubCategoryModel TBL WHERE TBL.subCategoryId = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", ID);
			list = query.list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<UserModel> getAllUser() {
		Session session = HibernateUtil.openSession();
		UserModel user = null;
		Transaction transaction = session.getTransaction();
		List<UserModel> list = new ArrayList<UserModel>();
		try {

			transaction.begin();
			List query = session.createCriteria(ProductModel.class).list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public int getAjax() {
		int sayi = 0;
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.getTransaction();
		try {

			transaction.begin();
			Query query = session.createQuery("select count(tbl) from OrderModel tbl");
			sayi = ((Long) query.uniqueResult()).intValue();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sayi;
	}

	public List<UserModel> getAllUser2() {
		Session session = HibernateUtil.openSession();
		UserModel user = null;
		Transaction transaction = session.getTransaction();
		List<UserModel> list = new ArrayList<UserModel>();
		try {

			transaction.begin();
			String srg = "SELECT * FROM TBL_USER";
			Query query = session.createSQLQuery(srg).addEntity(UserModel.class);
			list = (List<UserModel>) query.list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<CargoModel> getAllCargo() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.getTransaction();
		List<CargoModel> list = new ArrayList<CargoModel>();
		try {

			transaction.begin();
			String srg = "SELECT * FROM TBL_CARGO";
			Query query = session.createSQLQuery(srg).addEntity(CargoModel.class);
			list = (List<CargoModel>) query.list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<CargoModel> getCargoByID(int ID) {
		Session session = HibernateUtil.openSession();
		CargoModel cargo = null;
		Transaction transaction = session.getTransaction();
		List<CargoModel> list = new ArrayList<CargoModel>();
		try {

			transaction.begin();
			String srg = "SELECT * FROM TBL_CARGO WHERE CARGO_ID='" + ID + "'";
			Query query = session.createSQLQuery(srg).addEntity(CargoModel.class);
			list = (List<CargoModel>) query.list();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public ProductModel getProductByID(int ID) {
		Session session = HibernateUtil.openSession();
		ProductModel pModel = null;
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			pModel = (ProductModel) session.get(ProductModel.class, ID);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pModel;
	}
}
