
var TopMenuButton = $("#TOPnav ul li");     // 탑nav 메뉴버튼
var ContentSection = $("article section");  // 컨텐츠 섹션창

TopMenuButton.click(function(e) {
    e.preventDefault();                     // HTML의 # 기본기능 차단
    var CurrTargetButton = $(this);         // 입력된 버튼 변수할당
    var index = CurrTargetButton.index();
    var offset = ContentSection.eq(index).offset();
    $("html, body").animate({scrollTop: offset.top},600,"easeInOutQuint");
});

$("#TOPnav .icon").click(function(e) {
    // $("#TOPnav ul").css("display","block"); 
    $("#TOPnav ul").slideToggle(); 
});


// window 관련된 함수
$(window).scroll(function() {
    var CurrScroolVar = $(this).scrollTop();
    if(CurrScroolVar >= ContentSection.eq(0).offset().top) {
        TopMenuButton.removeClass("active");
        TopMenuButton.eq(0).addClass("active");
    }
    if(CurrScroolVar >= ContentSection.eq(1).offset().top) {
        TopMenuButton.removeClass("active");
        TopMenuButton.eq(1).addClass("active");
    }
    if(CurrScroolVar >= ContentSection.eq(2).offset().top) {
        TopMenuButton.removeClass("active");
        TopMenuButton.eq(2).addClass("active");
    }
    if(CurrScroolVar >= ContentSection.eq(3).offset().top) {
        TopMenuButton.removeClass("active");
        TopMenuButton.eq(3).addClass("active");
    }
    if(CurrScroolVar >= ContentSection.eq(4).offset().top) {
        TopMenuButton.removeClass("active");
        TopMenuButton.eq(4).addClass("active");
    }
});
// 탑메뉴의 active효과 적용(특정위치마다 적용하게 됨)

$(window).resize(function() {
     var CurrentWidth = $(window).width();
     if(CurrentWidth > 800 && $("#TOPnav ul").is(":hidden")) 
     $("#TOPnav ul").removeAttr("style");
});
// 화면크기 반응형 Toggle로 인해 생겨나는 추가 스타일속성 제거
