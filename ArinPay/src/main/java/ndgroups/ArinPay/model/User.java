package ndgroups.ArinPay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ndgroups.ArinPay.Enum.USER_ROLE;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean verified;
    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;
//    @JsonIgnore
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Account account;

}
