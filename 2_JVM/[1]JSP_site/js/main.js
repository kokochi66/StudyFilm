const cursor = document.querySelector("#cursor");
const menu = document.querySelector("#menu");
const menuIcon = document.querySelector("#mIcon");
const menuSide = document.querySelector("#side");
const menuItem = document.querySelector(".side-contents");
const menuSide_Cont = document.querySelector("#side-cont");
const menuTitle = document.querySelector("#title");
var onMenu = false;

// 메뉴 아이콘 클릭 효과
menuIcon.addEventListener("click", function() {
  if(onMenu) {
    this.classList.remove("active");
    menuSide.classList.remove("active");
    menuSide_Cont.classList.remove("active");
  }
  else {
    this.classList.add("active");
    menuSide.classList.add("active");
    menuSide_Cont.classList.add("active");
  }
  onMenu = !onMenu;
});

// 커서이동
document.addEventListener("mousemove", function(e){
  gsap.to(cursor, {duration: .1, left: e.clientX -10, top: e.clientY });
});

// 스크롤시 메뉴의 색 변경효과
window.addEventListener('scroll', function(e){
  if(window.scrollY == 0) {
      menu.classList.remove("scroll");
      menuTitle.classList.remove("scroll");
      menuIcon.classList.remove("scroll");
  }
  else if(!onPage) {
    menu.classList.add("scroll");
    menuTitle.classList.add("scroll");
    menuIcon.classList.add("scroll");
  }
});

// 마우스 오버효과1
document.querySelectorAll(".mouseHover1").forEach(elem => {
  elem.addEventListener("mouseenter", () => {
    cursor.classList.add("active");
  });
  elem.addEventListener("mouseleave", () => {
    cursor.classList.remove("active");
  });
});
