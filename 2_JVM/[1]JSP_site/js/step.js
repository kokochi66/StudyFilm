
const menuSide_step = document.querySelector("#side-step");
const cont_list = document.querySelector("#contents .col1 .contents_style ul li");
var onPage = false;

// 메뉴 아이콘 클릭효과 (메인에 추가)
menuIcon.addEventListener("click", function() {
  if(onMenu) {
    menuSide_step.classList.add("active");
    $("#pIcon").css('z-index',50);
  }
  else {
    menuSide_step.classList.remove("active");
    $("#pIcon").css('z-index',102);
  }
});

// 사이드 마우스 오버효과
menuSide_step.addEventListener("mouseenter", () => {
  cursor.classList.add("active");
});
menuSide_step.addEventListener("mouseleave", () => {
  cursor.classList.remove("active");
});
// 게시판 마우스 오버효과
document.querySelectorAll("#contents .col .contents_style ul li").forEach(elem => {
  elem.addEventListener("mouseenter", () => {
    cursor.style.opacity = 0;
    elem.classList.add("active");
  });
  elem.addEventListener("mouseleave", () => {
    cursor.style.removeProperty("opacity");
    elem.classList.remove("active");
  });
});
// 페이지 아이콘 오버효과
$("#icon").hover(function(){
  cursor.classList.add("active");
}, function() {
  cursor.classList.remove("active");
});

// JDK 설치방법 문서열기
$(".page_btn").click(function(){
  $(this).parent().parent().siblings(".page").addClass("active");
  $("#pIcon").addClass("active");
  menu.classList.remove("scroll");
  menuTitle.classList.remove("scroll");
  menuIcon.classList.remove("scroll");
  onPage = true;
});
$("#pIcon #icon").click(function(){
  $(".page").removeClass("active");
  $("#pIcon").removeClass("active");
  menu.classList.add("scroll");
  menuTitle.classList.add("scroll");
  menuIcon.classList.add("scroll");
  onPage = false;
});

// 마우스 휠 고정이벤트 (문서가 켜졌을 때)
$("#wrap").on('scroll touchmove mousewheel', function(event) {
  if(onPage) {
    event.preventDefault();
    event.stopPropagation();
    return false;
  }
});

// 목차 클릭 이동 이벤트
var cont_li = [];
var winHeight = $(window).height()/10;
for(var i = 0; i < 5; i++) cont_li[i] = $("#contents .col").eq(i);
$("#contents .col1 .contents_style ul li").click(function(e){
  var index = $(this).index()+1;
  var offset = cont_li[index].offset().top - winHeight;
  $("html, body").animate({scrollTop:offset},550,"easeInOutExpo");
  // console.log(cont_li[index].offset().top +" "+ index);
})
$("#side-step li").click(function(e){
  var index = $(this).index();
  var offset = 0;
  if(index < 5) offset = cont_li[index].offset().top - winHeight;
  $("html, body").animate({scrollTop:offset},550,"easeInOutExpo");
});

























//
