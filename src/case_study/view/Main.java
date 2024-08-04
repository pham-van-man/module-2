package case_study.view;

import case_study.controller.Controller;
import case_study.service.ServiceAccount;
import case_study.ulti.Validate;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        showMenuTheme();
    }

    public static void showMenuTheme() {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                    Ví Điện Tử                    |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Đăng Nhập                                     |");
            System.out.println("| 2. Tạo Tài Khoản Mới                             |");
            System.out.println("| 3. Thoát                                         |");
            System.out.println("+--------------------------------------------------+");
            int option = Validate.getIntInput("Nhập lựa chọn của bạn:");
            switch (option) {
                case 1:
                    login(new Controller());
                    break;
                case 2:
                    register(new Controller());
                    break;
                case 3:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void register(Controller controller) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                      Đăng Ký                     |");
        System.out.println("+--------------------------------------------------+");
        String firstName = Validate.getStringInput("Nhập tên: ");
        String lastName = Validate.getStringInput("Nhập họ: ");
        LocalDate birthDate = Validate.getDateInput("Nhập ngày sinh (YYYY-MM-DD): ");
        String gender = Validate.getStringInput("Nhập giới tính: ");
        String email = Validate.getEmailInput("Nhập email: ");
        String phoneNumber = Validate.getPhoneNumberInput("Nhập số điện thoại: ");
        String citizenIdentification = Validate.getCitizenIdentification("Nhập CMND/CCCD: ");
        String address = Validate.getStringInput("Nhập địa chỉ: ");
        String nameAccount = Validate.getNameAccount("Nhập tên tài khoản: ");
        String password = Validate.getPassword("Nhập mật khẩu: ");
        String accountNumber = Validate.getAccountNumber("Nhập số tài khoản: ");
        controller.register(new ServiceAccount(), firstName, lastName, birthDate, gender, email, phoneNumber, citizenIdentification, address, nameAccount, password, accountNumber);
    }

    public static void login(Controller controller) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                     Đăng Nhập                    |");
        System.out.println("+--------------------------------------------------+");
        String nameAccount = Validate.getNameAccountOrPassword("Nhập tên tài khoản:");
        String password = Validate.getNameAccountOrPassword("Nhập mật khẩu:");
        controller.login(new ServiceAccount(), nameAccount, password);
    }
}
