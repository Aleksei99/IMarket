package by.smuraha.market.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_information")
public class ContactInformation extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "telephone", unique = true, nullable = false)
    private String telephone;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "house", column = @Column(name = "home_house")),
            @AttributeOverride(name = "number", column = @Column(name = "home_number"))
    })
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "other_city")),
            @AttributeOverride(name = "street", column = @Column(name = "other_street")),
            @AttributeOverride(name = "house", column = @Column(name = "other_house")),
            @AttributeOverride(name = "number", column = @Column(name = "other_number"))
    })
    private Address otherAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "another_address")
    private Boolean anotherAddress=false;

}
