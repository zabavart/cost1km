package entity;


    import java.util.Set;

    import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

  @Id
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String lastName;

  public Author() {
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
  private Set<Book> books;

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }
}