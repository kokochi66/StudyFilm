<h1> 실습 프로젝트 생성 및 기본 설정 </h1>
<h2>기본 pom.xml 설정</h2>
<pre>
&lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
&lt;groupId&gt;org.kokochi.prj&lt;/groupId&gt;
&lt;artifactId&gt;controller&lt;/artifactId&gt;
&lt;version&gt;1.0.0-BUILD-SNAPSHOT&lt;/version&gt;
&lt;packaging&gt;war&lt;/packaging&gt;
&lt;name&gt;kokochikochi&lt;/name&gt;
&lt;properties&gt;
	&lt;java-version&gt;1.6&lt;/java-version&gt;
	&lt;org.springframework-version&gt;3.1.1.RELEASE&lt;/org.springframework-version&gt;
	&lt;org.aspectj-version&gt;1.6.10&lt;/org.aspectj-version&gt;
	&lt;org.slf4j-version&gt;1.6.6&lt;/org.slf4j-version&gt;
&lt;/properties&gt;
</pre>
<p> 
	기본 자바 1.6 버전으로 첫 세팅을 하였습니다. 이외에 스프링 프레임 워크의 버전을 지정하고, aspectj, 로그를 위한 slf4j의 버전을 등록합니다.
</p><br>

<pre>
&lt;dependency&gt;
	&lt;groupId&gt;org.springframework&lt;/groupId&gt;
	&lt;artifactId&gt;spring-context&lt;/artifactId&gt;
	&lt;version&gt;${org.springframework-version}&lt;/version&gt;
	&lt;exclusions&gt;
		&lt;!-- SLF4j의 로깅 적용을 위한commons-logging 등록 --&gt;
		&lt;exclusion&gt;
			&lt;groupId&gt;commons-logging&lt;/groupId&gt;
			&lt;artifactId&gt;commons-logging&lt;/artifactId&gt;
		&lt;/exclusion&gt;
	&lt;/exclusions&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.springframework&lt;/groupId&gt;
	&lt;artifactId&gt;spring-webmvc&lt;/artifactId&gt;
	&lt;version&gt;${org.springframework-version}&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<p> 
	스프링 설정으로 스프링 컨텍스트와 스프링 webmvc를 등록해주며, SLF4J 로깅적용을 위해서 exclusions로 commons-loggin을 등록해준다.
</p><br>

<pre>
&lt;dependency&gt;
	&lt;groupId&gt;org.aspectj&lt;/groupId&gt;
	&lt;artifactId&gt;aspectjrt&lt;/artifactId&gt;
	&lt;version&gt;${org.aspectj-version}&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<p> 
	자바 AOP 확장 기능 사용을 위한 AspectJ를 등록해준다.
</p><br>

