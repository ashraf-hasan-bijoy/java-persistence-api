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
@Table(name = "table_author")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "author_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "author_generator", sequenceName = "author_sequence", allocationSize = 1)
    private long id;

    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        List<String> books = new ArrayList<>();
        if (this.getBookList() != null) {
            for (Book author : this.getBookList()) {
                books.add(author.getName());
            }
        }
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books='" + books + '\'' +
                '}';
    }
}
