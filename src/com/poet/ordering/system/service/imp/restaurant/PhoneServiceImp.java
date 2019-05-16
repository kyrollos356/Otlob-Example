package com.poet.ordering.system.service.imp.restaurant;

import com.poet.ordering.system.dao.imp.restaurant.PhoneDAOImp;
import com.poet.ordering.system.model.Phone;
import com.poet.ordering.system.model.Restaurant;

public class PhoneServiceImp {
	
	PhoneDAOImp phoneDAO = new PhoneDAOImp();
	private static PhoneServiceImp instance;
	
	public static PhoneServiceImp getInstance() {
		if (instance == null) {
			instance = new PhoneServiceImp();
		}
		return instance;
	}
	
	private PhoneServiceImp() {

	}
	
	public boolean addNewPhone(Phone phone, Restaurant restaurant) throws Exception {
		phoneDAO.insertPhone(phone, restaurant);
		return false;
	}
	
	public Phone viewPhone(int id) throws Exception {
		Phone phone= phoneDAO.getPhone(id);
		return phone;
	}
	
	public void editPhone(Phone phone) throws Exception {
		phoneDAO.editPhone(phone);
	}
	
	public void deletePhone(int id) throws Exception {
		phoneDAO.deletePhone(id);
	}

}
