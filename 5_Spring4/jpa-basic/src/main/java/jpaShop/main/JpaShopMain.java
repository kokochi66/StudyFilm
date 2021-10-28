package jpaShop.main;

import helloJpa.chap7.Chap7_Book;
import helloJpa.chap7.Chap7_Item;
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
            Album album = new Album();
            album.setArtist("wotamin");
            album.setEtc("new album");
            entityManager.persist(album);

            Book book = new Book();
            book.setAuthor("hayake");
            book.setIsbn("new book");
            entityManager.persist(book);

            Movie movie = new Movie();
            movie.setActor("yoshino");
            movie.setDirector("oba");
            entityManager.persist(movie);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }

}
