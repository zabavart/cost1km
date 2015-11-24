package crud;

import javax.persistence.EntityManager;

import entity.User;

public class UserService {
  private EntityManager em;

  public UserService(EntityManager em) {
    this.em = em;
  }

  public User add(User user) {
    em.getTransaction().begin();
    User userFromDB = em.merge(user);
    em.getTransaction().commit();
    return userFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public User get(long id) {
    return em.find(User.class, id);
  }

  public void update(User user) {
    em.getTransaction().begin();
    em.merge(user);
    em.getTransaction().commit();
  }
}