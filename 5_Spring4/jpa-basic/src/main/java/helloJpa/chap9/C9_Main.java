package helloJpa.chap9;

import helloJpa.chap8.Chap8_Member;
import helloJpa.chap8.Chap8_Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class C9_Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            C9_Member member = new C9_Member();
            member.setUsername("hello");
            member.setAddress(new C9_Address());
            member.setPeriod(new C9_Period());
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
