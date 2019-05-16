package com.poet.ordering.system.service.imp.restaurant;

import com.poet.ordering.system.dao.imp.restaurant.TagDAOImp;
import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.model.Tag;

public class TagServiceImp {
	
	TagDAOImp tagDAO = new TagDAOImp();
	private static TagServiceImp instance;
	
	public static TagServiceImp getInstance() {
		if (instance == null) {
			instance = new TagServiceImp();
		}
		return instance;
	}
	
	private TagServiceImp() {

	}
	
	public boolean addNewTag(Tag tag, Restaurant restaurant) throws Exception {
		tagDAO.insertTag(tag,restaurant);
		return false;
	}
	
	public Tag viewTag(int id) throws Exception {
		Tag tag= tagDAO.getTag(id);
		return tag;
	}
	
	public void editTag(Tag tag) throws Exception {
		tagDAO.editTag(tag);
	}
	
	public void deleteTag(int id) throws Exception {
		tagDAO.deleteTag(id);
	}

}
