$('#mainForm').change(function () {
    $.post(
        '/s',
        {
            carMark: $('#carMark').val(),
            carModel: $('#carModel').val(),
            carSerie: $('#carSerie').val(),
            carModification: $('#carModification').val(),
            cost: $('#cost').val(),
            price: $('#price').val(),
            milesOn: $('#milesOn').val(),
            benzine: $('#benzine').val(),
            otherExpenses: $('#otherExpenses').val(),
            sellingPrice: $('#sellingPrice').val()
        },
        function (data) {
            $('#cost1km').text('Стоимость 1 км ' + data.cost1km + ' руб.');
            $('#carModel option').remove();
            for (key in data.carModel) {
                $('#carModel').append('<option value="' + key + '">' + data.carModel[key] + '</option>');
            }
        });
});

