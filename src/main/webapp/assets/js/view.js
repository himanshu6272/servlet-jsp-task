$(document).ready(function(){

    let searchParams = new URLSearchParams(window.location.search);
    let role = searchParams.get('role');
    if(role === "ADMIN"){
        $(".navbar-brand").addClass("d-none");
        $("#dashboard-btn").removeClass("d-none");
    }else{
        $(".navbar-brand").remove();
    }

    $("#edit-user-btn").click(function(){
        $("input").removeAttr("disabled");
        $("#submit-btn").removeAttr("disabled");
        $("#add-address-btn").removeClass("d-none");
    })

    $("#update-user-btn").click(function(){
        $("input").attr("disabled", "disabled");
    })

    $("#login-btn").html("Logout").removeAttr("href").attr("href", "logoutServlet");
    $("#register-btn").remove();

    $("#add-address-btn").click(function(){
        $("#address").removeClass("d-none");
    })

})