var cont_text = document.querySelectorAll('#contents .step .text'),
    cont_bar = document.querySelectorAll('#contents .step .bar');

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
