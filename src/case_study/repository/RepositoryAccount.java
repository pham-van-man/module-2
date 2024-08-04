package case_study.repository;

import case_study.model.Account;
import case_study.ulti.Handler;

import java.util.List;

public class RepositoryAccount implements Repository<Account> {
    private static final String PATH = "src/case_study/data/account.ser";

    @Override
    public List<Account> findAll(Handler dataHandler) {
        return dataHandler.readerObject(PATH);
    }

    @Override
    public Account findByAccount(Handler dataHandler, String nameAccount, String password) {
        List<Account> listAccount = findAll(dataHandler);
        for (Account account : listAccount) {
            if (account.getNameAccount().equals(nameAccount) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void register(Handler dataHandler, Account account) {
        List<Account> listAccount = findAll(dataHandler);
        listAccount.add(account);
        dataHandler.writerObject(listAccount, PATH);
    }

    @Override
    public boolean checkNameAccount(Handler dataHandler, String nameAccount) {
        List<Account> listAccount = findAll(dataHandler);
        for (Account account : listAccount) {
            if (account.getNameAccount().equals(nameAccount)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkNumberAccount(Handler dataHandler, String numberAccount) {
        List<Account> listAccount = findAll(dataHandler);
        for (Account account : listAccount) {
            if (account.getAccountNumber().equals(numberAccount)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void recharge(Handler dataHandler, Account account, double amount) {
        List<Account> listAccount = findAll(dataHandler);
        for (Account ac : listAccount) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setBalance(amount);
            }
        }
        dataHandler.writerObject(listAccount, PATH);
    }
}
