package ndgroups.ArinPay.controller;

import ndgroups.ArinPay.Enum.ACCOUNT_TYPE;
import ndgroups.ArinPay.dto.AccountDto;
import ndgroups.ArinPay.model.Account;
import ndgroups.ArinPay.response.MessageResponse;
import ndgroups.ArinPay.service.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDto>createAccount(@RequestBody AccountDto accountDto){
        AccountDto account = accountService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account>getAccountById(@PathVariable Long id) throws Exception {
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<Account>getAccountByAccountNumber(@RequestParam String accountNumber) throws Exception {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Account>>getAccountsByAccountName(@RequestParam String name) {
        List<Account> accounts = accountService.getAccountByUserNames(name);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Account>>getAccountsByAccountTypes(@RequestParam ACCOUNT_TYPE type) {
        List<Account> accounts = accountService.getAccountsByAccountType(type);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>>getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/close/{id}")
    public ResponseEntity<MessageResponse>closeAccount(@PathVariable Long id) throws Exception {
        accountService.closeAccount(id);
        MessageResponse response = new MessageResponse();
        response.setMessage("Account Successfully deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto>depositMoneyToAccount(@PathVariable Long id,
                                                                @RequestBody  Map<String, Double> request)
            throws Exception {
        AccountDto account = accountService.depositMoney(id, request.get("amount"));
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto>withDrawMoneyFromAccount(@PathVariable Long id,
                                                           Map<String, Double> request)
            throws Exception {
        AccountDto account = accountService.withDrawMoney(id, request.get("amount"));
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


}
