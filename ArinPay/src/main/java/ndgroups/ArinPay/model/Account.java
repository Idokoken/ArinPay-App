package ndgroups.ArinPay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ndgroups.ArinPay.Enum.ACCOUNT_TYPE;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    @Column(unique = true)
    private String accountNumber;
    private double balance;
//    private BigDecimal balance = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    private ACCOUNT_TYPE accountType;
    @ManyToOne
    private User user;

    public Account(Long id, String accountHolderName, String accountNumber, double balance,
                   ACCOUNT_TYPE accountType) {
    }
}
