/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('div.container table tr.clickable').on('click', function () {
        console.log('asdf');
        $('#qweteste').slideToggle();
    });
});