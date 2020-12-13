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
        if(data.name==null&& data.surname==null && data.username==null && data.password==null){
            window.location.replace("http://localhost:8080/login");
                alert( "Successfully registered" );
        }else {
            alert("please check your data")
            if(data.name !=="") {
                $('#ename').show()
            }else $('#ename').hide()
            if(data.surname !=="") {
                $('#esurname').show()
            }else $('#esurname').hide()
            if(data.username !=="") {
                $('#eusername').show()
            }else $('#eusername').hide()
            if(data.password !=="") {
                $('#epassword').show()
            }else $('#epassword').hide()
        }
    })
}