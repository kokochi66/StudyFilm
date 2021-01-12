
const menuSide_step = document.querySelector("#side-step");
const cont_list = document.querySelector("#contents #head .contents_style ul li");
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
// 페이지 넘버 오버효과와 클릭효과
var cPage = $("#contents .col .page");
var page_Num = cPage.find(".cont").find(".page-Num").find("li");
var page_Style = cPage.find(".cont").find(".page-style").find("li");
page_Num.hover(function(){
  cursor.style.opacity = 0;
}, function() {
  cursor.style.removeProperty("opacity");
});
page_Num.click(function() {
  var index = $(this).index();
  page_Num.removeClass("active");
  $(this).addClass("active");
  page_Style.removeClass("active");
  page_Style.eq(index).addClass("active");
  $("#contents .col .page .cont .page-style .number").text(index+1);
});

// 페이지 문서닫기
$("#pIcon #icon").click(function(){
  $("#pIcon").removeClass("active");
  cPage.removeClass("active");
  page_Num.removeClass("active");
  page_Style.removeClass("active");
  menu.classList.add("scroll");
  menuTitle.classList.add("scroll");
  menuIcon.classList.add("scroll");
  onPage = false;
});

// 마지막 페이지 문서열기 (나중에 수정필요 -> 한번에 되게 해주는게 좋을듯)
$(".page_btns").click(function() {
  var index = $(this).index();
  cPage = $(this).parent().parent().siblings(".page").eq(index);
  page_Num = cPage.find(".cont").find(".page-Num").find("li");
  page_Style = cPage.find(".cont").find(".page-style").find("li");
  cPage.addClass("active");
  page_Num.eq(0).addClass("active");
  page_Style.eq(0).addClass("active");
  cPage.find(".cont").find(".page-style").find(".number").text(1);
  $("#pIcon").addClass("active");
  menu.classList.remove("scroll");
  menuTitle.classList.remove("scroll");
  menuIcon.classList.remove("scroll");
  onPage = true;
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
for(var i = 0; i < $("#contents .col").length; i++) cont_li[i] = $("#contents .col").eq(i);
$("#contents #head .contents_style ul li").click(function(e){
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
