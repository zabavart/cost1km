package entity;

import javax.persistence.*;

@Entity
@Table(name = "cost")
@NamedQuery(name = "Calculation.getByCalculation", query = "select c from Cost c where calculation_id = :calculation_id")
public class Cost {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "calculation_id", nullable = false)
  private Calculation calculation;

  @Column(name = "price")
  private Integer price;

  @Column(name = "selling_price")
  private Integer sellingPrice;

  @Column(name = "miles_on")
  private Integer milesOn;

  @Column(name = "benzine")
  private Integer benzine;

  @Column(name = "repairs")
  private Integer repairs;

  @Column(name = "service")
  private Integer service;

  @Column(name = "credit")
  private Integer credit;

  @Column(name = "kasko")
  private Integer kasko;

  @Column(name = "osago")
  private Integer osago;

  @Column(name = "tax")
  private Integer tax;

  @Column(name = "penalty")
  private Integer penalty;

  @Column(name = "parking")
  private Integer parking;

  @Column(name = "other_expenses")
  private Integer otherExpenses;

  public Cost() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Calculation getCalculation() {
    return calculation;
  }

  public void setCalculation(Calculation calculation) {
    this.calculation = calculation;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Integer sellingPrice) {
    this.sellingPrice = sellingPrice;
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

  public Integer getRepairs() {
    return repairs;
  }

  public void setRepairs(Integer repairs) {
    this.repairs = repairs;
  }

  public Integer getService() {
    return service;
  }

  public void setService(Integer service) {
    this.service = service;
  }

  public Integer getCredit() {
    return credit;
  }

  public void setCredit(Integer credit) {
    this.credit = credit;
  }

  public Integer getKasko() {
    return kasko;
  }

  public void setKasko(Integer kasko) {
    this.kasko = kasko;
  }

  public Integer getOsago() {
    return osago;
  }

  public void setOsago(Integer osago) {
    this.osago = osago;
  }

  public Integer getTax() {
    return tax;
  }

  public void setTax(Integer tax) {
    this.tax = tax;
  }

  public Integer getPenalty() {
    return penalty;
  }

  public void setPenalty(Integer penalty) {
    this.penalty = penalty;
  }

  public Integer getParking() {
    return parking;
  }

  public void setParking(Integer parking) {
    this.parking = parking;
  }

  public Integer getOtherExpenses() {
    return otherExpenses;
  }

  public void setOtherExpenses(Integer otherExpenses) {
    this.otherExpenses = otherExpenses;
  }
}

