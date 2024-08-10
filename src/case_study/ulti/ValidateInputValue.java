package case_study.ulti;

import case_study.service.ServiceAccount;
import case_study.service.ServiceAccountImpl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInputValue {
    private static final Scanner SC = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        int value;
        while (true) {
            try {
                System.out.println(prompt);
                value = Integer.parseInt(SC.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        }
        return value;
    }

    public static String getStringInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", " ");
                return value;
            }
            System.out.println("Dữ liệu không hợp lệ!");
        }
    }

    public static String getEmailInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                Pattern pattern = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()) {
                    return value;
                }
            }
            System.out.println("Dữ liệu không hợp lệ!");
        }
    }

    public static String getPhoneNumberInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                Pattern pattern = Pattern.compile("^0[0-9]{9}$");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()) {
                    return value;
                }
            }
            System.out.println("Dữ liệu không hợp lệ!");
        }
    }

    public static LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()) {
                    try {
                        return LocalDate.parse(value);
                    } catch (DateTimeParseException e) {
                        System.out.println("Ngày không hợp lệ! Vui lòng nhập lại (định dạng YYYY-MM-DD).");
                    }
                }
            }
            System.out.println("Dữ liệu không hợp lệ!");
        }
    }

    public static String getNameAccount(String prompt) {
        ServiceAccount service = new ServiceAccountImpl();
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                if (service.checkNameAccount(value)) {
                    return value;
                } else {
                    System.out.println("Tài khoản đã tồn tại!");
                }
            } else {
                System.out.println("Tên tài khoản không hợp lệ!");
            }
        }
    }

    public static String getPassword(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            boolean isValid = Pattern.matches("^[^ ]+$", value);
            if (isValid) {
                System.out.println("Nhập lại mật khẩu.");
                String valueCheck = SC.nextLine();
                if (value.equals(valueCheck)) {
                    return value;
                } else {
                    System.out.println("Mật khẩu sai!");
                }
            } else {
                System.out.println("Mật khẩu không hợp lệ!");
            }
        }
    }

    public static String getAccountNumber(String prompt) {
        ServiceAccount service = new ServiceAccountImpl();
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            boolean isValid = Pattern.matches("^[^ ]{10}$", value);
            if (isValid) {
                boolean isNameAccount = service.checkNumberAccount(value);
                if (isNameAccount) {
                    return value;
                } else {
                    System.out.println("Số tài khoản đã tồn tại!");
                }
            } else {
                System.out.println("Số tài khoản hợp lệ!");
            }
        }
    }

    public static String getCitizenIdentification(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            boolean isValid = Pattern.matches("^(\\d{12}|\\d{9})$", value);
            if (isValid) {
                return value;
            } else {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        }
    }

    public static String getNameAccountOrPassword(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                return value;
            }
            System.out.println("Dữ liệu không hợp lệ!");
        }
    }

    public static String getSeriCard(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                boolean isValid = Pattern.matches("^(\\d{14})$", value);
                if (isValid) {
                    return value;
                }
            }
            System.out.println("Số Seri Không Hợp Lệ!");
        }
    }

    public static String getCodeCard(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = SC.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                boolean isValid = Pattern.matches("^(\\d{15})$", value);
                if (isValid) {
                    return value;
                }
            }
            System.out.println("Mã Thẻ Không Hợp Lệ!");
        }
    }

    public static double getAmount(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                double value = Double.parseDouble(SC.nextLine());
                if (value < 5000) {
                    System.out.println("Số tiền giao dịch ít nhất là 5000 VND!");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        }
    }

    public static String getGender(String prompt) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|             1. Nam             2. Nữ             |");
            System.out.println("+--------------------------------------------------+");
            int value = getIntInput(prompt);
            if (value == 1) {
                return "Nam";
            } else if (value == 2) {
                return "Nữ";
            } else {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        }
    }
}
