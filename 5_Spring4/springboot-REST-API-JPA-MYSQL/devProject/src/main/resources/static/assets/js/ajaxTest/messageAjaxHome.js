$(document).ready(() => {

    $('#welcome').on('click', () => {
        $.ajax({
            type:"post",
            url:'/message/test/welcome',
            contentType:'application/json;charset=UTF-8',
            success: (data) => {
                console.log('data = ', JSON.stringify(data));
            },
            error: (req, status, error) => {
                console.log(`
                code = ${req.status}

                message = ${req.responseText}

                error = ${error}`)
            }
        })
    })  // welcome Message TEST
})