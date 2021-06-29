<h1> 실습 프로젝트 생성 및 기본 설정 </h1>
<h2>기본 pom.xml 설정</h2>
<pre>
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;project xmlns=&quot;http://maven.apache.org/POM/4.0.0&quot; xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;
	xsi:schemaLocation=&quot;http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd&quot;&gt;
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
  &lt;dependencies&gt;
  	&lt;!-- 스프링 설정 --&gt;
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
  	

  	&lt;!-- AspectJ 설정 --&gt;
  	&lt;dependency&gt;
  		&lt;groupId&gt;org.aspectj&lt;/groupId&gt;
  		&lt;artifactId&gt;aspectjrt&lt;/artifactId&gt;
  		&lt;version&gt;${org.aspectj-version}&lt;/version&gt;
  	&lt;/dependency&gt;
  	
  	
  	&lt;!-- Logging 설정 --&gt;
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
  	
  	
  	&lt;!-- @Inject 설정 --&gt;
  	&lt;dependency&gt;
  		&lt;groupId&gt;javax.inject&lt;/groupId&gt;
  		&lt;artifactId&gt;javax.inject&lt;/artifactId&gt;
  		&lt;version&gt;1&lt;/version&gt;
  	&lt;/dependency&gt;
  	
  	
  	&lt;!-- Servlet 설정 --&gt;
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
  	
  	
  	
  	&lt;!-- 테스트용 junit --&gt;
  	&lt;dependency&gt;
  		&lt;groupId&gt;junit&lt;/groupId&gt;
  		&lt;artifactId&gt;junit&lt;/artifactId&gt;
  		&lt;version&gt;4.7&lt;/version&gt;
  	&lt;/dependency&gt;
  &lt;/dependencies&gt;
  
  
  
   	&lt;build&gt;
  		&lt;plugins&gt;
  			&lt;plugin&gt;
  				&lt;artifactId&gt;maven-eclipse-plugin&lt;/artifactId&gt;
  				&lt;version&gt;2.9&lt;/version&gt;
  				&lt;configuration&gt;
  					&lt;additionalProjectnatures&gt;
  						&lt;projectnature&gt;org.springframework.ide.eclipse.core.springnature&lt;/projectnature&gt;
  					&lt;/additionalProjectnatures&gt;
  					&lt;additionalBuildcommands&gt;
  						&lt;buildcommand&gt;org.springframework.ide.eclipse.core.springbuilder&lt;/buildcommand&gt;
  					&lt;/additionalBuildcommands&gt;
  					&lt;downloadSources&gt;true&lt;/downloadSources&gt;
  					&lt;downloadJavadocs&gt;true&lt;/downloadJavadocs&gt;
  				&lt;/configuration&gt;
  			&lt;/plugin&gt;
  			&lt;plugin&gt;
  				&lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;
  				&lt;artifactId&gt;maven-compiler-plugin&lt;/artifactId&gt;
  				&lt;version&gt;2.5.1&lt;/version&gt;
  				&lt;configuration&gt;
  					&lt;source&gt;1.6&lt;/source&gt;
  					&lt;target&gt;1.6&lt;/target&gt;
  					&lt;compilerArgument&gt;-Xlint:all&lt;/compilerArgument&gt;
  					&lt;showWarnings&gt;true&lt;/showWarnings&gt;
  					&lt;showDeprecation&gt;true&lt;/showDeprecation&gt;
  				&lt;/configuration&gt;
  			&lt;/plugin&gt;
  			&lt;plugin&gt;
  				&lt;groupId&gt;org.codehaus.mojo&lt;/groupId&gt;
  				&lt;artifactId&gt;exec-maven-plugin&lt;/artifactId&gt;
  				&lt;version&gt;1.2.1&lt;/version&gt;
  				&lt;configuration&gt;
  					&lt;mainClass&gt;org.test.int1.Main&lt;/mainClass&gt;
  				&lt;/configuration&gt;
  			&lt;/plugin&gt;
  			&lt;plugin&gt;
               	&lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;
               	&lt;artifactId&gt;maven-war-plugin&lt;/artifactId&gt;
               	&lt;version&gt;2.4&lt;/version&gt;
               	&lt;configuration&gt;
               		&lt;warSourceDirectory&gt;src/main/webapp&lt;/warSourceDirectory&gt;
					&lt;warName&gt;sample&lt;/warName&gt;
               		&lt;failOnMissingWebXml&gt;false&lt;/failOnMissingWebXml&gt;
               	&lt;/configuration&gt;
            &lt;/plugin&gt;
  		&lt;/plugins&gt;
  	&lt;/build&gt;
&lt;/project&gt;
</pre>
<p> 
	
</p>