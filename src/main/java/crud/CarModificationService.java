package crud;

import entity.CarModification;
import org.json.simple.JSONObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CarModificationService {
  private EntityManager em;

  public CarModificationService(EntityManager em) {
    this.em = em;
  }

  public CarModification add(CarModification carModification) {
    em.getTransaction().begin();
    CarModification carModificationFromDB = em.merge(carModification);
    em.getTransaction().commit();
    return carModificationFromDB;
  }

  public void delete(int id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public CarModification get(int id) {
    return em.find(CarModification.class, id);
  }

  public void update(CarModification carModification) {
    em.getTransaction().begin();
    em.merge(carModification);
    em.getTransaction().commit();
  }

  public List<CarModification> getByCarSerieId(int carSerieId) {
    Query namedQuery = em.createNamedQuery("CarModification.getByCarSerieId").setParameter("id_car_serie", carSerieId);
    return namedQuery.getResultList();
  }
}