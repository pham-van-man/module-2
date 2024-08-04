package case_study.model;

import case_study.repository.Repository;
import case_study.repository.RepositoryAccount;
import case_study.ulti.DataHandler;
import case_study.ulti.Handler;
import case_study.ulti.HistoryHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Transfer {
    public boolean isAccountNumber(Account account, String accountNumber) {
        Repository<Account> repository = new RepositoryAccount();
        List<Account> accounts = repository.findAll(new DataHandler());
        for (Account ac : accounts) {
            if (ac.getAccountNumber().equals(accountNumber) && !account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

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
        History.writer(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": - " + amount + " VND") + "|\n", new HistoryHandler());
        History.writer(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": - " + (amountSend - amount) + " VND") + "|\n", new HistoryHandler());
        Repository<Account> repository = new RepositoryAccount();
        List<Account> accounts = repository.findAll(new DataHandler());
        for (Account ac : accounts) {
            if (ac.getAccountNumber().equals(account.getAccountNumber())) {
                ac.setBalance(ac.getBalance() - amountSend);
                break;
            }
        }
        for (Account ac : accounts) {
            if (ac.getAccountNumber().equals(accountNumber)) {
                ac.setBalance(ac.getBalance() + amountReceive);
                History.writer(ac, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": + " + amountReceive + " VND") + "|\n", new HistoryHandler());
                break;
            }
        }
        Handler dataHandler = new DataHandler();
        dataHandler.writerObject(accounts, "src/case_study/data/account.ser");
    }
}



