package helloJpa.chap10;

import helloJpa.chap9.C9_Address;
import helloJpa.chap9.C9_Member;
import jpaShop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class C10_Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);
            Root<Member> from = query.from(Member.class);
            CriteriaQuery<Member> cq = query.select(from).where(cb.equal(from.get("name"), "kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();
            // 쿼리문에서 오타가 내도 알아볼 수 있고, 쿼리문에 신경을 쓰지 않아도 된다.
            // SQL스럽지 않고, 직관성이 떨어져 유지보수가 어렵다. 사용하지 않는것이 좋다. (너무 복잡하고 실용성이 없음)



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
