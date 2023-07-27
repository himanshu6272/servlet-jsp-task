$(document).ready(function validate() {
  let flag = false;

  let emailAddress = function () {
      let emailExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      let email = $("#email-address").val();
      if (email == "" || email == undefined) {
        $("#emailHelp").html("email is required!").addClass("text-danger");
        return false;
      } else if (emailExp.test(email) == false) {
        $("#emailHelp")
          .html("Invalid email, email must contain @ (example@xyz.com)!")
          .addClass("text-danger");
        return false;
      } else {
        $("#emailHelp").empty();
        return true;
      }
    };

    let pwd = function () {
        let password = $("#password").val();
        let passwordExp = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
        if (password == "" || password == undefined) {
          $("#passwordHelp").html("password is required!").addClass("text-danger");
          return false;
        } else if (passwordExp.test(password) == false) {
          $("#passwordHelp")
            .html(
              "password should contain atleast 8 characters(one uppercase, one lowercase, one digit and one special character"
            )
            .addClass("text-danger");
          return false;
        } else {
          $("#passwordHelp").empty();
          return true;
        }
      };

    $("#email-address").blur(emailAddress);
    $("#password").blur(pwd);
    $("#submit-btn").click(emailAddress);
    $("#submit-btn").click(pwd);

});