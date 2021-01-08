
const menuSide_step = document.querySelector("#side-step");
const cont_list = document.querySelector("#contents .col1 .contents_style ul li");

menuIcon.addEventListener("click", function() {
  if(onMenu) menuSide_step.classList.add("active");
  else menuSide_step.classList.remove("active");
});
menuSide_step.addEventListener("mouseenter", () => {
  cursor.classList.add("active");
});
menuSide_step.addEventListener("mouseleave", () => {
  cursor.classList.remove("active");
});

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
