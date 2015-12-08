package entity;

import javax.persistence.*;

@Entity
@Table(name = "period")
public class Period {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "calculation_id", nullable = false)
  private Calculation calculation;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "type_period_id", nullable = false)
  private TypePeriod typePeriod;

  public Period() {
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

  public TypePeriod getTypePeriod() {
    return typePeriod;
  }

  public void setTypePeriod(TypePeriod typePeriod) {
    this.typePeriod = typePeriod;
  }
}