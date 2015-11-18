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
  private int idCarModel;

  @Column(name = "id_car_mark")
  private int idCarMark;

  @Column(name = "name", length = 255)
  private String name;

  public CarModel(String name) {
    this.name = name;
  }

  public CarModel() {
  }

  public int getIdCarModel() {
    return idCarModel;
  }

  public void setIdCarModel(int idCarModel) {
    this.idCarModel = idCarModel;
  }

  public int getIdCarMark() {
    return idCarMark;
  }

  public void setIdCarMark(int idCarMark) {
    this.idCarMark = idCarMark;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
