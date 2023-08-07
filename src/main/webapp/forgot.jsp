<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <link rel="stylesheet" href="./assets/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="./assets/css/style.css">
</head>

<body class="bg-warning">
<%@ include file="header.jsp" %>
<div class="container div-cont">
  <div class="row w-50 mx-auto">
    <div class="col bg-secondary text-center login-user-icon-div p-2 rounded-top mt-5">
      <img src="assets/images/user.png">
      <h4 class="text-white">Forgot Password</h4>
    </div>
  </div>
  <div class="row w-50 mx-auto">
    <div class="col w-75 bg-dark p-5 rounded-bottom">
    <form action="forgotServlet" class="border border-solid border-warning rounded-lg p-4 text-warning" method="post" onsubmit="return validate()">
            <div class="form-group">
              <label for="email-address">Email</label>
              <input type="text" class="form-control" id="email-address" placeholder="enter email" name="email">
              <small id="emailHelp" class="form-text"></small>
            </div>
            <div class="form-group">
                <label for="security-que">Security question: </label>
                <select class="form-control mb-3" name="security-que" id="security-que">
                    <option>None</option>
                    <option>Who is your favourite Bollywood Star?</option>
                    <option>Who is your favourite Cricketer?</option>
                    <option>Who is your favourite Teacher?</option>
                    <option>Who you love the most?</option>
                </select>
                <input type="text" class="form-control" id="security-answer" placeholder="Enter answer here" name="security-answer">
                <small id="securityanswerHelp" class="form-text"></small>
            </div>
            <input type="submit" class="btn btn-outline-warning" id="submit-btn" value="Submit">
    </form>
    </div>
  </div>
</div>
<%@ include file="footer.html" %>
<script src="./assets/jquery/jQuery 3.6.4.js"></script>
<script src="./assets/jquery/jquery-ui.js"></script>
</body>
</html>