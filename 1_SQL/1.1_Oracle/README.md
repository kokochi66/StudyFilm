<h1> SQL - Oracle </h1>
<p>
    이 markdown 파일은 유튜브 오라클 기초강좌 https://www.youtube.com/watch?v=k7Btzj3aZms&list=PLxU-iZCqT52Dlz0zGgFiq1mBz21arFUHS&index=1 를 기반으로 구성되었습니다.
</p>
<ol>
    <li> <a href="#1">ROWNUM 이란?</a></li>
    <li> <a href="#2">ROWID 란?</a></li>
    <li> <a href="#3">스칼라 서브쿼리</a></li>
</ol>
<br><br>
<h2 id="1"> ROWNUM이란 </h2>
<p>
    <strong>ROWNUM은 SELECT절에 의해 추출되는 데이터에 붙는 순번이다.</strong> 이는 의사칼럼으로 참조만 될 뿐 데이터베이스에는 저장되지 않으며, 순서상으로  WHERE절까지 만족시킨 결과에 ROWNUM이 붙으며, <strong>ORDER BY는 맨 마지막에 실행된다.</strong>
</p>
<img src="https://user-images.githubusercontent.com/61536109/123037606-e1161300-d429-11eb-8571-b961e02697a6.png" width="200px"></img>
<p> 예제를 위해서 위 테이블을 사용한다. (student 테이블)</p>
<pre>
        SELECT ROWNUM, user_id, password FROM student where ROWNUM < 5;
</pre>
<img src="https://user-images.githubusercontent.com/61536109/123038418-5504eb00-d42b-11eb-9b4e-db03a9cbb676.png" width="200px"></img>
<p>
    ROWNUM < 5 조건을 주면, ROWNUM이 5보다 작은 테이블까지만 쿼리의 결과로 나오게 된다.
</p>
<pre>
        SELECT ROWNUM, user_id, password FROM student where ROWNUM > 5;
</pre>
<img src="https://user-images.githubusercontent.com/61536109/123038421-56361800-d42b-11eb-9326-b479ae56d140.png" width="200px"></img>
<p>
    ROWNUM > 5 조건을 주면, WHERE절을 조사하는 중에 ROWNUM이 계속해서 적용이 되기 때문에, 첫번째 자리 값이 계속해서 ROWNUM = 1 이 들어가게 되고, 모든 조건에서 ROWNUM > 5 인 조건이 만족되지 않아, 결과값이 아무것도 나오지 않는다.
</p>
<pre>
        SELECT ROWNUM, user_id, password FROM student where ROWNUM < 5 ORDER BY PASSWORD DESC;
</pre>
<img src="https://user-images.githubusercontent.com/61536109/123038423-56ceae80-d42b-11eb-922f-278007b7f54a.png" width="200px"></img>
<p>
    WHERE에서 ROWNUM 검사를 마치고 나서, ORDER BY를 적용하게 되면, 맨 마지막에 정렬이 이루어지기 때문에, ROWNUM은 자신의 역할을 하지 못하고 같이 정렬  순서에 따라 흩어지게 된다.
</p>
<br><br>
<h2 id="2"> ROWID 란? </h2>
<br><br>
<h2 id="3"> 스칼라 서브쿼리 </h2>