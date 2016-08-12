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
            success: function(result) {
                
                if (result["cadastrado"] === true) {
                    console.log('asd');
                    form.remove();
                    var msg = $('<p></p>');
                    msg.append(result["mensagem"]);
                    msg.addClass('alert alert-success');
                    $('section').children('.container').html(msg).fadeIn();                    
                } else {
                    
                }
            }
        });
    });
});
