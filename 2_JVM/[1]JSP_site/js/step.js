
const menuSide_step = document.querySelector("#side-step");
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
