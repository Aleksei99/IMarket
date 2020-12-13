function editInformation(){
    let city = $("#city").val();
    let street = $("#street").val();
    let house = $("#house").val();
    let number = $("#number").val();
    let telephone = $("#telephone").val();
    let email = $("#email").val();
    let contactInformation = {
        city:city,
        street:street,
        house:house,
        number:number,
        telephone:telephone,
        email:email
    };

    $.ajax( {
        method: 'POST',
        url:'restEditInformation',
        contentType: 'application/json',
        data: JSON.stringify(contactInformation)
    }).done(function(data) {
            window.location.replace("http://localhost:8080/info");
    })
}