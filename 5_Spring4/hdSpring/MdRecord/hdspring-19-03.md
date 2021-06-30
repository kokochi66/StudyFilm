<h1>데이터베이스 연동과 테이블  생성</h1>
<h2> 테이블 생성 </h2>
<p> 데이터베이스는 MySQL을 사용하며, 스키마 생성 및 워크벤치 사용법과 사용자 권한 설정에 관한 부분의 설명은 생략한다. 이에 대한 상세 내용은 교재와 별도로 찾아보자</p><br>
<h3>코드그룹 테이블과 코드 테이블</h3>
<pre>
CREATE TABLE code_class (
	class_code CHAR(3) NOT NULL,
    class_name VARCHAR(30) NOT NULL,
    use_yn CHAR(1) NOT NULL DEFAULT 'Y',
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    upd_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (class_code)
);
</pre>
<pre>
CREATE TABLE code_detail(
	class_code CHAR(3) NOT NULL,
    code_value VARCHAR(3) NOT NULL,
    code_name VARCHAR(30) NOT NULL,
    sort_seq INT NOT NULL,
    use_yn CHAR(1) NOT NULL DEFAULT 'Y',
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    upd_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (class_code, code_value)
);
</pre><br>

<h3>회원 테이블과 회원의 권한 테이블</h3>
<pre>
CREATE TABLE member(
	user_no INT(5) AUTO_INCREMENT,
    user_id VARCHAR(30) NOT NULL,
    user_pw VARCHAR(50) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    job VARCHAR(3) NOT NULL DEFAULT '00',
    coin INT(10) DEFAULT 0,
    reg_date TIMESTAMP DEFAULT now(),
    upd_date TIMESTAMP DEFAULT now(),
    enabled CHAR(1) DEFAULT '1',
    PRIMARY KEY (user_no)
);
</pre>
<pre>
CREATE TABLE member_auth (
	user_no INT(5) NOT NULL,
    auth VARCHAR(50) NOT NULL
);
</pre>
<pre>
ALTER TABLE member_auth ADD CONSTRAINT fk_member_auth_user_no FOREIGN KEY (user_no) REFERENCES member(user_no);
</pre><br>

<h3>로그인 상태 유지 테이블</h3>
<pre>
CREATE TABLE persistent_logins (
	username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);
</pre><br>

<h3>회원 게시판과 공지사항 게시판 테이블</h3>
<pre>
CREATE TABLE board (
	board_no INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    writer VARCHAR(50) NOT NULL, 
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY(board_no)
);
</pre>
<pre>
CREATE TABLE notice (
	notice_no INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (notice_no)
);
</pre><br>

