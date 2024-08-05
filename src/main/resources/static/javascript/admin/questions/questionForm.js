import $ from 'jquery';

$(function(){
    $('#cancelButton').on('click', function(event){
        event.preventDefault();
        cancel()
    })
});

function cancel(){
    window.location.href = "http://localhost:8081/admin/questions";
}