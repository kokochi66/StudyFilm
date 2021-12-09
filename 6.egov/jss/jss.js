
let spArr = document.querySelectorAll('.sp');
let wrap = document.querySelector('#wrap');
function lc(url) {
    location.href = url;
}

function active(idx) {
    let anList = document.querySelectorAll('.an-box');
    if(anList[idx].classList.contains('active')) {
        anList[idx].classList.remove('active');
    } else {
        anList[idx].classList.add('active');
    }
}

function init() {
    let quesArr = [];
    spArr.forEach((elem, idx) => {
        quesArr.push({ q:elem.querySelector('.sp-box').innerText , a:elem.querySelector('.an-box').innerHTML});
    })
    quesArr.sort((a,b)=> {
        return (a.q).localeCompare(b.q);
    })
    wrap.innerHTML = '';
    let html = '';
    quesArr.forEach((elem, idx) => {
        html += `
        <div class="sp">
            <div class="sp-box">${idx+1}. ${elem.q}</div>
            <div class="an-box">${elem.a}</div>
        </div>`
    })
    html += `
         <div class="np">
            <div class="back-box" onclick="lc('./line_jss.html')">돌아가기</div>
        </div>
    `;

    wrap.innerHTML = html;

    let spList = document.querySelectorAll('.sp-box');
    spList.forEach((elem, idx) => {
        elem.setAttribute('onclick','active('+idx+')');
    })

}
init();