package crud;

import entity.Book;

import javax.persistence.EntityManager;

public class BookService {
  private EntityManager em;

  public BookService(EntityManager em) {
    this.em = em;
  }

  public Book merge(Book book) {
    em.getTransaction().begin();
    Book bookFromDB = em.merge(book);
    em.getTransaction().commit();
    return bookFromDB;
  }

  public void delete(Integer id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Book get(Integer id) {
    return em.find(Book.class, id);
  }

  public void update(Book book) {
    em.getTransaction().begin();
    em.merge(book);
    em.getTransaction().commit();
  }
}