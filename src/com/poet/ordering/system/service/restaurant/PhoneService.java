package com.poet.ordering.system.service.restaurant;

import com.poet.ordering.system.model.Phone;
import com.poet.ordering.system.model.Restaurant;

public interface PhoneService {

	public boolean addNewPhone(Phone phone, Restaurant restaurant) throws Exception;
	
	public Phone viewPhone(int id) throws Exception;
	
	public void editPhone(Phone phone) throws Exception;
	
	public void deletePhone(int id) throws Exception;
}
