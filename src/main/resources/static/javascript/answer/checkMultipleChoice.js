import $ from "jquery";

$(function(){

    $('#checkMultipleChoice').on('click', function(event){
        event.preventDefault();
        checkAnswer();
    })
})

function checkAnswer(){
    let value = $('input[name="choice"]:checked').val();
    let questionId = $("#question").val();

    let url = "http://localhost:8081/answers"

    let body = {
        value: value,
        question: {
            id: questionId
        }
    }

    $.ajax({
        url: url,
        type: "post",
        data: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function( data ) {
        console.log( data );
        success( data );
    });
}

function success( data ){
    const {correctAnswer, isCorrect} = data;

    if(isCorrect){
        $('input[name="choice"]:checked').parent().css("background-color", "green")
    }else{
        $('input[name="choice"]:checked').parent().css("background-color", "red")
        $('input[name="choice"][value=' +correctAnswer+ ']').parent().css("background-color", "green")
    }
}
