<h1>회원 관리하기</h1>
<h2>회원 관리</h2>
<h3> 입력값 검증, 스프링 시큐리티 라이브러리 추가</h3>
<pre>
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.security&lt;/groupId&gt;
    &lt;artifactId&gt;spring-security-web&lt;/artifactId&gt;
    &lt;version&gt;5.0.7.RELEASE&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.security&lt;/groupId&gt;
    &lt;artifactId&gt;spring-security-config&lt;/artifactId&gt;
    &lt;version&gt;5.0.7.RELEASE&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.security&lt;/groupId&gt;
    &lt;artifactId&gt;spring-security-core&lt;/artifactId&gt;
    &lt;version&gt;5.0.7.RELEASE&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.security&lt;/groupId&gt;
    &lt;artifactId&gt;spring-security-taglibs&lt;/artifactId&gt;
    &lt;version&gt;5.0.7.RELEASE&lt;/version&gt;
&lt;/dependency&gt;
</pre><br>
<h3>contextConfigLocation에 스프링 시큐리티 설정 파일 지정</h3>
<pre>
&lt;context-param&gt;
    &lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
    &lt;param-value&gt;
        /WEB-INF/spring/root-context.xml
        <strong>/WEB-INF/spring-security-context.xml</strong>
    &lt;/param-value&gt;
&lt;/context-param&gt;
</pre>
<pre>
&lt;filter&gt;
    &lt;filter-name&gt;springSecurityFilterChain&lt;/filter-name&gt;
    &lt;filter-class&gt;org.springframework.web.filter.DelegatingFilterProxy&lt;/filter-class&gt;
&lt;/filter&gt;
&lt;filter-mapping&gt;
    &lt;filter-name&gt;springSecurityFilterChain&lt;/filter-name&gt;
    &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
</pre>
<p>
    추가로 스프링 시큐리티가 제공하는 서블릿 필터 클래스를 서블릿 컨테이너에 등록한다.  
</p><br>
<h3>회원정보 등록/보기/수정/삭제 기능 및 조회 구현</h3>
<p> 
    회원 관리를 총 컨트롤러 - 서비스 - 매퍼와 Mybatis를 이용한 전체적인 구조를 구성하고, Mybatis에 쿼리문을 작성하여 정상적으로 사용자 계정 생성, 보기, 수정, 삭제 작업이 이루어지도록 구현한다. 구현 내용은 다음과 같다.
</p>
<ul>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/controller/CodeClassController.java">MemberController.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/service/CodeClassService.java">MemberServiceImpl.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/domain/Member.java">Member.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/mapper/CodeClassMapper.java">MemberMapper.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/resources/org/kokochi/prj/mapper/MemberMapper.xml">MemberMapper.xml</a></li>
</ul>
<p>
    부트스트랩을 이용하여 구현한 예제화면은 다음과 같다.
</p>
<img src="https://user-images.githubusercontent.com/61536109/124594078-5528d000-de9a-11eb-9e95-e6503a6fa939.png" width="500px">