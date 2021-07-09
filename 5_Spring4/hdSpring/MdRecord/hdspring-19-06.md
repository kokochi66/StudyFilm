<h1>관리자 생성과 로그인/로그아웃</h1>
<h2>관리자 생성</h2>
<p>
    서버에서 ADMIN 권한을 가진 최초 관리자를 생성합니다. 이 구현의 경우에는, 아이디를 만드는 경우에, 최초의 사용자라면 setup 버튼이 활성화되고, 활성회된 버튼을 클릭하면 setup페이지로 넘어가서 관리자권한의 계정을 만들 수 있도록 하는 방법을 사용하였다. 구현방법은 일반 계정을 생성하는 방식과 동일하며, 컨트롤러에서 Member 테이블의 칼럼이 몇개 존재하는지를 확인하고, 0개라면 관리자 계정을 사용하도록 구현하였다.
</p>
<pre>
@RequestMapping(value="/setup", method=RequestMethod.GET)
public String setupAdminForm(Member member, Model model) throws Exception {
    if(service.countAll() == 0) return "user/setup";
    return "redirect:/user/list";
}
@RequestMapping(value="/setup", method=RequestMethod.POST)
public String setupAdmin(Member member, RedirectAttributes rttr) throws Exception {
    if(service.countAll() == 0) {
        String inputPassword = member.getUserPw();
        member.setUserPw(passwordEncoder.encode(inputPassword));
        member.setJob("00");
        service.setupAdmin(member);
        rttr.addFlashAttribute("userName", member.getUserName());
        return "redirect:/user/list";
    }
    return "redirect:/user/setupFailure";
}
</pre><br>

<h2>로그인 기능 구현</h2>
<pre>
&lt;dependency&gt;
    &lt;groupId&gt;aspectj&lt;/groupId&gt;
    &lt;artifactId&gt;aspectjrt&lt;/artifactId&gt;
    &lt;version&gt;1.5.4&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;aspectj&lt;/groupId&gt;
    &lt;artifactId&gt;aspectjweaver&lt;/artifactId&gt;
    &lt;version&gt;1.5.4&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<p> 
    먼저 로그인 기능을 위해서 AOP 관련 의존 관계를 정의한다.
</p>