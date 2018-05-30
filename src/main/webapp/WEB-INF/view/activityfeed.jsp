<%--
  Copyright 2017 Google Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
--%>
<%@ page import="java.util.List" %>
<%@ page import="codeu.model.data.Conversation" %>
<%@ page import="codeu.model.store.basic.UserStore" %>
<%@ page import="codeu.model.data.User" %>

<!DOCTYPE html>
<html>
<head>
  <title>Activity Feed</title>
  <link rel="stylesheet" href="/css/main.css">
</head>
<body>

  <nav>
    <a id="navTitle" href="/">CodeU Chat App</a>
    <a href="/conversations">Conversations</a>
    <% if(request.getSession().getAttribute("user") != null){ %>
      <a>Hello <%= request.getSession().getAttribute("user") %>!</a>
    <% } else{ %>
      <a href="/login">Login</a>
    <% } %>
    <a href="/about.jsp">About</a>
    <a href="/activityfeed">Activity Feed</a>
  </nav>

  <div id="container">

    <h1>Activity Feed</h1>

	<p> This is the activity feed</p>

    <%
    UserStore userStore = (UserStore) request.getAttribute("userStore");
    List<User> users = (List<User>) request.getAttribute("users");
    List<Conversation> conversations =
      (List<Conversation>) request.getAttribute("conversations");
    if(conversations == null || conversations.isEmpty()){
    %>
      <p>No activity yet.</p>
    <%
    }
    else{
    %>
      <ul class="mdl-list">
      
    <%--
    	int convIndex = conversations.size()-1;
    	int userIndex = users.size()-1;
    	while (convIndex >=0 || userIndex >=0){
    		
    	}	
    --%>
    <%
      for(int c = conversations.size()-1; c >=0; c--) {
    	  Conversation conversation = conversations.get(c);
    	  User user = userStore.getUser(conversation.getOwnerId());
    %>
      	<li> <%= conversation.getCreationTime() %>
      		<%= user.getName() %> created conversation:
      		<a href="/chat/<%= conversation.getTitle() %>">
        	<%= conversation.getTitle() %></a></li>
    <%
      }
    %>
    <%
      for(int u = users.size()-1; u >=0; u--) {
    	  User user = users.get(u);
    %>
      	<li> <%= user.getCreationTime() %>
      		<%= user.getName() %> joined! </li>
    <%
      }
    %>
      </ul>
    <%
    }
    %>
    <hr/>
  </div>
</body>
</html>
