package com.poet.ordering.system.dao.restaurant;

import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.model.Tag;

public interface TagDAO {

	public void insertTag(Tag tag, Restaurant restaurant) throws Exception;
	public void editTag(Tag tag) throws Exception;
	public void deleteTag(int id) throws Exception;
	public Tag getTag(int id) throws Exception;
}
