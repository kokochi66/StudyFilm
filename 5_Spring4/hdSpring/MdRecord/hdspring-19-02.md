<h1>홈 화면 구현과 타일즈 처리</h1>
<h2> 메시지 프로퍼티 파일 처리 </h2>
<pre>
&lt;bean id=&quot;messageSource&quot; class=&quot;org.springframework.context.support.ResourceBundleMessageSource&quot;&gt;
	&lt;property name=&quot;basenames&quot;&gt;
		&lt;list&gt;
			&lt;value&gt;ApplicationMessage&lt;/value&gt;
		&lt;/list&gt;
	&lt;/property&gt;
&lt;/bean&gt;
</pre>
<p> 메시지 프로퍼티 파일을 사용하기 위해서, ResourceBundleMessageSource 객체를 불러오고, 프로퍼티 파일의 경로를 지정해준다. 경로는 resource 패키지이다. 설정 후에, 태그 라이브러리 spring으로 message 값으로 불러들여서 사용할 수 있게된다.</p><br><br>

<h2> 타일즈 설정 </h2>
<pre>
&lt;dependency&gt;
	&lt;groupId&gt;org.apache.tiles&lt;/groupId&gt;
	&lt;artifactId&gt;tiles-core&lt;/artifactId&gt;
	&lt;version&gt;${apachetiles.version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.apache.tiles&lt;/groupId&gt;
	&lt;artifactId&gt;tiles-api&lt;/artifactId&gt;
	&lt;version&gt;${apachetiles.version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.apache.tiles&lt;/groupId&gt;
	&lt;artifactId&gt;tiles-servlet&lt;/artifactId&gt;
	&lt;version&gt;${apachetiles.version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.apache.tiles&lt;/groupId&gt;
	&lt;artifactId&gt;tiles-jsp&lt;/artifactId&gt;
	&lt;version&gt;${apachetiles.version}&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<p> Tiles 라이브러리 사용을 위한 관련 의존 설정을 지정해준다.<p><br>
<pre>
&lt;beans:bean class=&quot;org.springframework.web.servlet.view.InternalResourceViewResolver&quot;&gt;
	&lt;beans:property name=&quot;prefix&quot; value=&quot;/WEB-INF/views/&quot; /&gt;
	&lt;beans:property name=&quot;suffix&quot; value=&quot;.jsp&quot; /&gt;
	<strong>&lt;beans:property name=&quot;order&quot; value=&quot;2&quot; /&gt;</strong>
&lt;/beans:bean&gt;
</pre>
<pre>
&lt;beans:bean id=&quot;tilesViewResolver&quot; class=&quot;org.springframework.web.servlet.view.UrlBasedViewResolver&quot;&gt;
	&lt;beans:property name=&quot;viewClass&quot; value=&quot;org.springframework.web.servlet.view.tiles3.TilesConfigurer&quot; /&gt;
	&lt;beans:property name=&quot;order&quot; value=&quot;1&quot; /&gt;
&lt;/beans:bean&gt;
</pre>
<p>servlet-context.xml 설정 파일에서 기존에 설정한 뷰 리졸버의 우선순위인 order 값을 2로 주고, tiles를 이용한 매핑을 사용하기 위해서 tiles를 이용한 뷰 리졸버 객체의 우선순위를 1로 설정해준다.</p><br>
<pre>
&lt;beans:bean id=&quot;tilesConfigurer&quot; class=&quot;org.springframework.web.servlet.view.tiles3.TilesConfigurer&quot;&gt;
	&lt;beans:property name=&quot;definitions&quot;&gt;
		&lt;beans:list&gt;
			&lt;beans:value&gt;/WEB-INF/tiles/tiles.xml&lt;/beans:value&gt;
		&lt;/beans:list&gt;
	&lt;/beans:property&gt;
&lt;/beans:bean&gt;
</pre>
<p>마지막으로 servlet-context.xml에 Configurer 객체를 생성하여, tiles의 설정파일을 등록해주고, 해당 설정 파일의 경로를 위와 같이 지정해주면 된다.</p>
<p>Tiles 라이브러리는  반복적으로 사용되는 JSP의 부분들을 따로 모아서 관리하는 역할을 하며, 설정 파일 중 일부만 변경하는 것으로 공통 부분 수정을 가능하게 해준다. 라이브러리에 대한 자세한 설명은 <a href="https://codingwell.tistory.com/45">링크</a>를 참조하도록 하자.</p><br>
<p> 
타일즈 설정을 이용해서 메인 페이지를 모듈화 시킨 형태는 다음 프로젝트의 파일들을 확인하자<br>
<a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/src/main/webapp/WEB-INF/tiles">Tiles 폴더</a> 
</p>