package study_case.controller;

import study_case.model.Instructor;
import study_case.service.ServiceInstructor;
import study_case.service.ServiceInstructorImpl;
import study_case.util.Validate;

public class ControllerInstructor {
    private static ServiceInstructor service = new ServiceInstructorImpl();

    public static void teacherMenu() {
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Chỉnh sửa\n" +
                    "4.Xóa\n" +
                    "5.Tìm kiếm\n" +
                    "6.Thoát\n");
            int choose = Validate.getIntInput("Nhập lựa chọn");
            switch (choose) {
                case 1:
                    display();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }


    public static void display() {
        while (true) {
            for (Instructor instructor : service.findAll()) {
                System.out.println(instructor);
            }
            System.out.println("Chọn chức năng \n" +
                    "1.Sắp xếp theo tên\n" +
                    "2.Sắp xếp theo ID \n" +
                    "3.Thoát\n");
            int choose = Validate.getIntInput("Nhập lựa chọn");
            switch (choose) {
                case 1:
                    sortByName();
                    break;
                case 2:
                    sortByID();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void sortByID() {
        service.sortByID();
    }

    private static void sortByName() {
        service.sortByName();
    }

    public static void add() {
        int id = Validate.getIntInput("Nhập ID");
        if (isEmpty(id)) {
            System.out.println("ID đã tồn tại");
            return;
        }
        String name = Validate.getStringInput("Nhập tên");
        int age = Validate.getAgeInput("Nhập tuổi");
        String phoneNumber = Validate.getPhoneNumberInput("Nhập số điện thoại");
        String email = Validate.getEmailInput("Nhâp Email");
        String address = Validate.getStringInput("Nhập địa chỉ");
        Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
        service.add(instructor);
        System.out.println("Thêm mới thành công");
    }

    private static boolean isEmpty(int id) {
        return service.isEmpty(id);
    }

    public static void delete() {
        int id = Validate.getIntInput("Nhập ID cần xóa");
        Instructor instructor = service.delete(id);
        if (instructor != null) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public static void edit() {
        int id = Validate.getIntInput("Nhập ID cần chỉnh sửa");
        if (!isEmpty(id)) {
            System.out.println("Không tìm thấy");
        } else {
            String name = Validate.getStringInput("Nhập tên");
            int age = Validate.getAgeInput("Nhập tuổi");
            String phoneNumber = Validate.getPhoneNumberInput("Nhập số điện thoại");
            String email = Validate.getEmailInput("Nhâp Email");
            String address = Validate.getStringInput("Nhập địa chỉ");
            Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
            int index = service.getIndex(id);
            service.update(index, instructor);
            System.out.println("Chỉnh sửa thành công");
        }
    }

    public static void search() {
        String search = Validate.getStringInput("Tìm kiếm");
        boolean flag = false;
        for (Instructor instructor : service.findAll()) {
            if (instructor.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(instructor);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy");
        }
    }
}
