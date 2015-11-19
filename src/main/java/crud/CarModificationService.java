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

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public CarModification get(long id) {
    return em.find(CarModification.class, id);
  }

  public void update(CarModification carModification) {
    em.getTransaction().begin();
    em.merge(carModification);
    em.getTransaction().commit();
  }

  public JSONObject getAll() {
    Query namedQuery = em.createNamedQuery("CarModification.getAll");
    List<CarModification> carModificationist = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (CarModification carModification : carModificationist) {
      jsonObject.put(carModification.getIdCarModification(), carModification.getName());
    }
    return jsonObject;
  }

  public JSONObject getAllByCarSerieId(int carSerieId) {
    Query namedQuery = em.createNamedQuery("CarModification.getAllByCarSerieId").setParameter("id_car_serie", carSerieId);
    List<CarModification> carModificationList = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (CarModification carModification : carModificationList) {
        jsonObject.put(carModification.getIdCarModification(), carModification.getName());
    }
    return jsonObject;
  }
}