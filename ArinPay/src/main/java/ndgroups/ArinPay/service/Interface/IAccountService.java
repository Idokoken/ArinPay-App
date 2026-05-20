package ndgroups.ArinPay.service.Interface;

import ndgroups.ArinPay.Enum.ACCOUNT_TYPE;
import ndgroups.ArinPay.dto.AccountDto;
import ndgroups.ArinPay.model.Account;

import java.util.List;

public interface IAccountService {
    public AccountDto createAccount(AccountDto accountDto);
    public Account getAccountById(Long id) throws Exception;
    public Account getAccountByAccountNumber(String accountNumber) throws Exception;
    public List<Account> getAccountByUserNames(String name);
    public List<Account>getAllAccounts();
    public List<Account>getAccountsByAccountType(ACCOUNT_TYPE type);
    public void closeAccount(Long id) throws Exception;
    public AccountDto depositMoney(Long id, double amount) throws Exception;
    public AccountDto withDrawMoney(Long id, double amount) throws Exception;
}
