$(document).ready(function() {
     
    ajaxGet();
     
    // GET REQUEST
    $("#getNot").hover(function(event){
        event.preventDefault();
         setInterval(function(){ ajaxGet(); }, 5000);
    });
    
 
     
    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url :"/getNotifications",
            success: function(result){
                if(result.status == "Done"){
                    $('#getResultDiv.list-group li').remove();
                    var custList = "";
                    
                    $('#getResultDiv .list-group').text(' ');
                         
                    $.each(result.data, function(i, not){
                        var notification = not.description ;
                        $('#getResultDiv .list-group').append('<li><h4 class="list-group-item">'+notification+'</h4></li>')
                    });
                    console.log("Success: ", result);
                }else{
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
});