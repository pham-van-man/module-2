package case_study.controller;

import case_study.model.Account;
import case_study.model.History;
import case_study.model.Transfer;
import case_study.repository.RepositoryAccount;
import case_study.service.Service;
import case_study.service.ServiceAccount;
import case_study.ulti.DataHandler;
import case_study.ulti.HistoryHandler;
import case_study.ulti.Validate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    public void login(Service<Account> service, String nameAccount, String password) {
        Account account = service.findByAccount(new RepositoryAccount(), new DataHandler(), nameAccount, password);
        if (account == null) {
            while (true) {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|        Thông Tin Đăng Nhập Không Chính Xác       |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                int choice = Validate.getIntInput("Nhập lựa chọn:");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } else {
            showMainMenu(account);
        }
    }

    public void register(Service<Account> service, String firstName, String lastName, LocalDate birthDate, String gender, String email, String phoneNumber, String citizenIdentification, String address, String nameAccount, String password, String accountNumber) {
        Account newAccount = new Account(firstName, lastName, birthDate, gender, email, phoneNumber, citizenIdentification, address, nameAccount, password, accountNumber);
        service.register(new RepositoryAccount(), new DataHandler(), newAccount);
        History.writer(newAccount, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": Khởi Tạo Tài Khoản") + "|\n", new HistoryHandler());
        showMainMenu(newAccount);
    }

    public void showMainMenu(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|" + String.format("%50s", account.getLastName() + " " + account.getFirstName()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Số Tài khoản: " + String.format("%-35s", account.getAccountNumber()) + "|");
            System.out.println("| Số dư: " + String.format("%-42s", String.format("%.2f", account.getBalance()) + " VND") + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Xem thông tin chi tiết                        |");
            System.out.println("| 2. Nạp tiền                                      |");
            System.out.println("| 3. Chuyển Tiền                                   |");
            System.out.println("| 4. Lịch sử giao dịch                             |");
            System.out.println("| 5. Đăng xuất                                     |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn:");
            switch (choice) {
                case 1:
                    showDetailedInfo(account);
                    break;
                case 2:
                    recharge(account);
                    break;
                case 3:
                    transfer(account);
                    break;
                case 4:
                    showHistory(account);
                    break;
                case 5:
                    logout();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void showHistory(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Lịch Sử Giao Dịch                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print(History.read(account, new HistoryHandler()));
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn:");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void transfer(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|" + String.format("%50s", account.getLastName() + " " + account.getFirstName()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Số Tài khoản: " + String.format("%-35s", account.getAccountNumber()) + "|");
            System.out.println("| Số dư: " + String.format("%-42s", "$" + String.format("%.2f", account.getBalance())) + "|");
            System.out.println("+--------------------------------------------------+");
            String accountNumber = Validate.getStringInput("Nhập Số Tài Khoản: ");
            Transfer transfer = new Transfer();
            if (transfer.isAccountNumber(account, accountNumber)) {
                double amount = Validate.getAmount("Nhập số tiền: ");
                if (transfer.isAmount(account, amount)) {
                    transfer.transfer(account, accountNumber, amount);
                    while (true) {
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("|              Giao Dịch Thành Công                |");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("| 1. Trở về                                        |");
                        System.out.println("+--------------------------------------------------+");
                        int choice = Validate.getIntInput("Nhập lựa chọn:");
                        if (choice == 1) {
                            return;
                        } else {
                            System.out.println("Lựa chọn không hợp lệ.");
                        }
                    }
                } else {
                    while (true) {
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("|               Giao Dịch Thất Bại                 |");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("| Notify: Số dư không đủ để thực hiện giáo dịch. Số|");
                        System.out.println("| dư tài khoản phải trên 50000 VND để trả phí duy  |");
                        System.out.println("| trì                                              |");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("| 1. Trở về                                        |");
                        System.out.println("+--------------------------------------------------+");
                        int choice = Validate.getIntInput("Nhập lựa chọn:");
                        if (choice == 1) {
                            return;
                        } else {
                            System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }
                }
            } else {
                System.out.println("Số tài khoản không hợp lê!");
            }
        }
    }

    public void logout() {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|              Đăng Xuất Thành Công                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn:");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void recharge(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                  Chọn Nhà Mạng                   |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Vietell                                       |");
            System.out.println("| 2. Mobiphone                                     |");
            System.out.println("| 3. Vinaphone                                     |");
            System.out.println("| 4. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn:");
            switch (choice) {
                case 1:
                    choiceCardValue(account, 0.97);
                    return;
                case 2:
                    choiceCardValue(account, 0.90);
                    return;
                case 3:
                    choiceCardValue(account, 0.85);
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void choiceCardValue(Account account, double rate) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Chọn Mệnh Giá Thẻ Nạp              |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. 10,000 VND                                    |");
            System.out.println("| 2. 20,000 VND                                    |");
            System.out.println("| 3. 50,000 VND                                    |");
            System.out.println("| 4. 100,000 VND                                   |");
            System.out.println("| 5. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn:");
            switch (choice) {
                case 1:
                    isCard(new ServiceAccount(), account, 10000 * rate);
                    return;
                case 2:
                    isCard(new ServiceAccount(), account, 20000 * rate);
                    return;
                case 3:
                    isCard(new ServiceAccount(), account, 50000 * rate);
                    return;
                case 4:
                    isCard(new ServiceAccount(), account, 100000 * rate);
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void isCard(Service<Account> service, Account account, double amount) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|" + String.format("%50s", "Nạp Thẻ " + amount) + "|");
        System.out.println("+--------------------------------------------------+");
        Validate.getSeriCard("Nhập số seri: ");
        Validate.getCodeCard("Nhập mã thẻ: ");
        account.setBalance(account.getBalance() + amount);
        service.recharge(new RepositoryAccount(), new DataHandler(), account, account.getBalance());
        History.writer(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": + " + amount + " VND") + "|\n", new HistoryHandler());
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                 Nạp Thẻ Thành Công               |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn: ");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }


    public void showDetailedInfo(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                 Thông Tin Cá Nhân                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Tên: " + String.format("%-44s", account.getLastName() + " " + account.getFirstName()) + "|");
            System.out.println("| Ngày sinh: " + String.format("%-38s", account.getBirthDate()) + "|");
            System.out.println("| Giới tính: " + String.format("%-38s", account.getGender()) + "|");
            System.out.println("| Email: " + String.format("%-42s", account.getEmail()) + "|");
            System.out.println("| Số điện thoại: " + String.format("%-34s", account.getPhoneNumber()) + "|");
            System.out.println("| CMND/CCCD: " + String.format("%-38s", account.getCitizenIdentification()) + "|");
            System.out.println("| Địa chỉ: " + String.format("%-40s", account.getAddress()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = Validate.getIntInput("Nhập lựa chọn: ");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