<pre>
&lt;dependency&gt;
	&lt;groupId&gt;org.slf4j&lt;/groupId&gt;
	&lt;artifactId&gt;slf4j-api&lt;/artifactId&gt;
	&lt;version&gt;${org.slf4j-version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.slf4j&lt;/groupId&gt;
	&lt;artifactId&gt;jcl-over-slf4j&lt;/artifactId&gt;
	&lt;version&gt;${org.slf4j-version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.slf4j&lt;/groupId&gt;
	&lt;artifactId&gt;slf4j-log4j12&lt;/artifactId&gt;
	&lt;version&gt;${org.slf4j-version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;log4j&lt;/groupId&gt;
	&lt;artifactId&gt;log4j&lt;/artifactId&gt;
	&lt;version&gt;1.2.15&lt;/version&gt;
	&lt;exclusions&gt;
		&lt;exclusion&gt;
			&lt;groupId&gt;javax.mail&lt;/groupId&gt;
			&lt;artifactId&gt;mail&lt;/artifactId&gt;
		&lt;/exclusion&gt;
		&lt;exclusion&gt;
			&lt;groupId&gt;javax.jms&lt;/groupId&gt;
			&lt;artifactId&gt;jms&lt;/artifactId&gt;
		&lt;/exclusion&gt;
		&lt;exclusion&gt;
			&lt;groupId&gt;com.sun.jdmk&lt;/groupId&gt;
			&lt;artifactId&gt;jmxtools&lt;/artifactId&gt;
		&lt;/exclusion&gt;
		&lt;exclusion&gt;
			&lt;groupId&gt;com.sun.jmx&lt;/groupId&gt;
			&lt;artifactId&gt;jmxri&lt;/artifactId&gt;
		&lt;/exclusion&gt;
	&lt;/exclusions&gt;
	&lt;scope&gt;runtime&lt;/scope&gt;
&lt;/dependency&gt;
</pre>
<p> 
	로거 사용을 위한 상세 로그 등록을 해준다.<br>
	SLF4J에 대한 상세한 내용은 <a href="https://gmlwjd9405.github.io/2019/01/04/logging-with-slf4j.html">링크</a>를 참조 하도록 하자.
</p><br>

<pre>
&lt;dependency&gt;
	&lt;groupId&gt;javax.inject&lt;/groupId&gt;
	&lt;artifactId&gt;javax.inject&lt;/artifactId&gt;
	&lt;version&gt;1&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<p> 
	어노테이션 @Inject를 사용하기 위한 의존 등록을 해준다. @Resource, @Autowired, @Inject 어노테이션의 각각 사용의 차이에 대해서 더 자세한 내용은 <a href="https://velog.io/@sungmo738/Resource-Autowired-Inject-%EC%B0%A8%EC%9D%B4">링크</a>를 참조하도록 하자.
</p><br>

<pre>
&lt;dependency&gt;
	&lt;groupId&gt;javax.servlet&lt;/groupId&gt;
	&lt;artifactId&gt;servlet-api&lt;/artifactId&gt;
	&lt;version&gt;2.5&lt;/version&gt;
	&lt;scope&gt;provided&lt;/scope&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;javax.servlet.jsp&lt;/groupId&gt;
	&lt;artifactId&gt;jsp-api&lt;/artifactId&gt;
	&lt;version&gt;2.1&lt;/version&gt;
	&lt;scope&gt;provided&lt;/scope&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;javax.servlet&lt;/groupId&gt;
	&lt;artifactId&gt;jstl&lt;/artifactId&gt;
	&lt;version&gt;1.2&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<p> 자바 동적 페이지 생성하는 역할을 하는 서블릿을 의존 등록 해준다. </p>
<p> 기본적인 의존 등록은 여기까지이며, 추가적인 플러그인 등록에 대해서 더 자세한 사항이 궁금하다면 <a href="https://github.com/kokochi66/StudyFilm_BackEnd_kokochi/blob/main/5_Spring4/hdSpring/kokochiPRJ/pom.xml">pom.xml</a> 파일을 확인하도록 하자.</p><br><br>

<h2>web.xml 웹 컨테이너 설정</h2>
<pre>
&lt;context-param&gt;
	&lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
	&lt;param-value&gt;/WEB-INF/spring/root-context.xml&lt;/param-value&gt;
&lt;/context-param&gt;
</pre>
<p>서블릿과 필터를 설정하는 루트 컨텍스트 설정 파일의 경로를 지정해준다. 해당 경로에 root-context.xml 파일을 생성해야 한다.</p><br>

<pre>
&lt;listener&gt;
	&lt;listener-class&gt;org.springframework.web.context.ContextLoaderListener&lt;/listener-class&gt;
&lt;/listener&gt;
</pre>
<p>스프링 컨테이너를 생성하여 리스너로 적용해준다.</p><br>

<pre>
&lt;servlet&gt;
	&lt;servlet-name&gt;appServlet&lt;/servlet-name&gt;
	&lt;servlet-class&gt;org.springframework.web.servlet.DispatcherServlet&lt;/servlet-class&gt;
	&lt;init-param&gt;
		&lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
		&lt;param-value&gt;/WEB-INF/spring/appServlet/servlet-context.xml&lt;/param-value&gt;
	&lt;/init-param&gt;
	&lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
&lt;/servlet&gt;
</pre>
<pre>
&lt;servlet-mapping&gt;
	&lt;servlet-name&gt;appServlet&lt;/servlet-name&gt;
	&lt;url-pattern&gt;/&lt;/url-pattern&gt;
&lt;/servlet-mapping&gt;
</pre>
<p> 어플리케이션의 종합적인 요청 처리를 해주는 appServlet을 생성하여 등록한다. 서블릿의 경로 역시 지정해주며, 해당 경로에 servlet-context.xml 파일을 생성하여 등록해야 한다.</p>
<p>
	그 후에 서블릿을 url 패턴에 매핑을 시켜주는 설정을 해주면 된다.
</p><br><br>

<h2>servlet-context.xml 파일 설정</h2>
<pre>
&lt;beans:beans xmlns=&quot;http://www.springframework.org/schema/mvc&quot;
	xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;
	xmlns:beans=&quot;http://www.springframework.org/schema/beans&quot;
	xmlns:context=&quot;http://www.springframework.org/schema/context&quot;
	xsi:schemaLocation=&quot;http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd&quot;&gt;
</pre>
<p> 가장 먼저 사용할 prefix를 beans에 등록해 주어야 한다. servlet-context 파일은 DispatcherServlet 객체이며, 해당 서블릿에 필요한 설정을 해주어야한다.</p><br>

<pre>
&lt;annotation-driven /&gt;
</pre>
<p> 먼저 스프링 MVC의 @Controller 프로그래밍 모델을 활성화 하기 위해서 annotation-driven 태그를 선언한다.</p><br>
<pre>
&lt;resources mapping=&quot;/resources/**&quot; location=&quot;/resources/&quot; /&gt;
</pre>
<p>HTTP의 GET 요청에 해당하는 리소스 매핑을 지정한다.</p><br>
<pre>
&lt;beans:bean class=&quot;org.springframework.web.servlet.view.InternalResourceViewResolver&quot;&gt;
	&lt;beans:property name=&quot;prefix&quot; value=&quot;/WEB-INF/views/&quot; /&gt;
	&lt;beans:property name=&quot;suffix&quot; value=&quot;.jsp&quot; /&gt;
&lt;/beans:bean&gt;
</pre>
<p> @Controller에서 렌더링 되는 뷰 파일의 뷰 리졸버를 설정한다. prefix와 suffix를 각각 설정해주어, 뷰 파일의 경로를 지정해주면 된다</p><br>
<pre>
&lt;context:component-scan base-package=&quot;org.kokochi.prj.controller&quot; /&gt;
</pre>
<p>마지막으로, 컨트롤러 빈 객체가 위치하는 곳을 context:component-scan 태그에 넣어주면 @Controller 어노테이션을 인식하여 url매핑을 하도록 해준다.</p><br>
<p> 나머지 파일 설정과 상세 로그 설정 등은 프로젝트를 통해서 확인하자. 현 실전 프로젝트는 뷰 파일 적용을 간단하게 하기 위해서 간단한 부트스트램 프레임워크를 사용하여 뷰를 적용하였다.</p>