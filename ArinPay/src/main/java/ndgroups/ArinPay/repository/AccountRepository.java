package ndgroups.ArinPay.repository;

import ndgroups.ArinPay.Enum.ACCOUNT_TYPE;
import ndgroups.ArinPay.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByAccountType(ACCOUNT_TYPE type);
    List<Account> findByAccountHolderName(String name);
}
