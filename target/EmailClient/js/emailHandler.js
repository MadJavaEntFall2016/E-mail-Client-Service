/**
 * Created by student on 11/12/16.
 */

$(document).ready(function (){
    $("form").bind("submit",function(e) {
        var uri = "http://localhost:8080/restAPI/email/";
        var append = $("#subject").val() + "/" +   $("#emailBody").val() + "/" +   $("#recipient").val() + "/" +   $("#email").val() ;
        sendMail (uri ,append);
        e.preventDefault();
    });
});


function sendMail (uri, append) {
    $.ajax({
        url: uri,
        type : "GET",
        beforeSend: function ( jqXHR, settings) {
            settings.url += append;
        },
        success: function( data ) {
            $("form > input[type=reset]").trigger("click");

            renderData (data, "#results");
            highlight("#results");


        },
        fail: function(data) {
            renderData ("Could not contact Server, please try again", "#results");
        }
    });
}

function renderData(  data, target ) {
    $(target).html("<font color=\"green\" size=\"small\">"+data+"</font>");
}

function highlight(target) {
    for(i=0;i<3;i++) {
        $(target).fadeTo('slow', 0.3).fadeTo('slow', 1.0);
    }
    $(target).delay(3000).fadeTo('slow', 0);
}
