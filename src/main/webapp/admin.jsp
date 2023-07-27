<%@page import="models.User, java.util.*, java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <link rel="stylesheet" href="./assets/bootstrap/bootstrap.min.css">
  <style>
  .div-cont {
  min-height:81vh;
  }
  #myInput {
    width: 50%;
    font-size: 16px;
    padding: 6px 20px 6px 40px;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-left: 100px;
  }

</style>
</head>
<%
    List<User> users = (List)request.getAttribute("users");
    User admin = (User)request.getAttribute("admin");
%>
<body class="bg-warning">
<%@ include file="header.html" %>
<div class="container div-cont bg-secondary">
  <div class="row">
  <div class="bg-dark w-100 p-2">
  <h3 class="text-warning d-inline ml-4" style="margin-right:200px;">Admin Dashboard</h3>
  <input type="text" id="myInput" placeholder="Search for names.." class="ml-5">
  </div>
    <table class="table text-warning text-center border-bottom border-white" id="myTable">
      <tr>
        <th style="width:10%;">Sr. No.</th>
        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
      </tr>
      <c:forEach items="${users}" var="user">
      <tr>
        <td><c:out value="${user.getId()}" /></td>
        <td><c:out value="${user.getFirstName()}" /></td>
        <td><c:out value="${user.getEmail()}" /></td>
        <td><c:out value="${user.getRole()}" /></td>
        <td class="w-25">
        <a href="viewServlet?userId=${user.getId()}&role=${admin.getRole()}" class="btn btn-warning py-1 view-user-btn">View</a>
        <a href="deleteServlet?userId=${user.getId()}" class="btn btn-warning py-1 remove-user-btn">Delete</a>
        </td>
      </tr>
      </c:forEach>
    </table>
  </div>
</div>
<script src="./assets/jquery/jQuery 3.6.4.js"></script>
<script src="./assets/js/admin.js"></script>
<script src="./assets/jquery/jquery-ui.js"></script>
<%@ include file="footer.html" %>
</body>
</html>