package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "car_serie")
@NamedQueries({
        @NamedQuery(name = "CarSerie.get",
                    query = "select c from CarSerie c"),
        @NamedQuery(name = "CarSerie.getByCarModelId",
                    query = "select c from CarSerie c where id_car_model = :id_car_model"),
})

public class CarSerie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_car_serie", nullable = false, unique = true)
  private Integer idCarSerie;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "id_car_model", nullable = false)
  private CarModel carModel;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "id_car_generation")
  private Integer idCarGeneration;

  public CarSerie(String name) {
    this.name = name;
  }

  public CarSerie() {
  }

  public Integer getIdCarSerie() {
    return idCarSerie;
  }

  public void setIdCarSerie(Integer idCarSerie) {
    this.idCarSerie = idCarSerie;
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

  public Integer getIdCarGeneration() {
    return idCarGeneration;
  }

  public void setIdCarGeneration(Integer idCarGeneration) {
    this.idCarGeneration = idCarGeneration;
  }
}
