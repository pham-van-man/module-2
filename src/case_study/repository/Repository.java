package case_study.repository;

import case_study.model.Account;
import case_study.ulti.Handler;

import java.util.List;

public interface Repository<E> {
    List<E> findAll(Handler dataHandler);

    E findByAccount(Handler dataHandler, String nameAccount, String password);

    void register(Handler dataHandler, E element);

    boolean checkNameAccount(Handler dataHandler, String nameAccount);

    boolean checkNumberAccount(Handler dataHandler, String numberAccount);

    void recharge(Handler dataHandler, Account account, double amount);
}
