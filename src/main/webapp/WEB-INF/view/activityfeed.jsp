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
<%@ page import="codeu.model.data.Activity" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZoneOffset" %>


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
	
	<%
    List<Activity> activity =
      (List<Activity>) request.getAttribute("activity");
    if(activity == null || activity.isEmpty()){
    %>
      <p>No recent activity.</p>
    <%
    }
    else{
    %>
      <ul class="mdl-list">
      
    <%
      for(Activity a : activity){
    %>
      <li><%= LocalDateTime.ofInstant(a.getCreationTime(), ZoneOffset.UTC) %>
        <%= a.getMessage() %></li>
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