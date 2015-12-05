package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "car_modification")
@NamedQueries({
        @NamedQuery(name = "CarModification.getAll",
                    query = "select c from CarModification c"),
        @NamedQuery(name = "CarModification.getAllByCarSerieId",
                    query = "select c from CarModification c where id_car_serie = :id_car_serie"),
})

public class CarModification {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_car_modification", nullable = false, unique = true)
  private Integer idCarModification;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "id_car_serie", nullable = false)
  private CarSerie carSerie;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "id_car_model", nullable = false)
  private CarModel carModel;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "start_production_year")
  private Integer startProductionYear;

  @Column(name = "end_production_year")
  private Integer end_productionYear;

  public CarModification(String name) {
    this.name = name;
  }

  public CarModification() {
  }

  public Integer getIdCarModification() {
    return idCarModification;
  }

  public void setIdCarModification(Integer idCarModification) {
    this.idCarModification = idCarModification;
  }

  public CarSerie getCarSerie() {
    return carSerie;
  }

  public void setCarSerie(CarSerie carSerie) {
    this.carSerie = carSerie;
  }

  public CarModel getCarModel() {
    return carModel;
  }

  public void setCarModel(CarModel carModel) {
    this.carModel = carModel;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStartProductionYear() {
    return startProductionYear;
  }

  public void setStartProductionYear(Integer startProductionYear) {
    this.startProductionYear = startProductionYear;
  }

  public Integer getEnd_productionYear() {
    return end_productionYear;
  }

  public void setEnd_productionYear(Integer end_productionYear) {
    this.end_productionYear = end_productionYear;
  }
}
