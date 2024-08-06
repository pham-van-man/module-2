package case_study.repository;

import case_study.model.Account;

public class RepositoryVIPAccountImpl extends RepositoryAccountImpl {

    public RepositoryVIPAccountImpl() {
        PATH = "src/case_study/data/data_vip.ser";
    }

    @Override
    public boolean isAmount(Account account, double amount) {
        if (amount >= 50000000) {
            return account.getBalance() - amount * 1.15 >= -500000;
        } else if (amount >= 40000000) {
            return account.getBalance() - amount * 1.12 >= -500000;
        } else if (amount >= 20000000) {
            return account.getBalance() - amount * 1.1 >= -500000;
        } else {
            return account.getBalance() - amount * 1.05 >= -500000;
        }
    }
}
