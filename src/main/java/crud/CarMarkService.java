package crud;

import entity.CarMark;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CarMarkService {

  public EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();

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

  public List<CarMark> getAll() {
    Query namedQuery = em.createNamedQuery("CarMark.getAll");
    return namedQuery.getResultList();
  }
}