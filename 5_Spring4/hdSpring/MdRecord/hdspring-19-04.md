<h1>코드그룹 관리하기</h1>
<p> 
    코드그룹을 관리하는 페이지 생성을 위해서, 코드 관리를 위한 도메인, mybatis 적용을 위한 mapper, 데이터베이스  처리를 위한 service단을 구현한다.
</p><br><br >
<h2> 한글 처리를 위한 UTF-8 필터 등록하기 </h2>
<pre>
&lt;filter&gt;
    &lt;filter-name&gt;encodingFilter&lt;/filter-name&gt;
    &lt;filter-class&gt;org.springframework.web.filter.CharacterEncodingFilter&lt;/filter-class&gt;
    &lt;init-param&gt;
        &lt;param-name&gt;encoding&lt;/param-name&gt;
        &lt;param-value&gt;UTF-8&lt;/param-value&gt;
    &lt;/init-param&gt;
&lt;/filter&gt;

&lt;filter-mapping&gt;
    &lt;filter-name&gt;encodingFilter&lt;/filter-name&gt;
    &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
</pre>
<p> web.xml 파일에 위와같은 필터를 등록한다.</p> <br><br>

<h2> Mapper 인터페이스에 대한 스캔과 service 스캔대상 설정 </h2>
<pre>
&lt;mybatis-spring:scan base-package=&quot;org.kokochi.prj.mapper&quot;/&gt;
&lt;context:component-scan base-package=&quot;org.kokochi.prj.service&quot;&gt;&lt;/context:component-scan&gt;
</pre>
<p> root-context.xml 파일에 위와같이 스캔설정을 등록한다.</p><br><br>

<p> 위 설정이 완료되면, mybatis 설정파일인 mybatis-config.xml 에 프로퍼티와 도메인을 설정하고, 이에 맞게 도메인과 매퍼, 서비스 클래스를 설정한다. 이에 대한 상세한 코딩 내용은 각 파일을 참조하자.</p>
<ul>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/controller/CodeClassController.java">CodeClassController.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/service/CodeClassService.java">CodeClassService.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/service/CodeClassServiceImpl.java">CodeClassServiceImpl.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/mapper/CodeClassMapper.java">CodeClassMapper.java</a></li>
  <li><a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/java/org/kokochi/prj/domain/CodeClass.java">CodeClass.java</a></li>
</ul>