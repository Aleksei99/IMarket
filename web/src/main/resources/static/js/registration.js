function saveUser(){
    let name = $("#name").val();
    let surname = $("#surname").val();
    let username = $("#username").val();
    let password = $("#password").val();
    let role = $("#role").val();
    let registrationData = {
        name:name,
        surname:surname,
        username:username,
        password:password,
        role:role
    };

    $.ajax( {
        method: 'POST',
        url:'restRegister',
        contentType: 'application/json',
        data: JSON.stringify(registrationData)
    }).done(function(data) {
        $('#animation-name').text(data.name);
        $('#animation-date').text(data.surname);
    })
}