<h3>상품 테이블과 사용자 상품 테이블</h3>
<pre>
CREATE TABLE item (
	item_id INT(5) AUTO_INCREMENT,
    item_name VARCHAR(20),
    price INT(6),
    description VARCHAR(50),
    picture_url VARCHAR(200),
    PRIMAR
</pre>
<pre>
CREATE TABLE user_item (
	user_item_no INT AUTO_INCREMENT,
    user_no INT(5) NOT NULL,
    item_id INT(5) NOT NULL,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (user_item_no)
);
</pre><br>

<h3>자료실 테이블과 파일 첨부 테이블</h3>
<pre>
CREATE TABLE pds (
	item_id INT(5) AUTO_INCREMENT,
    item_name VARCHAR(20),
    view_cnt INT(6) DEFAULT 0,
    description VARCHAR(50),
    PRIMARY KEY (item_id)
);
</pre>
<pre>
CREATE TABLE pds_attach (
	fullName VARCHAR(150) NOT NULL,
    item_id INT(5) NOT NULL,
    down_cnt INT(6) DEFAULT 0,
    regdate TIMESTAMP DEFAULT now(),
    PRIMARY KEY(fullName)
);
</pre><br>

<h3>충전 내역 및 지급 내역 테이블</h3>
<pre>
CREATE TABLE charge_coiN_history (
	history_no INT AUTO_INCREMENT,
    user_no INT(5) NOT NULL,
    amount INT(5) NOT NULL,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (history_no)
);
</pre>
<pre>
CREATE TABLE pay_coin_history (
	history_no INT AUTO_INCREMENT,
    user_no INT(5) NOT NULL,
    item_id INT(5) NOT NULL,
    amount INT(5) NOT NULL,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (history_no)
);
</pre><br>

<h3>로그인 로그, 접근 로그, 서비스 로그 테이블</h3>
<pre>
CREATE TABLE login_log (
	log_no INT NOT NULL AUTO_INCREMENT,
    user_no INT(5) NOT NULL,
    user_id VARCHAR(50) NOT NULL,
    remote_addr VARCHAR(50) NOT NULL,
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY(log_no)
);
</pre>
<pre>
CREATE TABLE access_log (
	log_no INT NOT NULL AUTO_INCREMENT,
    request_uri VARCHAR(200) NOT NULL,
    class_name VARCHAR(100) NOT NULL,
    class_simple_name VARCHAR(50) NOT NULL,
    method_name VARCHAR(100) NOT NULL,
    remote_addr VARCHAR(50) NOT NULL,
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (log_no)
);
</pre>
<pre>
CREATE TABLE performance_log (
	log_no INT NOT NULL AUTO_INCREMENT,
    signature_name VARCHAR(50) NOT NULL,
    signature_type_name VARCHAR(100) NOT NULL,
    duration_time INT DEFAULT 0,
    reg_date TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (log_no)
);
</pre><br><br>

<h2> 데이터베이스 접근 설정 </h2>
<h3>스프링 jdbc 의존 등록</h3>
<pre>
&lt;dependency&gt;
	&lt;groupId&gt;org.springframework&lt;/groupId&gt;
	&lt;artifactId&gt;spring-jdbc&lt;/artifactId&gt;
	&lt;version&gt;${org.springframework-version}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.springframework&lt;/groupId&gt;
	&lt;artifactId&gt;spring-tx&lt;/artifactId&gt;
	&lt;version&gt;${org.springframework-version}&lt;/version&gt;
&lt;/dependency&gt;
</pre><br>

<h3>커넥션 풀 설정을 위한 HikariCP 의존등록. 자세한 설명은 <a href="https://kimvampa.tistory.com/57">링크</a>를 참조</h3>
<pre>
&lt;dependency&gt;
	&lt;groupId&gt;com.zaxxer&lt;/groupId&gt;
	&lt;artifactId&gt;HikariCP&lt;/artifactId&gt;
	&lt;version&gt;2.7.4&lt;/version&gt;
&lt;/dependency&gt;
</pre><br>

<h3> 데이터베이스 쿼리를 위한 Mybatis와 Mysql 의존 등록</h3>
<pre>
&lt;dependency&gt;
	&lt;groupId&gt;org.mybatis&lt;/groupId&gt;
	&lt;artifactId&gt;mybatis&lt;/artifactId&gt;
	&lt;version&gt;3.4.6&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;org.mybatis&lt;/groupId&gt;
	&lt;artifactId&gt;mybatis-spring&lt;/artifactId&gt;
	&lt;version&gt;1.3.2&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
	&lt;groupId&gt;mysql&lt;/groupId&gt;
	&lt;artifactId&gt;mysql-connector-java&lt;/artifactId&gt;
	&lt;version&gt;5.1.35&lt;/version&gt;
&lt;/dependency&gt;
</pre><br>

<h3>root-context.xml에서 데이터 소스의 빈 설정</h3>
<pre>
&lt;bean id=&quot;hikariConfig&quot; class=&quot;com.zaxxer.hikari.HikariConfig&quot;&gt;
	&lt;property name=&quot;driverClassName&quot; value=&quot;com.mysql.jdbc.Driver&quot; /&gt;
	&lt;property name=&quot;jdbcUrl&quot; value=&quot;jdbc:mysql://127.0.0.1:3307/hdspring19&quot; /&gt;
	&lt;property name=&quot;username&quot; value=&quot;${ID}&quot; /&gt;
	&lt;property name=&quot;password&quot; value=&quot;${PASSWORD}&quot; /&gt;
&lt;/bean&gt;
&lt;bean id=&quot;dataSource&quot; class=&quot;com.zaxxer.hikari.HikariDataSource&quot; destroy-method=&quot;close&quot;&gt;
	&lt;constructor-arg ref=&quot;hikariConfig&quot; /&gt;
&lt;/bean&gt;
</pre>
<p> hikariCP를 사용한 데이터 소스의 빈을 정의한다. </p><br>
<pre>
&lt;bean id=&quot;sqlSessionFactory&quot; class=&quot;org.mybatis.spring.SqlSessionFactoryBean&quot;&gt;
	&lt;property name=&quot;dataSource&quot; ref=&quot;dataSource&quot; /&gt;
	&lt;property name=&quot;configLocation&quot; value=&quot;classpath:/mybatis-config.xml&quot; /&gt;
&lt;/bean&gt;
&lt;bean id=&quot;sqlSession&quot; class=&quot;org.mybatis.spring.SqlSessionTemplate&quot; destroy-method=&quot;clearCache&quot;&gt;
	&lt;constructor-arg name=&quot;sqlSessionFactory&quot; ref=&quot;sqlSessionFactory&quot; /&gt;
&lt;/bean&gt;
&lt;bean id=&quot;transactionManager&quot; class=&quot;org.springframework.jdbc.datasource.DataSourceTransactionManager&quot;&gt;
	&lt;property name=&quot;dataSource&quot; ref=&quot;dataSourc &quot;/&gt;
&lt;/bean&gt;
</pre>
<p>sqlSessionFactoryBean, sqlSessionTemplate, TransactionManager 빈을 각각 정의한다. </p><br>
<pre>
&lt;tx:annotation-driven/&gt;
</pre>
<p>어노테이션 기반의 트랜잭션 제어를 활성화한다.</p><br>

<h3>mybatis-config.xml 설정</h3>
<pre>
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;!DOCTYPE configuration PUBLIC &quot;-//mybatis.org/DTD Config 3.0//EN&quot;
&quot;http://mybatis.org/dtd/mybatis-3-config.dtd&quot;&gt;
&lt;configuration&gt;&lt;/configuration&gt;
</pre>
<p>위 설정으로, Mybatis를 이용한 데이터베이스와 스프링 간 연동이 가능해진다.</p>