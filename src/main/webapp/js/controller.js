$('#years').hide();
$('#carGroup').hide();
$('#isCredit').hide();
$('#creditGroup').hide();
$('#costGroup').hide();
$('#carMiniInfo').hide();

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

$('#allPeriod').change(function () {
    $('#years').hide();
    $('#carGroup').show();
});

$('#yearPeriod').change(function () {
    $('#years').show();
    $('#carGroup').hide();
});

$('#carModification').change(function () {
    $('#isCredit').show();
    $('#costGroup').show();
    $('#carGroup').hide();
    $('#carMiniInfo').show();
    var mark = $('#carMark option:selected').text();
    var model = $('#carModel option:selected').text();
    var serie = $('#carSerie option:selected').text();
    var modification = $('#carModification option:selected').text();
    $('#carMiniInfo').html('<strong>Модель:</strong> ' + serie + ' ' + modification);
});

$('#isCredit').change(function () {
    if ($('#isCreditCheckbox').prop('checked')) {
        $('#creditGroup').show();
    } else {
        $('#creditGroup').hide();
    }
});

controller();

$('#mainForm').change(function () {
    controller();
});

$('#save').click(function () {
    save();
});

function controller() {
    $.post(
        '/calc',
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
                for (var key in  data.carMarkList) {
                    var carMark =  data.carMarkList[key];
                    $('#carMark').append('<option value=' + carMark.idCarMark + '>' + carMark.name + '</option>');
                }
                $('#carMark').val($('#select option:first').val());
            }

            if ($('#carModel').val() == null) {
                for (var key in  data.carModelList) {
                    var carModel = data.carModelList[key];
                    $('#carModel').append('<option value=' + carModel.idCarModel + '>' + carModel.name + '</option>');
                }
                $('#carModel').val($('#select option:first').val());
            }

            if ($('#carSerie').val() == null) {
                for (key in data.carSerieList) {
                    var carSerieList = data.carSerieList[key];
                    $('#carSerie').append('<option value=' + carSerieList.idCarSerie + '>' + carSerieList.name + '</option>');
                }
                $('#carSerie').val($('#select option:first').val());
            }

            if ($('#carModification').val() == null) {
                for (key in data.carModificationList) {
                    var carModificationList = data.carModificationList[key];
                    $('#carModification').append('<option value=' + carModificationList.idCarModification + '>' + carModificationList.name + '</option>');
                }
                $('#carModification').val($('#select option:first').val());
            }
        }
    );
}

function save() {
    $.post(
        '/costs',
        {
            carMarkId: $('#carMark').val(),
            carModelId: $('#carModel').val(),
            carSerieId: $('#carSerie').val(),
            carModificationId: $('#carModification').val(),
            price: $('#price').val(),
            sellingPrice: $('#sellingPrice').val(),
            milesOn: $('#milesOn').val(),
            benzine: $('#benzine').val(),
            repairs: $('#repairs').val(),
            service: $('#service').val(),
            credit: $('#credit').val(),
            kasko: $('#kasko').val(),
            osago: $('#osago').val(),
            tax: $('#tax').val(),
            penalty: $('#penalty').val(),
            parking: $('#parking').val(),
            otherExpenses: $('#otherExpenses').val(),
            cost: $('#cost').val()
        });
}

$('#openCar').click(function () {
    $.get(
        '/calculations',
        {},
        function (data) {
            var calculation = data;
            for (i = 0; i < calculation.length; i++) {
                var carMark = calculation[i].carModification.carModel.carMark.name;
                var carModel = calculation[i].carModification.carModel.name;
                $('#calculations').append('<a href="#" class="list-group-item">' + carMark + " " + carModel + " " + '</a>');
            }
        }
    );
});

$('#openCarBtn').click(function () {
    save();
});