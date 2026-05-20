//package ndgroups.ArinPay.service;
//
//import ndgroups.ArinPay.model.Account;
//import ndgroups.ArinPay.Enum.TRANSACTION_TYPE;
//import ndgroups.ArinPay.model.Transaction;
//import ndgroups.ArinPay.repository.AccountRepository;
//import ndgroups.ArinPay.repository.TransactionRepository;
//import ndgroups.ArinPay.request.TransferRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//public class BankingService {
//    @Autowired
//    private AccountRepository accountRepository;
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//
//    public String transfer(TransferRequest request) {
//
//        Account sender = accountRepository
//                .findByAccountNumber(request.getSenderAccountNumber())
//                .orElseThrow(() ->
//                        new RuntimeException("Sender account not found"));
//
//        Account receiver = accountRepository
//                .findByAccountNumber(request.getReceiverAccountNumber())
//                .orElseThrow(() ->
//                        new RuntimeException("Receiver account not found"));
//
//        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
//            throw new RuntimeException("Insufficient balance");
//        }
//
//        sender.setBalance(
//                sender.getBalance().subtract(request.getAmount())
//        );
//        receiver.setBalance(
//                receiver.getBalance().add(request.getAmount())
//        );
//
//        accountRepository.save(sender);
//        accountRepository.save(receiver);
//
//        Transaction transaction = new Transaction();
//
//        transaction.setAmount(request.getAmount());
//        transaction.setType(TRANSACTION_TYPE.TRANSFER);
//        transaction.setTransactionDate(LocalDateTime.now());
//        transaction.setSenderAccount(sender);
//        transaction.setReceiverAccount(receiver);
//        transaction.setDescription(request.getDescription());
////        transaction.setReference(UUID.randomUUID().toString());
//
//        transactionRepository.save(transaction);
//        return "Transfer successful";
//    }
//
//}
