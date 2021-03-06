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
    var serie = $('#carSerie option:selected').text();
    var modification = $('#carModification option:selected').text();
    $('#carMiniInfo').html(serie + ' ' + modification);
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
        '/cost1km',
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
                    var id = data.carMarkList[key].idCarMark;
                    var name = data.carMarkList[key].name;
                    $('#carMark').append('<option value=' + id + '>' + name + '</option>');
                }
                $('#carMark').val($('#select option:first').val());
            }

            if ($('#carModel').val() == null) {
                for (var key in  data.carModelList) {
                    var id = data.carModelList[key].idCarModel;
                    var name = data.carModelList[key].name;
                    $('#carModel').append('<option value=' + id + '>' + name + '</option>');
                }
                $('#carModel').val($('#select option:first').val());
            }

            if ($('#carSerie').val() == null) {
                for (key in data.carSerieList) {
                    var id = data.carSerieList[key].idCarSerie;
                    var name = data.carSerieList[key].name;
                    $('#carSerie').append('<option value=' + id + '>' + name + '</option>');
                }
                $('#carSerie').val($('#select option:first').val());
            }

            if ($('#carModification').val() == null) {
                for (key in data.carModificationList) {
                    var id = data.carModificationList[key].idCarModification;
                    var name = data.carModificationList[key].name;
                    $('#carModification').append('<option value=' + id + '>' + name + '</option>');
                }
                $('#carModification').val($('#select option:first').val());
            }
        }
    );
}

function save() {
    console.log('!!!! ' + $('#carModification'));
    console.log('!!!! ' + $("#carModification option:selected").text());
    console.log('!!!! ' + $("#carModification option:selected").val());

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
            $('#calculations').empty();
            for (i = 0; i < calculation.length; i++) {
                var carMark = calculation[i].carModification.carModel.carMark.name;
                var carModel = calculation[i].carModification.carModel.name;
                $('#calculations').append(
                    '<li class="calculation" data-dismiss="modal" value="' + calculation[i].id + '">' +
                    '<a href=#>' + carMark + " " + carModel + " " + '</a>' +
                    '<li>');
            }
        }
    );
});
var xzCarMod;
$('#calculations').on('click', '.calculation', function () {
    $.get(
        '/calculations/' + this.value,
        {},
        function (data) {
            console.log(data);

            $('#isCredit').hide();
            $('#costGroup').show();
            $('#carGroup').show();

            var carMark = data[0].calculation.carModification.carModel.carMark.name
            var carModel = data[0].calculation.carModification.carModel.name;
            $('#carMiniInfo').show().html(carMark + " " + carModel);

            $('#carMark').val(data[0].calculation.carModification.carModel.carMark.idCarMark);
            $('#carModel').val(data[0].calculation.carModification.carModel.idCarModel);
            $('#carSerie').val(data[0].calculation.carModification.carSerie.idCarSerie);
            $('#carModification').val(data[0].calculation.carModification.idCarModification);

            xzCarMod = data[0].calculation.carModification.idCarModification;

            $('#price').val(data[0].price);
            $('#sellingPrice').val(data[0].sellingPrice);
            $('#milesOn').val(data[0].milesOn);
            $('#benzine').val(data[0].benzine);
            $('#repairs').val(data[0].repairs);
            $('#service').val(data[0].service);
            $('#credit').val(data[0].credit);
            $('#kasko').val(data[0].kasko);
            $('#osago').val(data[0].osago);
            $('#tax').val(data[0].tax);
            $('#penalty').val(data[0].penalty);
            $('#parking').val(data[0].parking);
            $('#otherExpenses').val(data[0].otherExpenses);
        }
    );
});