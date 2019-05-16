package com.poet.ordering.system.service.user;

import java.util.List;

import com.poet.ordering.system.model.User;

public interface UserService {

	public boolean addNewUser(User user) throws Exception;

	public void adminDeleteUserById(User user);

	public User findByEmailAndPassword(User user) throws Exception;

	public boolean editUserProfile(User user) throws Exception;

	public void insertInSubscription(User user1, User user2);

	public void deleteFromSubscription(User user1, User user2);

	public List<User> selectUnsubscribers(User user);

	public List<User> selectSubscribers(User user);

	public List<User> viewSubscriptionSearchResults(String search, User user);

	public List<User> viewNonSubscriptionSearchResults(String search, User user);

	public User findbyID(String id) throws Exception;

	public List<User> selectSubscriptions(User user);

	public boolean isAdmin(User user);

	public boolean checkIfSubscribed(User user, User selectedUser);

	public void setFirstname(User user);
}
