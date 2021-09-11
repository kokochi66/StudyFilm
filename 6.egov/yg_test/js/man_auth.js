function man_auth() {
    $('.auth_cont').each((idx, contElem) => {
        let selectElem = $(contElem).find('.addRole');
        let selectedId = $(contElem).attr('aria-labelledby');
        $(selectElem).on('change', (e) => {
            if(e.target.value !== 'cancel') {
                let cacheForm = document.createElement('form');
                cacheForm.setAttribute('method', 'post');
                cacheForm.setAttribute('action','/auth/addAuthRole.do');
                document.charset = "utf-8"
                
                let cacheForm_input = document.createElement('input');
                cacheForm_input.setAttribute('type','hidden');
                cacheForm_input.setAttribute('name', 'name');
                cacheForm_input.setAttribute('value', e.target.value);
                cacheForm.appendChild(cacheForm_input);

                let cacheForm_id = document.createElement('input');
                cacheForm_id.setAttribute('type','hidden');
                cacheForm_id.setAttribute('name', 'id');
                cacheForm_id.setAttribute('value', selectedId);
                cacheForm.appendChild(cacheForm_id);
                
                console.log(e.target.value, selectedId);
                document.body.appendChild(cacheForm);
                cacheForm.submit();
            }
        })
        let deleteBtn = $(contElem).find('.btn_delete');
        $(deleteBtn).on('click', (e) => {
            e.preventDefault();
            let cacheForm = document.createElement('form');
            cacheForm.setAttribute('method', 'post');
            cacheForm.setAttribute('action','/auth/delAuth.do');
            document.charset = "utf-8"

            let cacheForm_id = document.createElement('input');
            cacheForm_id.setAttribute('type','hidden');
            cacheForm_id.setAttribute('name', 'id');
            cacheForm_id.setAttribute('value', selectedId);
            cacheForm.appendChild(cacheForm_id);
            
            console.log(e.target.value, selectedId);
            document.body.appendChild(cacheForm);
            cacheForm.submit();
        })
    })  // 권한 버튼 이벤트 적용
    $('#list .member').each((idx, memberElem) => {
        $(memberElem).find('.updateBtn').on('click', (e) => {
            console.log('clicked ', e.target)
            let memberIdCache = $(memberElem).attr('aria-labelledby');
            $.ajax({
                type:"get",
                cache: false,
                url: '/auth/edit.do',
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                data: {
                    id: memberIdCache
                },
                success: (res) => {
                    addUpdateForm(res);
                },
                error: (res) => {
                    console.log('error :: ', res)
                }
            })
            function addUpdateForm(data) {
                let updateForm = document.createElement('div');
                updateForm.id = 'memberUpdateForm';
                updateForm.innerHTML = `
                <h1>수정하기</h1>
                <form action="">
                    아이디 : 		<input type="text" name="id" class="id" value="${data.user_id}"/> <br>
                    비밀번호 : 		<input type="password" name="password" class="password"/><br>
                    비밀번호확인 : 	<input type="password" name="passwordCon" class="passwordCon"/><br>
                    사용자명 : 		<input type="text" name="username" class="username" value="${data.name}"/><br>
                    이메일 : 		<input type="text" name="email" class="email" value="${data.email}"/><br>
                    권한 :
                    ${addSelect(data.authority_list, data.authority_id)}
                    <br>
                    <input type="submit" value="수정하기">
                </form>
                `;
                document.body.appendChild(updateForm);
            }   // 수정 폼을 받아서 생성한다.
            function addSelect(list, id) {
                console.log(list)
                let selectBox = document.createElement('select');
                selectBox.name = 'auth';
                selectBox.className = 'auth';
                for(let i=0;i<list.length;i++) {
                    let optionBox = document.createElement('option');
                    optionBox.value = list[i].authority_id
                    optionBox.innerHTML = list[i].authority_name
                    selectBox.appendChild(optionBox)
                    if(id === list[i].authority_id) optionBox.selected = true;
                }
                console.log(selectBox.innerHTML)
                return selectBox.outerHTML;
            }   // 셀렉트 리스트를 받아서, html로 변경후에 해당 문자열 부분을 리턴해준다.

        })  // 사용자 수정 버튼 클릭 이벤트
        $(memberElem).find('.deleteBtn').on('click', (e) => {

        })  // 사용자 삭제 버튼 클릭 이벤트
    })
    
}   
man_auth();

