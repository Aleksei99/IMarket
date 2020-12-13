package by.smuraha.market.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Basket extends BaseEntity{
    @Column(name = "order_id")
    private Long orderID;

    @Column(name = "product_id")
    private Long productID;

    @Column(name = "count")
    private int count;

    public Basket(Long orderID, Long productID, int count) {
        this.orderID = orderID;
        this.productID = productID;
        this.count = count;
    }
}
