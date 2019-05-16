package com.poet.ordering.system.dao.user;

import java.util.List;

import com.poet.ordering.system.model.User;

public interface UserDAO {

	public int addNewUser(User user) throws Exception;

	public User findByEmailAndPassword(User user) throws Exception;

	public void deleteUserById(User user);

	public void insertInSubscription(User user1, User user2);

	public void deleteFromSubscription(User user1, User user2);

	public List<User> selectNonSubscriptionsByUserId(User user);

	public List<User> selectSubscriptionsByUserId(User user);

	public List<User> selectUserInSearchWhereSubscribed(String search, User user);

	public List<User> selectUserInSearchWhereNotSubscribed(String search, User user);

	public int editUserProfile(User user) throws Exception;

	public User findbyID(String id) throws Exception;

	public boolean checkIfSubscribed(User user, User selectedUser);

	public boolean selectisAdminFromUser(User user);

	public List<User> selectSubscribersByUserId(User user);

}
