$(document).ready(() => {
    $('#listBtn').on('click', () => {
        $.get("/board", (data) => {
            console.log(data)
            alert(JSON.stringify(data))
        })
    })
})

$('#readBtn').on('click', () => {
    let boardNo = $('#boardNo');
    let boardNoVal = boardNo.val();
    console.log(boardNoVal);

    $.get(`/board/${boardNoVal}`, (data) => {
        console.log(data);
        alert(JSON.stringify(data));
    })
})

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
        url:"/board",
        data:JSON.stringify(boardObject),
        contentType:"application/json;charset=UTF-8",
        success: (result) => {
            console.log("result : ", result);
            alert(result)
        }
    })
})

$('#deleteBtn').on('click', () => {
    let boardNo = $('#boardNo');
    let boardNoVal = boardNo.val();
    console.log(boardNoVal);

    $.ajax({
        type:"DELETE",
        url:`/board/${boardNoVal}`,
        success: (result) => {
            console.log("result : ", result);
            alert(result)
        }
    })
})

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
        url:`/board/${boardNoVal}`,
        data:JSON.stringify(boardObject),
        contentType:"application/json;charset=UTF-8",
        success: (result) => {
            console.log("result : ", result);
            alert(result)
        }
    })
})