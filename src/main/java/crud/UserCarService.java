package crud;

import entity.User;
import entity.UserCar;

import javax.persistence.EntityManager;

public class UserCarService {
  private EntityManager em;

  public UserCarService(EntityManager em) {
    this.em = em;
  }

  public UserCar merge(UserCar userCar) {
    em.getTransaction().begin();
    UserCar userCarFromDB = em.merge(userCar);
    em.getTransaction().commit();
    return userCarFromDB;
  }

  public void delete(Integer id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public UserCar get(Integer id) {
    return em.find(UserCar.class, id);
  }

  public void update(UserCar userCar) {
    em.getTransaction().begin();
    em.merge(userCar);
    em.getTransaction().commit();
  }
}