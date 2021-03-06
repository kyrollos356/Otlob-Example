package com.poet.ordering.system.service;

import java.util.List;
import com.poet.ordering.system.dao.imp.order.OrderRequestDAOImp;
import com.poet.ordering.system.model.User;

public class SendEmailsToSubscribers {

	OrderRequestDAOImp orderRequestDAOImp = new OrderRequestDAOImp();
	
	public void sendEmailsCreateOrder (User user, int orderRequestId) {
		try {
			List<User> users = orderRequestDAOImp.selectUserFollowers(user.getId());
			SendMailTLS sendMailTLS = new SendMailTLS();
			sendMailTLS.sendMailCreateOrder(users, user.getFullname(), orderRequestId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmailsCancelOrder (User user) {
		try {
			List<User> users = orderRequestDAOImp.selectUserFollowers(user.getId());
			SendMailTLS sendMailTLS = new SendMailTLS();
			sendMailTLS.sendMailCancelOrder(users, user.getFullname());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
