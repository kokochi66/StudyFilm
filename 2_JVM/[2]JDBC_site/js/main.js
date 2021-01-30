// 변수선언
var nav = document.getElementById('nav');
    side_btn = document.querySelector('.menuBtn'),
    side = document.getElementById('side'),
    article = document.querySelector('article'),
    cont_text = document.querySelectorAll('#contents .step .text'),
    cont_bar = document.querySelectorAll('#contents .step .bar'),
    page = document.getElementById('page'),
    page_exit = document.getElementById('exit'),
    page_cont = document.querySelectorAll('#page .page_cont'),
    page_prev = document.getElementById('prev'),
    page_next = document.getElementById('next'),
    page_count = document.getElementById('count'),
    CurrPage_num = [],
    CurrPage = null,
    CurrPage_index = 0,
    CurrPageNum_index = 1,
    body = document.querySelector('body');


// 헤더 사이드 열기
side_btn.addEventListener('click', () => {
  if(side.classList.contains('active')) {
    side.classList.remove('active');
    side_btn.classList.remove('active');
  }
  else {
    side.classList.add('active');
    side_btn.classList.add('active');
  }
});

// 메인컨텐츠 마우스 오버효과
cont_text.forEach(elem => {
  elem.addEventListener('mouseenter', () => {
    elem.parentNode.classList.add('hover');
  });
  elem.addEventListener('mouseleave', () => {
    elem.parentNode.classList.remove('hover');
  })
});
cont_bar.forEach(elem => {
  elem.addEventListener('mouseenter', () => {
    elem.parentNode.classList.add('hover');
  });
  elem.addEventListener('mouseleave', () => {
    elem.parentNode.classList.remove('hover');
  })
});

// 페이지 열기/닫기
cont_text.forEach((elem,i) => {
  elem.addEventListener('click', () => {
    openPage(i);
  });
});
cont_bar.forEach((elem,i) => {
  elem.addEventListener('click', () => {
    openPage(i);
  });
})
body.addEventListener('click', function(e) {
  if(e.target == article) {
    body.classList.remove('doc');
    page_cont[CurrPage_index].classList.remove('active');
    page_cont[CurrPage_index].style.left = 50+'%';
  }
  if(e.target == page_exit) {
    body.classList.remove('doc');
    page_cont[CurrPage_index].classList.remove('active');
    page_cont[CurrPage_index].style.left = 50+'%';
  }
});

// 페이지 넘기기 (슬라이드)

locatePage();

page_prev.addEventListener('click', () => {
  prevPage();
});
page_next.addEventListener('click', () => {
  nextPage();
})


























// --페이지 넘기기 --
