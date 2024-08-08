package case_study.repository;

import case_study.model.Account;
import case_study.ulti.DataHandler;
import case_study.ulti.DataHandlerImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RepositoryAccountImpl implements RepositoryAccount {
    protected String path;
    private final DataHandler DATAHANDLER;

    public RepositoryAccountImpl() {
        path = "src/case_study/data/data.ser";
        DATAHANDLER = new DataHandlerImpl();
    }

    @Override
    public Map<Account, String> findAll() {
        return DATAHANDLER.readerObject(path);
    }

    @Override
    public Account findByAccount(String nameAccount, String password) {
        Map<Account, String> listAccount = findAll();
        for (Account account : listAccount.keySet()) {
            if (account.getNameAccount().equals(nameAccount) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void register(Account account) {
        Map<Account, String> listAccount = findAll();
        listAccount.put(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": Khởi Tạo Tài Khoản") + "|\n");
        DATAHANDLER.writerObject(listAccount, path);
    }

    @Override
    public boolean checkNameAccount(String nameAccount) {
        Map<Account, String> listAccount = findAll();
        for (Account account : listAccount.keySet()) {
            if (account.getNameAccount().equals(nameAccount)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkNumberAccount(String numberAccount) {
        Map<Account, String> listAccount = findAll();
        for (Account account : listAccount.keySet()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void recharge(Account account, double amount) {
        Map<Account, String> listAccount = findAll();
        for (Account ac : listAccount.keySet()) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setBalance(ac.getBalance() + amount);
                ac.setTotalRecharge(ac.getTotalRecharge() + amount);
                break;
            }
        }
        DATAHANDLER.writerObject(listAccount, path);
    }

    @Override
    public void changePassword(Account account, String newPassword) {
        Map<Account, String> listAccount = findAll();
        for (Account ac : listAccount.keySet()) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setPassword(newPassword);
                break;
            }
        }
        DATAHANDLER.writerObject(listAccount, path);
    }

    @Override
    public void changeEmail(Account account, String newEmail) {
        Map<Account, String> listAccount = findAll();
        for (Account ac : listAccount.keySet()) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setEmail(newEmail);
                break;
            }
        }
        DATAHANDLER.writerObject(listAccount, path);
    }

    @Override
    public void changePhoneNumber(Account account, String newPhoneNumber) {
        Map<Account, String> listAccount = findAll();
        for (Account ac : listAccount.keySet()) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setPhoneNumber(newPhoneNumber);
                break;
            }
        }
        DATAHANDLER.writerObject(listAccount, path);
    }

    @Override
    public void writerHistory(Account account, String history) {
        Map<Account, String> listHistory = findAll();
        listHistory.put(account, history + listHistory.get(account));
        DATAHANDLER.writerObject(listHistory, path);
    }

    @Override
    public String readHistory(Account account) {
        Map<Account, String> listHistory = findAll();
        return listHistory.get(account);
    }

    @Override
    public boolean isAccountNumber(Account account, String accountNumber) {
        Map<Account, String> accounts = findAll();
        for (Account ac : accounts.keySet()) {
            if (ac.getAccountNumber().equals(accountNumber) && !account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAmount(Account account, double amount) {
        if (amount >= 50000000) {
            return account.getBalance() - amount * 1.15 >= 50000;
        } else if (amount >= 40000000) {
            return account.getBalance() - amount * 1.12 >= 50000;
        } else if (amount >= 20000000) {
            return account.getBalance() - amount * 1.1 >= 50000;
        } else {
            return account.getBalance() - amount * 1.05 >= 50000;
        }
    }

    @Override
    public void transfer(Account account, String accountNumber, double amount) {
        double amountSend, amountReceive;
        if (amount >= 50000000) {
            amountSend = amount * 1.15;
            amountReceive = amount * 0.85;
        } else if (amount >= 40000000) {
            amountSend = amount * 1.12;
            amountReceive = amount * 0.88;
        } else if (amount >= 20000000) {
            amountSend = amount * 1.1;
            amountReceive = amount * 0.90;
        } else {
            amountSend = amount * 1.05;
            amountReceive = amount * 0.95;
        }
        account.setBalance(account.getBalance() - amountSend);
        writerHistory(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": - " + amount + " VND") + "|\n");
        writerHistory(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": - " + (amountSend - amount) + " VND") + "|\n");
        Map<Account, String> accounts = findAll();
        for (Account ac : accounts.keySet()) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setBalance(ac.getBalance() - amountSend);
                break;
            }
        }
        for (Account ac : accounts.keySet()) {
            if (ac.getAccountNumber().equals(accountNumber)) {
                ac.setBalance(ac.getBalance() + amountReceive);
                accounts.put(ac, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": + " + amountReceive + " VND") + "|\n" + accounts.get(ac));
                break;
            }
        }
        DATAHANDLER.writerObject(accounts, path);
    }

    @Override
    public void registerVIP(Account account) {
        String PATH = "src/case_study/data/data_vip.ser";
        Map<Account, String> listVIPAccount = DATAHANDLER.readerObject(PATH);
        listVIPAccount.put(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": Khởi Tạo Tài Khoản VIP") + "|\n");
        DATAHANDLER.writerObject(listVIPAccount, PATH);
    }

    @Override
    public boolean isVIP(Account account) {
        String PATH = "src/case_study/data/data_vip.ser";
        Map<Account, String> listVIPAccount = DATAHANDLER.readerObject(PATH);
        return listVIPAccount.containsKey(account);
    }
}
