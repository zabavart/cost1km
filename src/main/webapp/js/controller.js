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
                $('#carModel option').remove();
                for (key in data.carModelList) {
                    $('#carModel').append('<option value="' + key + '">' + data.carModelList[key] + '</option>');
                }
            }
        });
});

