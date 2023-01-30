# 스프링 데이터 JPA 구현체 분석

## SimpleJpaRepository 클래스 분석

Spring Data Jpa에서 사용되는 쿼리들이 실제로 어떻게 동작하는지에 대해서 상세 구현 내용들을 볼 수 있다.

- @Transactional(readOnly = true) : 기본적으로 readOnly true로 두고있다. 나머지 save, delete등에서만 readOnly를 false로 따로 걸어주고 있다.
- 기본적으로 @Transactional이 다 걸려있기 때문에, 트랜잭션을 따로 안걸어도 Spring Data JPA가 정상적으로 동작하게 된다.
- readOnly가 기본으로 걸려져 있으면, 플러시를 생략하도록 되어있어서 약간의 성능향상을 얻음
- **save() 메소드는 새로운 엔티티면 persist, 새로운 엔티티가 아니면 merge()가 실행되도록 되어있음** 


## Spring Data JPA가 새로운 엔티티를 어떻게 구분하는가? (쿼리를 또 날리나?)

- 식별자가 객체면 Null로 판단 (GeneratedValue는 값이 생성될 때 적용되기 때문에, 새로운 객체면 Null값이 들어가게 되어있음)
- 식별자가 자바 기본타입이면 0으로 판단 (long의 기본타입은 0)
- 식별자를 String같은걸로 쓸 때 (직접 생성되는게 아닐 때) : select 쿼리가 먼저 나가서 있는지 확인하고, insert가 들어간다.
    - Persistable를 구현해야한다. (Id값을 리턴, 조건에 따라 new인지를 정의해주어야 함. => 정의가 까다로울 때가 많음)
    - 이럴 때, createdDate를 디폴트로 만들어놓고, 체크하도록 할 수 있다.

## JPA Specifications (명세)

- Spring Data JPA는 JPA Criteria를 활용해서 개념을 사용하도록 지원 (별로 안좋음, 실무에서 쓰기가 힘듬, 너무 복잡함)


