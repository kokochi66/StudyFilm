$(document).ready(() => {
    $('#registerBtn').on('click', () => {
        let userIdVal = $('#userId').val();
        let userPasswordVal = $('#userpassword').val();
        let userNameVal = $('#username').val();
        let dateOfBirthVal = $('#dateOfBirth').val();
        let emailVal = $('#email').val();
        let genderVal = $('input[name="gender"]:checked').val();
    
        let userObject = {
            userId : userIdVal,
            password: userPasswordVal,
            userName: userNameVal,
            dateOfBirth: dateOfBirthVal,
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
                alert(`code = ${xhr.status} / message = ${xhr.responseText} / err :: ${error} / `)
                // 에러 내용을 표시한다.
            }
        })
    })  // member valid register TEST
})