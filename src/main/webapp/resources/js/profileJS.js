/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $('.well').on('click', 'a', function () {
        var label = $(this);
        var span = $(this).parent();
        var labelValor = label.text();
        var input = $('<input value="' + labelValor + '" name="' + span[0].id + '" >');
        input.addClass('form-control col-md-4');
        label.remove();
        span.html(input).fadeIn();
    });

    $(document).click(function (event) {
        if (!$(event.target).closest('small').length) {
            if ($('input').length) {
                var input = $('input');
                input.
                console.log('tem!!');
            } else {
                console.log('nao tem!');
            }
            console.log($(event.target));
        }

    });

});