<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <link rel="stylesheet" href="./assets/bootstrap/bootstrap.min.css">
</head>
<style>
  .div-cont {
  height:81vh;
  }
  .user-icon-div img{
    width:6%;
  }
</style>
<body class="bg-warning">
<%@ include file="header.html" %>
<div class="container div-cont">
  <div class="row w-50 mx-auto pt-5">
    <div class="col bg-secondary text-center user-icon-div p-2 rounded-top">
      <img src="assets/images/user.png">
      <h4 class="text-white">Login here</h4>
    </div>
  </div>
  <div class="row w-50 mx-auto">
    <div class="col w-75 bg-dark p-5 rounded-bottom">
    <form class="border border-solid border-warning rounded-lg p-4 text-warning" method="post" onsubmit="return validate()">
            <div class="form-group">
              <label for="email-address">Email</label>
              <input type="text" class="form-control" id="email-address" placeholder="enter email" name="email">
              <small id="emailHelp" class="form-text"></small>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="text" class="form-control" id="password" placeholder="enter password" name="password">
              <small id="passwordHelp" class="form-text"></small>
            </div>
            <input type="submit" class="btn btn-outline-warning" id="submit-btn" value="Submit">
    </form>
    </div>
  </div>
</div>
<%@ include file="footer.html" %>
<script src="./assets/jquery/jQuery 3.6.4.js"></script>
<script src="./assets/js/validation.js"></script>
<script src="./assets/jquery/jquery-ui.js"></script>
</body>
</html>