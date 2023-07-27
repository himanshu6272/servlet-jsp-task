
$(document).ready(function(){

$("#add-address-btn").click(function(){
      $(this).addClass("d-none");
      $("#address").removeClass("d-none");
      $("#addressHelp").empty();

    })

    $("#cancel-address-btn").click(function(){
      $("#address").addClass("d-none");
      $("#add-address-btn").removeClass("d-none");
    })

        var id = 1;
        $("#save-address-btn").click(function(){
            let street = $("#inputStreet").val();
            let city = $("#inputCity").val();
            let state = $("#inputState").val();
            let zip = $("#inputZip").val();
            let country = $("#inputCountry").val();

//            let streetId = "street"+id;
//            let cityId = "city"+id;
//            let stateId = "state"+id;
//            let zipId = "zip"+id;
//            let countryId = "country"+id;
            let addElement = '<div class="address'+id+' border border-black p-2 m-3 addressBox"><div class="d-flex mb-2"><div class="d-inline mr-2"><label>Street</label><br><input name="street" value="'+street+
            '"><br></div><div class="d-inline mr-2"><label>City</label><br><input name="city" value="'+city+
            '"><br></div><div class="d-inline mr-2"><label>State</label><br><input name="state" value="'+state+
            '"><br></div><div class="d-inline mr-2"><label>Zip</label><br><input name="zip" value="'+zip+
            '"><br></div><div class="d-inline mr-2"><label>Country</label><br><input name="country" value="'+country+
            '"><br></div></div><button type="button" class="btn btn-primary d-block remove-address-btn mr-1">Remove</button><small class="form-text addressesHelp"></small></div>';
            $("#addresses").append(addElement);
            $("#inputStreet").val("");
            $("#inputCity").val("");
            $("#inputState").val("");
            $("#inputZip").val("");
            $("#inputCountry").val("");

            id = id + 1;
        })

        $(document).on("click", ".remove-address-btn", function() {
            $(this).closest(".addressBox").remove();
        });




});
