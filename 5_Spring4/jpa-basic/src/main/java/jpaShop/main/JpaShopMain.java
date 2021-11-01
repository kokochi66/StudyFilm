package jpaShop.main;

import helloJpa.chap7.Chap7_Book;
import helloJpa.chap7.Chap7_Item;
import helloJpa.chap9.C9_Address;
import helloJpa.chap9.C9_Member;
import helloJpa.chap9.C9_Period;
import jpaShop.domain.Album;
import jpaShop.domain.Book;
import jpaShop.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaShopMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {


            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }

}
