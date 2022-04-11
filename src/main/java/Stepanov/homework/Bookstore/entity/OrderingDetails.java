package Stepanov.homework.Bookstore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderingDetails {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    private Ordering ordering;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "book_id", referencedColumnName = "id"),
            @JoinColumn(name = "price", referencedColumnName = "price")
    })
    private Book book;

    @Column
    private Integer quantity;

}
