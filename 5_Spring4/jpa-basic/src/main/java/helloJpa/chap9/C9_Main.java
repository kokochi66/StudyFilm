package helloJpa.chap9;

import helloJpa.chap8.Chap8_Member;
import helloJpa.chap8.Chap8_Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class C9_Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            /*C9_Member member = new C9_Member();
            member.setUsername("hello");
            member.setAddress(new C9_Address());
            member.setPeriod(new C9_Period());
            em.persist(member);*/

            C9_Member member = new C9_Member();
            member.setUsername("kokochi");
            member.setAddress(new C9_Address("서울", "대치동", "구로구"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new C9_Address("a", "a", "a"));
            member.getAddressHistory().add(new C9_Address("b", "b", "b"));
            member.getAddressHistory().add(new C9_Address("c", "c", "c"));
            em.persist(member);
            em.flush();
            em.clear();

            System.out.println("TEST :: START =================================");
            C9_Member findMember = em.find(C9_Member.class, member.getId());        // 지연로딩으로인해 쿼리문이 한번만 나감
            List<C9_Address> addressHistory = findMember.getAddressHistory();
            for (C9_Address c9_address : addressHistory) {
                System.out.println("TEST :: findMemberAddress = " + c9_address);
            }   // 해당하는값이 필요하게 되는 경우에, 쿼리를 실행하게됨

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("TEST :: favoriteFood = " + favoriteFood);
            }   // Set 컬렉션도 마찬가지임.

//            findMember.getAddress().setCity("부산");  // 값타입의 경우 이렇게 변경하면 안된다
            C9_Address address = findMember.getAddress();
            address.setCity("부산");
//            findMember.setAddress(new C9_Address("부산" , address.getStreet(), address.getZipcode()));
            // 값타입의 경우, 해당 인스턴스 자체를 새것으로 갈아끼워야한다.

            findMember.getAddressHistory().remove(new C9_Address("a", "a", "a"));
            // eqauls를 지정해야면 값을 비교하여 제거해준다.
            // 제거하는 경우, 기존의 모든 컬렉션값을 제거하고, 남아있는 값을 insert 하는 과정을 거친다.
//            findMember.getAddressHistory().add(new C9_Address("d", "d", "d"));



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
