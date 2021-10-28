package jpaShop.main;

import helloJpa.chap7.Chap7_Book;
import helloJpa.chap7.Chap7_Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.awt.print.Book;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Chap7_Book book = new Chap7_Book();
            book.setName("future");
            book.setAuthor("kokochi");
            book.setIsbn("isbn");
            entityManager.persist(book);

            entityManager.flush();
            entityManager.clear();

            Chap7_Item item = entityManager.find(Chap7_Item.class, book.getId());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }

}
