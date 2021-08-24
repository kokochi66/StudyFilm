$(document).ready(() => {

    let test_url = 'test'
    $('#listBtn').on('click', () => {
        $.get(`/${test_url}`, (data) => {
            console.log(data)
            alert(JSON.stringify(data))
        })
    })  // 리스트 버튼 테스트

    $('#readBtn').on('click', () => {
        let boardNo = $('#boardNo');
        let boardNoVal = boardNo.val();
    
        // $.get(`/board/${boardNoVal}`, (data) => {
        //     console.log(data);
        //     alert(JSON.stringify(data));
        // })
        $.ajax({
            type:"get",
            url:`/${test_url}/${boardNoVal}`,
            headers: {
                "Accept":"application/json"
            },
            success: (result) => {
                console.log("result : " , result);
                alert(JSON.stringify(result))
            }
        })
    })  // 글 가져오기 버튼 테스트

    $('#registerBtn').on('click', () => {
        let title = $('#title')
        let content = $('#content')
        let writer = $('#writer')
    
        let titleVal = title.val()
        let contentVal = $('#content').val()
        let writerVal = $('#writer').val()
    
        let boardObject = {
            title:titleVal,
            content:contentVal,
            writer:writerVal
        };
    
        $.ajax({
            type:"POST",
            url:`/${test_url}`,
            headers: {
                "X-HTTP-Method-Overrid":"POST"
            },
            data:JSON.stringify(boardObject),
            contentType:"application/json;charset=UTF-8",
            success: (result) => {
                console.log("result : ", result);
                alert(result)
            }
        })
    })  // 글 작성 버튼 테스트
    
    $('#deleteBtn').on('click', () => {
        let boardNo = $('#boardNo');
        let boardNoVal = boardNo.val();
    
        $.ajax({
            type:"DELETE",
            url:`/${test_url}/${boardNoVal}`,
            success: (result) => {
                console.log("result : ", result);
                alert(result)
            }
        })
    })  // 글 지우기 버튼 테스트
    
    $('#modifyBtn').on('click', () => {
        let boardNo = $('#boardNo'),
            title = $('#title'),
            content = $('#content'),
            writer = $('#writer')
    
        let boardNoVal = boardNo.val(),
            titleVal = title.val(),
            contentVal = $('#content').val(),
            writerVal = $('#writer').val()
    
        let boardObject = {
            boardno:boardNoVal,
            title:titleVal,
            content:contentVal,
            writer:writerVal
        };
    
        $.ajax({
            type:"PUT",
            url:`/${test_url}/${boardNoVal}`,
            data:JSON.stringify(boardObject),
            // headers: {
            //     "X-HTTP-Method-Override":"PUT"
            // },
            contentType:"application/json;charset=UTF-8",
            success: (result) => {
                console.log("result : ", result);
                alert(result)
            }
        })
    })  // 글 수정 버튼 테스트

    $('#listBtnGet').on('click', () => {
        $.get(`/${test_url}/list`, (data) => {
            console.log(data);
            alert(JSON.stringify(data));
        })
    })  // 리스트 폼 테스트

    $('#registerBtnGet').on('click', () => {
        $.get(`/${test_url}/register`, (data) => {
            console.log(data);
            alert(JSON.stringify(data));
        })
    })  // 글 작성 폼 테스트

    $('#modifyBtnGet').on('click', () => {
        $.get(`/${test_url}/modify`, (data) => {
            console.log(data);
            alert(JSON.stringify(data));
        })
    })  // 글 수정 폼 테스트

    $('#member_regitser01').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register01`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 void 응답 테스트

    $('#member_regitser02').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register02`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 String 응답 테스트

    $('#member_regitser03').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register03`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 자바빈즈 응답 테스트

    $('#member_regitser04').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register04`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 List 응답 테스트

    $('#member_regitser05').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register05`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 Map 응답 테스트

    $('#member_regitser06').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register06`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 ResponseEntity<Void> 응답 테스트

    $('#member_regitser07').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register07`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            },
            error: (xhr, status, error) => {
                alert(`code = ${xhr.status} / message = ${xhr.responseText} / error = ${error}`)
            }
        })
    })  // GET 요청 ResponseEntity<Beans> 응답 테스트

    $('#member_regitser08').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register08`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 ResponseEntity<List> 응답 테스트

    $('#member_regitser09').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register09`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 ResponseEntity<Map> 응답 테스트

    $('#member_regitser10').on('click', () => {
        $.ajax({
            type:"GET",
            url:`/${test_url}/member/register10`,
            contentType: "application/json; charset=UTF-8",
            success: (data) => {
                console.log('data = ', data);
                alert(JSON.stringify(data))
            }
        })
    })  // GET 요청 ResponseEntity<byte[]> 응답 테스트


})