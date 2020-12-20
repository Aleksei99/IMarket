package by.smuraha.market.entity;

import by.smuraha.market.myAnotations.Unique;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity{

    @Column
    @Size(min = 3, max = 16, message = "errors.user.name")
    private String name;

    @Column
    @Size(min = 3, max = 24, message = "errors.user.surname")
    private String surname;

    @Column(unique = true)
    @Unique(message = "errors.user.unique")
    private String username;

    @Column
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$",
            message = "errors.user.password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    ContactInformation contactInformation;

    public User(@Size(min = 3, max = 16, message = "errors.user.name") String name,
                @Size(min = 3, max = 24, message = "errors.user.surname") String surname,
                @Unique(message = "errors.user.unique") String username,
                @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "errors.user.password") String password,
                Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
    @JsonIgnore
    private Set<Product> products;
}
