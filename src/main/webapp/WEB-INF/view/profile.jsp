<%@ page import="codeu.model.store.basic.UserStore"%>
<%@ page import="codeu.model.data.User"%>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
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
      <%  if (request.getSession().getAttribute("user") != null) { %>
          <a href="/profile">Profile</a>
      <%  } else{ %>
          <a></a>
      <%  } %>
    </nav>

    <div id="container">
      <%if(request.getSession().getAttribute("user") != null) { %>
        <h1><%=request.getSession().getAttribute("user")%>'s Profile Page</h1>
        <hr/>

        <form action="/profile" method="POST">
          <h2> About Me </h2>

          <input type="text" name="aboutMe">
            <br/><br/>
          <button type="submit">Submit</button>
              <p><%= UserStore.getInstance().getUser((String)request.getSession().getAttribute("user")).getAboutMe() %></p>

        </form>
      <%} %>



    </div>
</body>

</html>
