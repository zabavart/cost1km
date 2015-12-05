package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "car_model")
@NamedQueries({
        @NamedQuery(name = "CarModel.getAll",
                    query = "select c from CarModel c"),
        @NamedQuery(name = "CarModel.getAllByCarMarkId",
                    query = "select c from CarModel c where id_car_mark = :id_car_mark "),
})

public class CarModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_car_model", nullable = false, unique = true)
  private Integer idCarModel;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "id_car_mark", nullable = false)
  private CarMark carMark;

  @Column(name = "name", length = 255)
  private String name;

  public CarModel(String name) {
    this.name = name;
  }

  public CarModel() {
  }

  public Integer getIdCarModel() {
    return idCarModel;
  }

  public void setIdCarModel(Integer idCarModel) {
    this.idCarModel = idCarModel;
  }

  public CarMark getCarMark() {
    return carMark;
  }

  public void setCarMark(CarMark carMark) {
    this.carMark = carMark;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
