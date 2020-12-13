package by.smuraha.market.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;


    public Product(String brand, String name, BigDecimal price, Subcategory subcategory, User user, String description) {
        this.brand=brand;
        this.name=name;
        this.price=price;
        this.subcategory=subcategory;
        this.seller=user;
        this.description=description;
    }
}
