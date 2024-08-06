package case_study.repository;

import case_study.model.Account;

import java.util.Map;

public interface RepositoryAccount {
    Map<Account, String> findAll();

    Account findByAccount(String nameAccount, String password);

    void register(Account newAccount);

    boolean checkNameAccount(String nameAccount);

    boolean checkNumberAccount(String numberAccount);

    void recharge(Account account, double amount);

    void changePassword(Account account, String newPassword);

    void changeEmail(Account account, String newEmail);

    void changePhoneNumber(Account account, String newPhoneNumber);

    void writerHistory(Account account, String history);

    String readHistory(Account account);

    boolean isAccountNumber(Account account, String accountNumber);

    boolean isAmount(Account account, double amount);

    void transfer(Account account, String accountNumber, double amount);

    void registerVIP(Account account);

    boolean isVIP(Account account);
}
