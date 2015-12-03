package crud;

import entity.Author;

import javax.persistence.EntityManager;

public class AuthorService {
  private EntityManager em;

  public AuthorService(EntityManager em) {
    this.em = em;
  }

  public Author merge(Author author) {
    em.getTransaction().begin();
    Author authorFromDB = em.merge(author);
    em.getTransaction().commit();
    return authorFromDB;
  }

  public void delete(Integer id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Author get(Integer id) {
    return em.find(Author.class, id);
  }

  public void update(Author author) {
    em.getTransaction().begin();
    em.merge(author);
    em.getTransaction().commit();
  }
}