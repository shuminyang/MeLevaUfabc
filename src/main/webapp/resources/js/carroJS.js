/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#mostraCarro').on('click', 'button', function () {
        var botao = $('#adicionarRemover');
        botao.html(botao.html() === 'Adicionar carro' ? 'Cancelar' : 'Adicionar carro');
        $('#carroForm').slideToggle();
    });
});
