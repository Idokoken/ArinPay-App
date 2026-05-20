package ndgroups.ArinPay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ndgroups.ArinPay.Enum.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TRANSACTION_TYPE type;
    private String reference;
    private LocalDateTime transactionDate;
    @ManyToOne
    private Account senderAccount;
    @ManyToOne
    private Account receiverAccount;
    private String description;
}
