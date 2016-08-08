$(document).ready(function() {    
    $('#carroLugaresOption').change(function() {
        $('#carroLugaresLabel').val($(this).val());        
    }).change();
    
    if ($('#usuMsg').text() !== "") {
        $('.form-control').prop('disabled', true);
    }
    
});
