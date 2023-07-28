$('.login_form').keypress((event) => {
    if(event.which == 13) {
    submitPost()
    }
})
$('.login_btn').click(() => {
    submitPost()
});