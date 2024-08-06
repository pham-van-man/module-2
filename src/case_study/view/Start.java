package case_study.view;

import case_study.controller.ControllerAccount;
import case_study.controller.ControllerVIPAccount;
import case_study.ulti.ValidateInputValue;

import java.time.LocalDate;

public class Start {
    public static void main(String[] args) {
        showMenuTheme();
    }

    public static void showMenuTheme() {
        ControllerAccount account = new ControllerAccount();
        ControllerVIPAccount vipAccount = new ControllerVIPAccount();
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                     HideTrade                    |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Đăng Nhập                                     |");
            System.out.println("| 2. Tạo Tài Khoản Mới                             |");
            System.out.println("| 3. Đăng Nhập Tài Khoản VIP                       |");
            System.out.println("| 4. Thoát                                         |");
            System.out.println("+--------------------------------------------------+");
            int option = ValidateInputValue.getIntInput("Nhập lựa chọn của bạn:");
            switch (option) {
                case 1:
                    login(account);
                    break;
                case 2:
                    register(account);
                    break;
                case 3:
                    login(vipAccount);
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void register(ControllerAccount controller) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                      Đăng Ký                     |");
        System.out.println("+--------------------------------------------------+");
        String firstName = ValidateInputValue.getStringInput("Tên: ");
        String lastName = ValidateInputValue.getStringInput("Họ: ");
        LocalDate birthDate = ValidateInputValue.getDateInput("Ngày sinh (YYYY-MM-DD): ");
        String gender = ValidateInputValue.getGender("Giới tính: ");
        String email = ValidateInputValue.getEmailInput("Email: ");
        String phoneNumber = ValidateInputValue.getPhoneNumberInput("Số điện thoại: ");
        String citizenIdentification = ValidateInputValue.getCitizenIdentification("CMND/CCCD: ");
        String address = ValidateInputValue.getStringInput("Địa chỉ: ");
        String nameAccount = ValidateInputValue.getNameAccount("Tên tài khoản: ");
        String password = ValidateInputValue.getPassword("Mật khẩu: ");
        String accountNumber = ValidateInputValue.getAccountNumber("Số tài khoản: ");
        controller.register(firstName, lastName, birthDate, gender, email, phoneNumber, citizenIdentification, address, nameAccount, password, accountNumber);
    }

    public static void login(ControllerAccount controller) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                     Đăng Nhập                    |");
        System.out.println("+--------------------------------------------------+");
        String nameAccount = ValidateInputValue.getNameAccountOrPassword("Nhập tên tài khoản:");
        String password = ValidateInputValue.getNameAccountOrPassword("Nhập mật khẩu:");
        controller.login(nameAccount, password);
    }
}
