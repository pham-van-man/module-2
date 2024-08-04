package case_study.service;

import case_study.model.Account;
import case_study.repository.Repository;
import case_study.ulti.Handler;

import java.util.List;

public interface Service<E> {
    List<E> finAll(Repository<Account> repository, Handler dataHandler);

    E findByAccount(Repository<Account> repository, Handler dataHandler, String nameAccount, String password);

    void register(Repository<Account> repository, Handler dataHandler, E element);

    boolean checkNameAccount(Repository<Account> repository, Handler dataHandler, String nameAccount);

    boolean checkNumberAccount(Repository<Account> repository, Handler dataHandler, String numberAccount);

    void recharge(Repository<Account> repository, Handler dataHandler, Account account, double amount);
}
