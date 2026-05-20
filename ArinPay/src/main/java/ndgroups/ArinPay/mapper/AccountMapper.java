package ndgroups.ArinPay.mapper;

import ndgroups.ArinPay.dto.AccountDto;
import ndgroups.ArinPay.model.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getUser().getId(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountNumber(),
                accountDto.getBalance(),
                accountDto.getAccountType()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getUser().getId(),
                account.getAccountHolderName(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getAccountType()
        );

        return accountDto;
    }

}
