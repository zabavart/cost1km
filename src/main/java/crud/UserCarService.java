package crud;

import entity.Cost;
import entity.User;
import entity.UserCar;
import org.json.simple.JSONObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

  public JSONObject get() {
    Query namedQuery = em.createNamedQuery("Cost.get");
    List<Cost> costList = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (Cost cost : costList) {
      System.out.println("!!! " + cost.getBenzine() + " " + cost.getId());
//      jsonObject.put(carModel.getIdCarModel(), carModel.getName());
    }
    return jsonObject;
  }

  public void update(UserCar userCar) {
    em.getTransaction().begin();
    em.merge(userCar);
    em.getTransaction().commit();
  }
}