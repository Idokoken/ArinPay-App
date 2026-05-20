package ndgroups.ArinPay.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ndgroups.ArinPay.Enum.ACCOUNT_TYPE;
import ndgroups.ArinPay.model.User;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private String accountNumber;
        private double balance;
//    private BigDecimal balance = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    private ACCOUNT_TYPE accountType;
    private User user;


    public AccountDto(Long id, String accountHolderName, String accountNumber,
                      double balance, ACCOUNT_TYPE accountType) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
}
