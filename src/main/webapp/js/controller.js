$('#carMark').change(function () {
    $('#carModel option').remove();
    $('#carSerie option').remove();
    $('#carModification option').remove();
});

$('#carModel').change(function () {
    $('#carSerie option').remove();
    $('#carModification option').remove();
});

$('#carSerie').change(function () {
    $('#carModification option').remove();
});

$('#mainForm').change(function () {
    $.post(
        '/s',
        {
            carMarkId: $('#carMark').val(),
            carModelId: $('#carModel').val(),
            carSerieId: $('#carSerie').val(),
            carModificationId: $('#carModification').val(),
            cost: $('#cost').val(),
            price: $('#price').val(),
            milesOn: $('#milesOn').val(),
            benzine: $('#benzine').val(),
            otherExpenses: $('#otherExpenses').val(),
            sellingPrice: $('#sellingPrice').val()
        },
        function (data) {
            $('#cost1km').text('Стоимость 1 км ' + data.cost1km + ' руб.');

            if ($('#carMark').val() == null) {
                $('#carMark option').remove();
                for (key in data.carMarkList) {
                    $('#carMark').append('<option value="' + key + '">' + data.carMarkList[key] + '</option>');
                }
            }

            if ($('#carModel').val() == null) {
                for (key in data.carModelList) {
                    $('#carModel').append('<option value="' + key + '">' + data.carModelList[key] + '</option>');
                }
            }

            if ($('#carSerie').val() == null) {
                for (key in data.carSerieList) {
                    $('#carSerie').append('<option value="' + key + '">' + data.carSerieList[key] + '</option>');
                }
            }

            if ($('#carSerie').val() == null) {
                for (key in data.carModificationList) {
                    $('#carModification').append('<option value="' + key + '">' + data.carModificationList[key] + '</option>');
                }
            }
        });
});

