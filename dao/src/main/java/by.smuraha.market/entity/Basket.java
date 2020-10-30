package by.smuraha.market.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Basket extends BaseEntity{
    @Column(name = "order_id")
    private Long orderID;

    @Column(name = "product_id")
    private Long productID;

    @Column(name = "count")
    private int count;
}
