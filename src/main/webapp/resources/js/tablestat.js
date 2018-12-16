$(document).ready(function() {

    ajaxGet();

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : "rest/all",
            success: function(result){
                $.each(result, function(i, textStat){

                    var fileRow = '<tr>' +
                        '<td>' + textStat.name + '</td>' +
                        '<td>' + textStat.numberOfString + '</td>' +
                        '<td>' + textStat.averageNumber + '</td>' +
                        '<td>' + textStat.maxWord + '</td>' +
                        '<td>' + textStat.minWord + '</td>' +
                        '</tr>';

                    $('#customerTable tbody').append(fileRow);

                });

            },
            error : function(e) {
                alert("ERROR: ", e);
                console.log("ERROR: ", e);
            }
        });
    }
})