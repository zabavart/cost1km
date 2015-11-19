package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "car_serie")
@NamedQueries({
        @NamedQuery(name = "CarSerie.getAll",
                    query = "select c from CarSerie c"),
        @NamedQuery(name = "CarSerie.getAllByCarModelId",
                    query = "select c from CarSerie c where id_car_model = :id_car_model"),
})

public class CarSerie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_car_serie", nullable = false, unique = true)
  private Integer idCarSerie;

  @Column(name = "id_car_model")
  private Integer idCarModel;

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

  public Integer getIdCarModel() {
    return idCarModel;
  }

  public void setIdCarModel(Integer idCarModel) {
    this.idCarModel = idCarModel;
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
