package com.poet.ordering.system.servlets.users;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.model.ImageUtility;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.user.UserServiceImp;

@WebServlet("/Signup")
@MultipartConfig
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImp userService = UserServiceImp.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("duplicateEmail", "");
		request.setAttribute("user", new User());

		request.getRequestDispatcher("/jsp/user/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = populateUserFields(request);

		boolean duplicateEmailOrSkype = true;

		duplicateEmailOrSkype = userService.addNewUser(user);

		if (duplicateEmailOrSkype) {
			request.setAttribute("fullname", request.getParameter("fullname"));
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("skypeID", request.getParameter("skypeID"));
			request.setAttribute("duplicateEmail", "email or skype already assigned to account!");

			request.getRequestDispatcher("/jsp/user/signup.jsp").forward(request, response);
		} else {

			ImageUtility uploader = new ImageUtility();
			uploader.uploadImage(user, request.getPart("image"));
			user = userService.findByEmailAndPassword(user);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);

		}

	}

	private User populateUserFields(HttpServletRequest request) throws IOException, ServletException {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setFullname(request.getParameter("fullname"));
		user.setPassword(request.getParameter("password"));
		user.setSkypeID(request.getParameter("skypeID"));
		userService.setFirstname(user);

		user.setPicture(Paths.get(request.getPart("image").getSubmittedFileName()).getFileName().toString());
		return user;
	}

}
