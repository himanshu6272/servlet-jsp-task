$(document).ready(function(){

    console.log("dfghjk....");
//    function disableBack() {
//        console.log("dfgrtghjhjk....");
//        window.history.forward()
//    }
//    window.onload = disableBack();
//    window.onpageshow = function(e) {
//
//        if (e.persisted){
//            console.log("dfghjk....");
//            disableBack();
//        }
//
//    }


    let searchParams = new URLSearchParams(window.location.search);
    let role = searchParams.get("role");

    if(searchParams.has('adminId')){
        $(".navbar-brand").addClass("d-none");
        $("#dashboard-btn").removeClass("d-none");
    }else{
        $(".navbar-brand").remove();
    }

    $("#edit-user-btn").click(function(){
        $("input").removeAttr("disabled");
        $(".remove-address-btn").removeAttr("disabled");
         if(role === "ADMIN"){
                $("#email-address").attr("disabled", "disabled");
            }else{
                $("#email-address").attr("disabled", "disabled");
                $("input.role").attr("disabled", "disabled");
            }
        $("#submit-btn").removeAttr("disabled");
        $("#add-address-btn").removeClass("d-none");
    })


    $("#login-btn").html("Logout").removeAttr("href").attr("href", "logoutServlet");
    $("#register-btn").remove();

    $("#add-address-btn").click(function(){
        $("#address").removeClass("d-none");
    })

})