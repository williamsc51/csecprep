import $ from "jquery";

$(function(){

    $('#checkSingleValue').on('click', function(event){
        event.preventDefault();
        checkAnswer();
    })
})

function checkAnswer(){
    let value = $('#userInput').val();
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
        success( data, value );
    });
}

function success( data, value ){
    const {correctAnswer, isCorrect} = data;

    let correct = `
        <br />
        <label>Correct Answer</label>
        <p style="background-color:green">${correctAnswer}</p>
    `
    let userValue = `
        <br />
        <label>Sorry</label>
        <p style="background-color:red">${value}
    </p>`

    if(isCorrect){
        $('#singlevalue').append(correct)
    }else{
        $('#singlevalue').append(userValue)
        $('#singlevalue').append(correct)
    }
}
