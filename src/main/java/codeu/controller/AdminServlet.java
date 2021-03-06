// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package codeu.controller;

import codeu.model.store.basic.ConversationStore;
import codeu.model.store.basic.MessageStore;
import codeu.model.store.basic.UserStore;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet class responsible for the chat page. */
public class AdminServlet extends HttpServlet {

	/** Store class that gives access to Users. */
	private UserStore userStore;
	private ConversationStore convoStore;
	private MessageStore messageStore;

	/** Set up state for handling login requests. */
	@Override
	public void init() throws ServletException {
		super.init();
		setUserStore(UserStore.getInstance());
		setConversationStore(ConversationStore.getInstance());
		setMessageStore(MessageStore.getInstance());
	}

	/**
	 * Sets the UserStore used by this servlet. This function provides a common
	 * setup method for use by the test framework or the servlet's init()
	 * function.
	 */
	public void setUserStore(UserStore userStore) {
		this.userStore = userStore;
	}

	/**
	 * Sets the ConversationStore used by this servlet. This function provides a
	 * common setup method for use by the test framework or the servlet's init()
	 * function.
	 */
	public void setConversationStore(ConversationStore convoStore) {
		this.convoStore = convoStore;
	}

	/**
	 * Sets the UserStore used by this servlet. This function provides a common
	 * setup method for use by the test framework or the servlet's init()
	 * function.
	 */
	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

	/**
	 * This function fires when a user selects the admin page.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("totalUsers", userStore.totalUsers());
		request.setAttribute("totalConvos", convoStore.totalConvos());
		request.setAttribute("totalMessages", messageStore.totalMessages());
		request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(
				request, response);
	}
}
