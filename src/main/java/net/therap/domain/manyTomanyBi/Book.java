package net.therap.domain.manyTomanyBi;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "book_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_generator", sequenceName = "book_sequence", allocationSize = 1)
    private long id;

    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "table_author_book",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    //@OrderColumn(name = "idx")
    private List<Author> authorList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        List<String> authors = new ArrayList<>();
        if (this.getAuthorList() != null) {
            for (Author author : this.getAuthorList()) {
                authors.add(author.getName());
            }
        }
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors name='" + authors + '\'' +
                '}';
    }
}
