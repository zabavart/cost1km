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
            $('#cost1km').text(data.cost1km);
            //$('#carModel').text(data.carModel);
        });
});

