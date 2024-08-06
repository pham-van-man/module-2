package case_study.service;

import case_study.model.Account;
import case_study.repository.RepositoryAccount;
import case_study.repository.RepositoryAccountImpl;

public class ServiceAccountImpl implements ServiceAccount {
    protected RepositoryAccount repositoryAccount;

    public ServiceAccountImpl() {
        this.repositoryAccount = new RepositoryAccountImpl();
    }

    @Override
    public Account findByAccount(String nameAccount, String password) {
        return repositoryAccount.findByAccount(nameAccount, password);
    }

    @Override
    public void register(Account account) {
        repositoryAccount.register(account);
    }

    @Override
    public boolean checkNameAccount(String nameAccount) {
        return repositoryAccount.checkNameAccount(nameAccount);
    }

    @Override
    public boolean checkNumberAccount(String numberAccount) {
        return repositoryAccount.checkNumberAccount(numberAccount);
    }

    @Override
    public void recharge(Account account, double amount) {
        repositoryAccount.recharge(account, amount);
    }

    @Override
    public void changePassword(Account account, String newPassword) {
        repositoryAccount.changePassword(account, newPassword);
    }

    @Override
    public void changeEmail(Account account, String newEmail) {
        repositoryAccount.changeEmail(account, newEmail);
    }

    @Override
    public void changePhoneNumber(Account account, String newPhoneNumber) {
        repositoryAccount.changePhoneNumber(account, newPhoneNumber);
    }

    @Override
    public void writerHistory(Account account, String history) {
        repositoryAccount.writerHistory(account, history);
    }

    @Override
    public String readHistory(Account account) {
        return repositoryAccount.readHistory(account);
    }

    @Override
    public boolean isAccountNumber(Account account, String accountNumber) {
        return repositoryAccount.isAccountNumber(account, accountNumber);
    }

    @Override
    public boolean isAmount(Account account, double amount) {
        return repositoryAccount.isAmount(account, amount);
    }

    @Override
    public void transfer(Account account, String accountNumber, double amount) {
        repositoryAccount.transfer(account, accountNumber, amount);
    }

    @Override
    public void registerVIP(Account account) {
        repositoryAccount.registerVIP(account);
    }

    @Override
    public boolean isVIP(Account account) {
        return repositoryAccount.isVIP(account);
    }
}
