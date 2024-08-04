package case_study.service;

import case_study.model.Account;
import case_study.repository.Repository;
import case_study.ulti.Handler;

import java.util.List;

public class ServiceAccount implements Service<Account> {
    @Override
    public List<Account> finAll(Repository<Account> repository, Handler dataHandler) {
        return repository.findAll(dataHandler);
    }

    @Override
    public Account findByAccount(Repository<Account> repository, Handler dataHandler, String nameAccount, String password) {
        return repository.findByAccount(dataHandler, nameAccount, password);
    }

    @Override
    public void register(Repository<Account> repository, Handler dataHandler, Account account) {
        repository.register(dataHandler, account);
    }

    @Override
    public boolean checkNameAccount(Repository<Account> repository, Handler dataHandler, String nameAccount) {
        return repository.checkNameAccount(dataHandler, nameAccount);
    }

    @Override
    public boolean checkNumberAccount(Repository<Account> repository, Handler dataHandler, String numberAccount) {
        return repository.checkNumberAccount(dataHandler, numberAccount);
    }

    @Override
    public void recharge(Repository<Account> repository, Handler dataHandler, Account account, double amount) {
        repository.recharge(dataHandler, account, amount);
    }
}
