package crud;

import entity.CarSerie;
import org.json.simple.JSONObject;
import utils.Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CarSerieService {
  private EntityManager em;

  public CarSerieService(EntityManager em) {
    this.em = em;
  }

  public CarSerie add(CarSerie carSerie) {
    em.getTransaction().begin();
    CarSerie carSerieFromDB = em.merge(carSerie);
    em.getTransaction().commit();
    return carSerieFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public CarSerie get(long id) {
    return em.find(CarSerie.class, id);
  }

  public void update(CarSerie carSerie) {
    em.getTransaction().begin();
    em.merge(carSerie);
    em.getTransaction().commit();
  }

  public JSONObject getAll() {
    Query namedQuery = em.createNamedQuery("CarSerie.getAll");
    List<CarSerie> carSerieist = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (CarSerie carSerie : carSerieist) {
      jsonObject.put(carSerie.getIdCarSerie(), carSerie.getName());
    }
    return jsonObject;
  }

  public JSONObject getAllByCarModelId(int carModelId) {
    Query namedQuery = em.createNamedQuery("CarSerie.getAllByCarModelId").setParameter("id_car_model", carModelId);
    List<CarSerie> carSerieList = namedQuery.getResultList();
    JSONObject jsonObject = new JSONObject();
    for (CarSerie carSerie : carSerieList) {
        jsonObject.put(carSerie.getIdCarSerie(), carSerie.getName());
    }
    return jsonObject;
  }
}