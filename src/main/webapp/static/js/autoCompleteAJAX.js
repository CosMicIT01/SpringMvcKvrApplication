$(document).ready(function() {

    $("#firstName").autocomplete({

        source : function(request, response) {
            $.ajax({
                url : "http://localhost:8080/person/searchbyfirstname",
                type : "GET",
                data : {
                    firstName : request.term
                },
                dataType : "json",
                success : function(jsonResponse) {
                    response( $.map( jsonResponse, function( item ) {
                        return {
                            label:item.firstName +', '+item.lastName,
                            value: item.firstName,
                            id: item.id,
                            firstName: item.firstName,
                            lastName: item.lastName,
                            email: item.email,
                            birthDate: item.birthDate,
                            countryOfOrigin: item.countryOfOrigin,
                            phoneNumber: item.phoneNumber,
                            gender: item.gender
                        }
                    }));


                }
            });
        },
        select: function (event, ui) {
            $('#firstName').val(ui.item.value);
            $('#lastName').val(ui.item.lastName);
            $('#email').val(ui.item.email);
            $('#phoneNumber').val(ui.item.phoneNumber);
            $('#countryofOrigin').val(ui.item.countryOfOrigin);
            $('#personId').val(ui.item.id);

            birthDateNew = new Date(ui.item.birthDate);
            var dateString = birthDateNew.format("dd.mm.yyyy");
            $('#birthDate').val(dateString);

            var $radios = $('input[type=radio]');
            if($radios.is(':checked') === false  && ui.item.gender == 'M') {
                $radios.filter('[value=M]').prop('checked', true);
            }
            if($radios.is(':checked') === false  && ui.item.gender == 'F') {
                $radios.filter('[value=F]').prop('checked', true);
            }
            return false;
        }
    });

});
