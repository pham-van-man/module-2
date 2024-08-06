package case_study.controller;

import case_study.model.Account;
import case_study.service.ServiceVIPAccountImpl;
import case_study.ulti.ValidateInputValue;

public class ControllerVIPAccount extends ControllerAccount {
    public ControllerVIPAccount() {
        serviceAccount = new ServiceVIPAccountImpl();
    }

    @Override
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
            System.out.println("| Loại: " + String.format("%-43s", "Tài Khoản VIP") + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Đổi Email                                     |");
            System.out.println("| 2. Đổi số điện thoại                             |");
            System.out.println("| 3. Đổi mật khẩu                                  |");
            System.out.println("| 4. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("Nhập lựa chọn: ");
            switch (choice) {
                case 1:
                    changeEmail(account);
                    break;
                case 2:
                    changePhoneNumber(account);
                    break;
                case 3:
                    changePassword(account);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    @Override
    public void transfer(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|" + String.format("%50s", account.getLastName() + " " + account.getFirstName()) + "|");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| Số Tài khoản: " + String.format("%-35s", account.getAccountNumber()) + "|");
        System.out.println("| Số dư: " + String.format("%-42s", "$" + String.format("%.2f", account.getBalance())) + "|");
        System.out.println("+--------------------------------------------------+");
        String accountNumber = ValidateInputValue.getStringInput("Nhập Số Tài Khoản: ");
        if (serviceAccount.isAccountNumber(account, accountNumber)) {
            double amount = ValidateInputValue.getAmount("Nhập số tiền: ");
            if (serviceAccount.isAmount(account, amount)) {
                serviceAccount.transfer(account, accountNumber, amount);
                System.out.println("+--------------------------------------------------+");
                System.out.println("|              Giao Dịch Thành Công                |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("Nhập lựa chọn:");
                    if (choice == 1) {
                        return;
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
            } else {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|               Giao Dịch Thất Bại                 |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| Notify: Số tiền giao dịch vượt hạn mức đăng kí.  |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("Nhập lựa chọn:");
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
