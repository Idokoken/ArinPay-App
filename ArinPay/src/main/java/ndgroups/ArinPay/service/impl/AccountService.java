package ndgroups.ArinPay.service.impl;

import ndgroups.ArinPay.Enum.ACCOUNT_TYPE;
import ndgroups.ArinPay.dto.AccountDto;
import ndgroups.ArinPay.mapper.AccountMapper;
import ndgroups.ArinPay.model.Account;
import ndgroups.ArinPay.repository.AccountRepository;
import ndgroups.ArinPay.service.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public Account getAccountById(Long id) throws Exception {
        Optional<Account>account = accountRepository.findById(id);
        if(account.isEmpty()){
            throw new Exception("no account found with the given :" + id);
        }
        return account.get();
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) throws Exception {
        Optional<Account>account = accountRepository.findByAccountNumber(accountNumber);
        if(account.isEmpty()){
            throw new Exception("no account found with the given account number " + accountNumber);
        }
        return account.get();
    }

    @Override
    public List<Account> getAccountByUserNames(String name) {
        return accountRepository.findByAccountHolderName(name);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountsByAccountType(ACCOUNT_TYPE type) {
        return accountRepository.findByAccountType(type);
    }

    @Override
    public void closeAccount(Long id) throws Exception {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }

    @Override
    public AccountDto depositMoney(Long id, double amount) throws Exception {
        Account account = getAccountById(id);
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withDrawMoney(Long id, double amount) throws Exception {
        Account account = getAccountById(id);
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient Fund");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
