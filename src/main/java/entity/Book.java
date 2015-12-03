package entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  Integer id;

  @Column(name = "name")
  private String name;

  public Book() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}