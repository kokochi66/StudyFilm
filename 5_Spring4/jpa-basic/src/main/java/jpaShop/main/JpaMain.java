package jpaShop.main;

import jpaShop.domain.Member;
import jpaShop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.changeTeam(team);
            entityManager.persist(member);

//            entityManager.flush();
//            entityManager.clear();

            Team team1 = entityManager.find(Team.class, team.getId());
            List<Member> members = team1.getMembers();
            for (Member member1 : members) {
                System.out.println("TEST :: members :: " + member1.getId()+" " + member1.getName());
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }

}
