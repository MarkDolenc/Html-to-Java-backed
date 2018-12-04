$(document).ready(function() {
    $("#skleni").click(function() {
    var name = $("#ime").val();
    var surname = $("#priimek").val();
    var davNumber = $("#Davcna").val();
    var date = $("#datumRojstva").val();
    if (name == '' || surname == '' || davNumber == '' || date == '') {
    alert("Izpolnite vsa polja");
    } 
    else {
    $.post("/src/net/java/test/servlet/FormServlet.java", {
    ime: name,
    priimek: surname,
    davcna: davNumber,
    datumRojstva: date
    }, function(data) {
    if (data == 'Poslano v povpraševanje') {
    $("form")[0].reset();
    }
    alert(data);
    });
    }
    });
    });