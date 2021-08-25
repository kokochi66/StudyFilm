$(document).ready(() => {
    $('#registerBtn').on('click', () => {
        let userIdVal = $('#userId').val();
        let userPasswordVal = $('#userpassword').val();
        let userNameVal = $('#username').val();
        let emailVal = $('#email').val();
        let genderVal = $('input[name="gender"]:checked').val();
    
        let userObject = {
            userId : userIdVal,
            password: userPasswordVal,
            userName: userNameVal,
            email: emailVal,
            gender: genderVal
        }
        $.ajax({
            type:'post',
            url:'/valid/member/register',
            data: JSON.stringify(userObject),
            contentType:"application/json;charset=UTF-8",
            success: (res) => {
                console.log('res ',res)
                alert(res)
            },
            error: (xhr, status, error) => {
                alert('the error message :: ', xhr.status, xhr.responseText, error)
            }
        })
    })  // member valid register TEST
})