/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('form').on('submit', function (event) {
        event.preventDefault();
        var form = $(this);
        $.ajax(form.attr('action'), {
            type: 'POST',
            data: form.serialize(),
            success: function (result) {
                if (result["cadastrado"] === true) {
                    form.remove();
                    var msg = $('<p></p>');
                    msg.append(result["mensagem"]);
                    msg.addClass('alert alert-success row');
                    $('hr').append(msg).fadeIn();
                }
            },
            error: function (result) {
                console.log(result);
                var msg = $('<p></p>');
                msg.append("Erro durante o cadastro!");
                msg.addClass('alert alert-danger');
                $('hr').append(msg).fadeIn();
                $('button').children().removeClass('fa-spin');
            }

        });
    });
    $('button').on('click', function () {
        $(this).children().addClass('fa-spin');
    });
});
