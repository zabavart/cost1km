package entity;

import javax.persistence.*;

@Entity
@Table(name = "cost")
public class Cost {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_cost", nullable = false, unique = true)
  private Integer idCost;

  @Column(name = "car_price")
  private Integer carPrice;

  @Column(name = "miles_on")
  private Integer milesOn;

  @Column(name = "benzine")
  private Integer benzine;

  @Column(name = "other_expenses")
  private Integer otherExpenses;

  @Column(name = "selling_price")
  private Integer sellingPrice;

  public Cost() {
  }

  public Integer getCarPrice() {
    return carPrice;
  }

  public void setCarPrice(Integer carPrice) {
    this.carPrice = carPrice;
  }

  public Integer getMilesOn() {
    return milesOn;
  }

  public void setMilesOn(Integer milesOn) {
    this.milesOn = milesOn;
  }

  public Integer getBenzine() {
    return benzine;
  }

  public void setBenzine(Integer benzine) {
    this.benzine = benzine;
  }

  public Integer getOtherExpenses() {
    return otherExpenses;
  }

  public void setOtherExpenses(Integer other_expenses) {
    this.otherExpenses = other_expenses;
  }

  public Integer getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Integer sellingPrice) {
    this.sellingPrice = sellingPrice;
  }
}

