package crud;

import org.json.simple.JSONObject;

import entity.CarMark;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CarMarkService {
  private EntityManager em;

  public CarMarkService(EntityManager em) {
    this.em = em;
  }

  public CarMark add(CarMark carMark) {
    em.getTransaction().begin();
    CarMark carMarkFromDB = em.merge(carMark);
    em.getTransaction().commit();
    return carMarkFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public CarMark get(long id) {
    return em.find(CarMark.class, id);
  }

  public void update(CarMark carMark) {
    em.getTransaction().begin();
    em.merge(carMark);
    em.getTransaction().commit();
  }

  public JSONObject getAll() {
    Query namedQuery = em.createNamedQuery("CarMark.getAll");
    List<CarMark> carMarkList = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (CarMark carMark : carMarkList) {
      jsonObject.put(carMark.getIdCarMark(), carMark.getName());
    }
    return jsonObject;
  }
}