
package com.poet.ordering.system.servlets.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.poet.ordering.system.model.ImageUtility;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.user.UserServiceImp;

@WebServlet("/profile/edit")
@MultipartConfig
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImp userService = UserServiceImp.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("duplicateEmail", "");
		request.getRequestDispatcher("/jsp/user/editProfile.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = ((User) request.getSession().getAttribute("user"));
		populateUserFields(request, user);

		boolean duplicateUsername = true;

		duplicateUsername = userService.editUserProfile(user);

		if (duplicateUsername) {

			request.setAttribute("duplicateEmail", "email or skypeID already assigned to account!");

			request.getRequestDispatcher("/jsp/user/editProfile.jsp").forward(request, response);
		} else {

			String[] firstname = new String[1];

			firstname = user.getFullname().split("\\s");
			request.setAttribute("firstname", firstname[0]);

			request.setAttribute("Subscriptions", userService.selectSubscriptions(user));
			request.setAttribute("Subscribers", userService.selectSubscribers(user));

			response.sendRedirect("/profile");
		}
	}

	private void populateUserFields(HttpServletRequest request, User user) throws IOException, ServletException {
		user.setEmail(request.getParameter("email"));
		user.setFullname(request.getParameter("fullname"));
		user.setSkypeID(request.getParameter("skypeID"));
		Part filePart = request.getPart("image");
		ImageUtility imageUtility = new ImageUtility();
		imageUtility.uploadImage(user, filePart);

	}

}
