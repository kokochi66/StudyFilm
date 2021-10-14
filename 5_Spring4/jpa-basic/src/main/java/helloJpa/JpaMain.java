package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            /*
            // 영속성 테스트
            Member member = new Member();
            member.setId(100L);
            member.setName("kokochi");
            // 비영속 상태 - DB와 관계가 없는 상태임.
            System.out.println("TEST :: Before :: EntityManager에서 persist하기 이전 상태임");
            em.persist(member);
            System.out.println("TEST :: After :: EntityManager에서 persist한 이후 상태임");
            // entityManager에 등록하여 영속상태가 된다고 해서 바로 쿼리문이 실행되는것이 아님.
            */
            /*
            // 동일성보장
            Member member1 = em.find(Member.class, 150L);
            Member member2 = em.find(Member.class, 150L);
            System.out.println("TEST :: 쿼리문에서 가져온 두 객체를 비교 :: " + (member1 == member2));
            // JPA는 최초 쿼리를 실행한 객체를 1차 캐시에 저장하여, 비교하므로, 동일한 객체를 참조하게 되어,
            // 여러번 쿼리를 실행하여도 해당 객체는 동일한 객체임을 보장해준다.
            */
            /*
            // DB의 객체를 자바의 컬렉션처럼 다룰 수 있음.
            Member member1 = em.find(Member.class, 150L);
            member1.setName("kokochikochikorchi");
            // update문이나 persist를 별도로 실행하지 않고, 객체의 값만 바꿔주어도 1차 캐시에 저장되어있는 객체는 DB로 쿼리문이 작성된다.
            // 이 쿼리문은 commit할때에 지연 SQL 저장소에 저장되었다가 한번에 송신되므로, 최적화에 도움을 준다.
            */
            /*
            // 영속성 컨텍스트로 플러쉬하기
            Member member = new Member();
            member.setId(111L);
            member.setName("Ganyu");
            em.persist(member);
            // 영속성 컨텍스트에 담겼을 뿐, 실제 DB에 쿼리는 날라가지 않는다.
            em.flush();
            // em.flush()를 실행해주면 바로 쿼리문이 날라가게 된다.
            System.out.println("TEST :: 쿼리문이 날라간 이후에 보여지는 로그");
            */
            // 준영속상태 만들기
            Member member = new Member();
            member.setId(112L);
            member.setName("Hutao");
            em.persist(member);  // 영속상태를 한번 만들어준 뒤에, 영속상태를 푸는데에는 두가지 방법이 존재함.
            em.detach(member);   // 해당하는 객체를 영속상태에서 제거해줌. 이 경우에 1차캐시에서 제외됨.
            em.clear();         // 영속성 컨텍스트를 완전히 비워서 모든 값들을 지워줌
            System.out.println("영속성 상태로 일단 만들어도, commit 이전에 준영속상태를 만들었기 때문에 쿼리가 실행되지 않음.");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
