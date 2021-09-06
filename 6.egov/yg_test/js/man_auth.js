let auth_cont = document.querySelectorAll('.auth_cont');
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
    })
})