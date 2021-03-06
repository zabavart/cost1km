package crud;

import org.json.simple.JSONObject;

import entity.CarMark;
import entity.CarModel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CarModelService {
  private EntityManager em;

  public CarModelService(EntityManager em) {
    this.em = em;
  }

  public CarModel add(CarModel carModel) {
    em.getTransaction().begin();
    CarModel carModelFromDB = em.merge(carModel);
    em.getTransaction().commit();
    return carModelFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public CarModel get(long id) {
    return em.find(CarModel.class, id);
  }

  public void update(CarModel carModel) {
    em.getTransaction().begin();
    em.merge(carModel);
    em.getTransaction().commit();
  }

  public JSONObject getAll() {
    Query namedQuery = em.createNamedQuery("CarModel.getAll");
    List<CarModel> carModelist = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (CarModel carModel : carModelist) {
      jsonObject.put(carModel.getIdCarModel(), carModel.getName());
    }
    return jsonObject;
  }

  public List<CarModel> getByCarMarkId(int carMarkId) {
    Query namedQuery = em.createNamedQuery("CarModel.getByCarMarkId").setParameter("id_car_mark", carMarkId);
    return namedQuery.getResultList();
  }
}