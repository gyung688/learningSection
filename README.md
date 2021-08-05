# lhgboard
스프링 MVC 게시판

> Language : JAVA JDK 1.8
> Framework : Spring 4.3.8, mybatis
> Server : Apache Tomcat 8.0
> IDE : Eclipse
> Database : MySQL

주요 기능
> 로그인 - 중복기능, BCryptPasswordEncoder
> 회원가입 - 주소API 
> 게시판 - 파일 업로드, 페이징, 검색

입사한지 일주일. 로그인, 회원가입, 게시판을 만들었다.

새로 알게된 점
- RedirectAttributes를 쓰면 보안에 안좋다.
- BCryptPasswordEncoder는 보안이 안좋다.
- _lf, _uf와 같은 파일 명명법은 20년 전에나 쓰던 방식이다.
- @Repository 쓰면 SqlSession 안 써도 된다.
- ON DUPLICATE KEY UPDATE는 쓸 때 편하지만 DBA가 안좋아한다.

이전 회사에서 일할땐 만들기에만 급급해, 내가 쓰는 기능들을 제대로 인지하지 않고 넘어갔던 것이 문제가 됐다.
이번 기회에 하나하나 알아가며 나의 부족함을 느꼈고 공부의 심각성을 깨달았다.
그래도 전에 비하면 이제 어떤 것을 공부해야하는지 점차 좁혀져가는 느낌이다.
