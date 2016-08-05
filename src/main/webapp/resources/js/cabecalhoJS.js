/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('.dropdown').on('click', 'a', function () {
        $('.dropdown-menu').slideToggle(300);
    });

    $(document).click(function (event) {
        if (!$(event.target).closest('.dropdown-toggle').length) {
            if ($('.dropdown-menu').is(':visible')) {
                $('.dropdown-menu').hide(300);
            }
        }
    });

});
