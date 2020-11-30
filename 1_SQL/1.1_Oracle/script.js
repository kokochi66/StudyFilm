var TopMenu_button = $("#top .right a");
TopMenu_button.click(function(e) {
  e.preventDefault();
  var clicked = $(this);
  $("#top .right a").removeClass("active");
  clicked.addClass("active");
});
// 탑 메뉴 우측 언어선택

var Main_Content_adv = $(".version .col.left ul li a");
Main_Content_adv.click(function(e){
  e.preventDefault();
  var Main_Button = $(this);
  $(".version .col.left ul li a").removeClass("active");
  $(".version .col.center img").removeClass("active");
  $(".version .col.right .list").removeClass("active");
  Main_Button.addClass("active");
  if( $(".version .col.left ul li .a1").hasClass("active") ){
    $(".version .col.center .img1").addClass("active");
    $(".version .col.right .l1").addClass("active");
  }
  else if( $(".version .col.left ul li .a2").hasClass("active") ){
    $(".version .col.center .img2").addClass("active");
    $(".version .col.right .l2").addClass("active");
  }
  else if( $(".version .col.left ul li .a3").hasClass("active") ){
    $(".version .col.center .img3").addClass("active");
    $(".version .col.right .l3").addClass("active");
  }
  else if( $(".version .col.left ul li .a4").hasClass("active") ){
    $(".version .col.center .img4").addClass("active");
    $(".version .col.right .l4").addClass("active");
  }
  else if( $(".version .col.left ul li .a5").hasClass("active") ){
    $(".version .col.center .img5").addClass("active");
    $(".version .col.right .l5").addClass("active");
  }
  else if( $(".version .col.left ul li .a6").hasClass("active") ){
    $(".version .col.center .img6").addClass("active");
    $(".version .col.right .l6").addClass("active");
  }
});
