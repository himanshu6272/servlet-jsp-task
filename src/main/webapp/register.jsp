<%@ include file="header.html" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./assets/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Form Validation</title>
  <style>
  *{
  margin:0px;
  padding:0px;
  box-sizing:border-box;
  }
  #inputCity, #inputState, #inputZip, #inputCountry {
  width: 49%;
  display:inline;
  }

  #addresses {
  max-height: 300px;
  overflow: auto;
  }

  .user-icon-div {
    width:100%;
  }
  .user-icon-div img{
    width:5%;
  }
  </style>
</head>

<body class="bg-warning">
<div class="container">
  <div class="row">
  <div class="col bg-secondary text-center user-icon-div p-3">
  <img src="assets/images/user.png">
  <h3 class="text-white">Register here</h3>
  </div>
  </div>
    <div class="row">
    <div class="col p-0 bg-light">
      <form class="border border-solid border-black rounded-lg p-4" onsubmit="return validate()" action="result" method="post" >
        <div class="row">
        <div class="form-group col-6">
          <label for="fname">First name</label>
          <input type="text" class="form-control" id="fname" placeholder="Enter first name" name="firstname">
          <small id="fnameHelp" class="form-text"></small>
        </div>
        <div class="form-group col-6">
          <label for="lname">Last name</label>
          <input type="text" class="form-control" id="lname" placeholder="Enter last name" name="lastname">
          <small id="lnameHelp" class="form-text"></small>
        </div>
        </div>
        <div class="row">
        <div class="form-group col-6">
          <label for="mobile-number">Mobile number</label>
          <input type="text" class="form-control" id="mobile-number" placeholder="Enter mobile number" name="mobile">
          <small id="mobileHelp" class="form-text"></small>
        </div>
        <div class="form-group col-6">
          <label for="email-address">Email address</label>
          <input type="email" class="form-control" id="email-address" placeholder="Enter email" name="email">
          <small id="emailHelp" class="form-text"></small>
        </div>
        </div>

        <div class="row">
        <div class="col-6">
        <div class="row">
        <div class="form-group col-5">
          <label class="d-block">Role</label>
          <input type="radio" name="role" class="role" id="admin" value="ADMIN">
          <label for="admin">Admin</label>
          <input type="radio" name="role" class="role" id="user" value="USER">
          <label for="user">User</label>
          <small id="rolehelp" class="form-text"></small>
        </div>
          <div class="form-group col-7">
            <label class="d-block">Gender</label>
            <input type="radio" name="gender" class="gender" id="male" value="male">
            <label for="male">Male</label>
            <input type="radio" name="gender" class="gender" id="female" value="female">
            <label for="female">Female</label>
            <input type="radio" name="gender" class="gender" id="others" value="others">
            <label for="others">Others</label>
            <small id="genderHelp" class="form-text"></small>
          </div>
          </div>
          </div>
          <div class="form-group col-6">
            <label for="dob">Date of Birth</label><br>
            <input type="text" id="dob" name="dob">
            <span id="calendar-icon" class="fa fa-calendar"></span>
            <small id="dateHelp" class="form-text"></small>
          </div>
        </div>

        <div class="form-group">
          <label class="d-block">Address</label>
          <button type="button" class="btn btn-outline-primary" id="add-address-btn">Add Address</button>
          <div class="form-group w-100 d-none mt-3" id="address">
            <input type="text" class="form-control mb-2"  placeholder="Street" id="inputStreet" required>
            <input type="text" class="form-control mb-2" id="inputCity" placeholder="City" required>
            <input type="text" class="form-control  mb-2" id="inputState" placeholder="State" required>
            <input type="text" class="form-control mb-2" id="inputZip" placeholder="Zip" required>
            <input type="text" class="form-control " id="inputCountry" placeholder="County" required>
            <button type="button" class="btn btn-primary" id="save-address-btn">Add</button>
            <button type="button" class="btn btn-primary" id="done-address-btn">Done</button>
          </div>
          <div id="addresses"></div>
        </div>

        <div class="row">
        <div class="form-group col-6">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" placeholder="Password" name="password">
          <small id="passwordHelp" class="form-text"></small>
        </div>
        <div class="form-group col-6">
          <label for="cnf-password">Confirm password</label>
          <input type="password" class="form-control" id="cnf-password" placeholder="Confirm password">
          <small id="cnfpasswordHelp" class="form-text"></small>
        </div>
        </div>
        <input type="submit" value="Submit" class="btn btn-outline-primary form-control" id="submit-btn">
      </form>
    </div>
  </div>
</div>
<%@ include file="footer.html" %>
<script src="./assets/jquery/jQuery 3.6.4.js"></script>
<script src="assets/js/validation.js"></script>
<script src="assets/js/index.js"></script>
<script src="./assets/jquery/jquery-ui.js"></script>
</body>

</html>