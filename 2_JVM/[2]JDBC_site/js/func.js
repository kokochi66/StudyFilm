function locatePage() {
  for(var i = 0; i < page_cont.length ; i ++) {
    var cNum = page_cont[i].querySelectorAll('.page_num');
    for(var j = 0 ; j < cNum.length ; j ++) {
      cNum[j].style.left = (j * 100) + '%';
    }
  }
}
// 페이지의 위치를 지정하는 함수
function openPage(i) {
  body.classList.add('doc');
  page_cont[i].classList.add('active');
  CurrPage = page_cont[i];
  CurrPage_num = CurrPage.querySelectorAll('.page_num');
  CurrPage_index = i;
  CurrPageNum_index = 1;
  page_count.innerHTML = CurrPageNum_index;
}
// 페이지를 여는 함수

function nextPage() {
  if(CurrPageNum_index < CurrPage_num.length) {
    CurrPageNum_index++;
    page_cont[CurrPage_index].style.left = (50 - ((CurrPageNum_index-1) * 100)) + '%';
    page_count.innerHTML = CurrPageNum_index;
  }
}
function prevPage() {
  if(CurrPageNum_index > 1) {
    CurrPageNum_index--;
    page_cont[CurrPage_index].style.left = (50 - ((CurrPageNum_index-1) * 100)) + '%';
    page_count.innerHTML = CurrPageNum_index;
  }
}
// 페이지 이동
































//
