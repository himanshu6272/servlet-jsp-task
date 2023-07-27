$(document).ready(function() {

    $("#login-btn").html("Logout").removeAttr("href").attr("href", "logoutServlet");
    $("#register-btn").html("Update Profile").removeAttr("href").attr("href", "view.jsp");
    $(".navbar-brand").addClass("d-none");
    $("#dashboard-btn").removeClass("d-none");

$(".remove-user-btn").click(function(){
    $(this).closest("tr").remove();
})


$("#myInput").on("keyup", function(){
     var input, filter, table, tr, td, i, txtValue;
          input = document.getElementById("myInput");
          filter = input.value.toUpperCase();
          table = document.getElementById("myTable");
          tr = table.getElementsByTagName("tr");

          for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }
          }

})

})