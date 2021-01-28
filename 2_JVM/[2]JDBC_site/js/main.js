// 변수선언
var side_btn = document.querySelector('.menuBtn'),
    side = document.getElementById('side'),
    cont_text = document.querySelectorAll('#contents .step .text'),
    cont_bar = document.querySelectorAll('#contents .step .bar');


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
