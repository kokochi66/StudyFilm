const cursor = document.querySelector("#cursor");
const menu = document.querySelector("#menu");
const menuIcon = document.querySelector("#mIcon");
const menuSide = document.querySelector("#side");
const menuItem = document.querySelector(".side-contents");
const menuSide_Cont = document.querySelector("#side-cont");
const menuTitle = document.querySelector("#title");
var onMenu = false;
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
document.addEventListener("mousemove", function(e){
  gsap.to(cursor, {duration: .1, left: e.clientX -10, top: e.clientY });
});
menuIcon.addEventListener("mouseenter", () => {
  cursor.classList.add("active");
});
menuIcon.addEventListener("mouseleave", () => {
  cursor.classList.remove("active");
});
menuTitle.addEventListener("mouseenter", () => {
  cursor.classList.add("active");
});
menuTitle.addEventListener("mouseleave", () => {
  cursor.classList.remove("active");
});
document.querySelectorAll(".side-contents a").forEach(elem => {
  elem.addEventListener("mouseenter", () => {
    cursor.classList.add("active");
  });
  elem.addEventListener("mouseleave", () => {
    cursor.classList.remove("active");
  });
});

window.addEventListener('scroll', function(e){
  if(window.scrollY == 0) {
      menu.classList.remove("scroll");
      menuTitle.classList.remove("scroll");
      menuIcon.classList.remove("scroll");
  }
  else {
    menu.classList.add("scroll");
    menuTitle.classList.add("scroll");
    menuIcon.classList.add("scroll");
  }
});
