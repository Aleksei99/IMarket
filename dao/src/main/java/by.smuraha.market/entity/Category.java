package by.smuraha.market.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "category",fetch = FetchType.EAGER)
    private List<Subcategory> subcategory;

    public Category(String name) {
        this.name = name;
    }
}
