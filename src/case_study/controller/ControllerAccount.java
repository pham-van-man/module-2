package case_study.controller;

import case_study.model.Account;
import case_study.model.Item;
import case_study.service.*;
import case_study.ulti.ValidateInputValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ControllerAccount {
    protected ServiceAccount serviceAccount;
    protected ServiceItemChest serviceItemChest;
    protected ServiceItemRelease serviceItemRelease;

    public ControllerAccount() {
        this.serviceAccount = new ServiceAccountImpl();
        this.serviceItemChest = new ServiceItemChestImpl();
        this.serviceItemRelease = new ServiceItemReleaseImpl();
    }

    public void login(String nameAccount, String password) {
        Account account = serviceAccount.findByAccount(nameAccount, password);
        if (account == null) {
            while (true) {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|        Thông Tin Đăng Nhập Không Chính Xác       |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                int choice = ValidateInputValue.getIntInput("");
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

    public void register(String firstName, String lastName, LocalDate birthDate, String gender, String email, String phoneNumber, String citizenIdentification, String address, String nameAccount, String password, String accountNumber) {
        Account newAccount = new Account(firstName, lastName, birthDate, gender, email, phoneNumber, citizenIdentification, address, nameAccount, password, accountNumber);
        serviceAccount.register(newAccount);
        serviceItemChest.register(newAccount);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                 Đăng Ký Thành Công               |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
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
            System.out.println("| 5. Kho đồ                                        |");
            System.out.println("| 6. Sở giao dịch                                  |");
            System.out.println("| 7. Bày bán                                       |");
            System.out.println("| 8. Tin nhắn                                      |");
            System.out.println("| 9. Đăng xuất                                     |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("");
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
                    showChest(account);
                    break;
                case 6:
                    showItemRelease(account);
                    break;
                case 7:
                    trade(account);
                    break;
                case 8:
                    messenger(account);
                    break;
                case 9:
                    logout();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void messenger(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|         Tính Năng Đang Được Phát Triển           |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void trade(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                     Bày Bán                      |");
            System.out.println("+--------------------------------------------------+");
            StringBuilder line = new StringBuilder();
            for (Item item : serviceItemChest.getChest(account)) {
                String identifier = item.getIdentifier();
                String name = item.getName();
                String itemLine = String.format("%-48s", identifier + " " + name);
                line.append("| ").append(itemLine).append(" |\n");
            }
            System.out.print(line);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Bán                                           |");
            System.out.println("| 2. Gở                                            |");
            System.out.println("| 3. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    sellItem(account);
                    break;
                case 2:
                    showReleaseItem(account);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void showReleaseItem(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                     Bày Bán                      |");
            System.out.println("+--------------------------------------------------+");
            StringBuilder line = new StringBuilder();
            for (Item item : serviceItemChest.getChest(account)) {
                if (item.isRelease()) {
                    String identifier = item.getIdentifier();
                    String name = item.getName();
                    String itemLine = String.format("%-48s", identifier + " " + name);
                    line.append("| ").append(itemLine).append(" |\n");
                }
            }
            System.out.print(line);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Gở                                            |");
            System.out.println("| 2. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    removeItem(account);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void removeItem(Account account) {
        String identifier = ValidateInputValue.getStringInput("Mã định danh:");
        if (serviceItemChest.isItem(account, identifier)) {
            Item item = serviceItemChest.getItem(account, identifier);
            serviceItemChest.updateStatusItem(account, item, false);
            item.setRelease(false);
            serviceItemRelease.removeItem(item);
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                  Gở Thành Công                   |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        } else {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Không Tìm Thấy Item                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    public void sellItem(Account account) {
        String identifier = ValidateInputValue.getStringInput("Mã định danh:");
        if (serviceItemChest.isItem(account, identifier)) {
            Item item = serviceItemChest.getItem(account, identifier);
            double price = ValidateInputValue.getAmount("Giá Item: ");
            serviceItemChest.updateStatusItem(account, item, true);
            item.setRelease(true);
            serviceItemRelease.addItem(item, price);
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                Bày Bán Thành Công                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        } else {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Không Tìm Thấy Item                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    public void showItemRelease(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                  Sở Giao Dịch                    |");
            System.out.println("+--------------------------------------------------+");
            StringBuilder line = new StringBuilder();
            for (Map.Entry<Item, Double> item : serviceItemRelease.findAll().entrySet()) {
                String identifier = item.getKey().getIdentifier();
                String name = item.getKey().getName();
                String value = String.format("%.2f VND", item.getValue());
                String itemLine = String.format("%-49s", identifier + " " + name + " " + value);
                line.append("| ").append(itemLine).append(" |\n");
            }
            System.out.print(line);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Xem                                           |");
            System.out.println("| 2. Mua                                           |");
            System.out.println("| 3. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    showDetailedItemRelease();
                    break;
                case 2:
                    buyItem(account);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void showDetailedItemRelease() {
        String identifier = ValidateInputValue.getStringInput("Mã định danh: ");
        if (serviceItemRelease.isItemReleased(identifier)) {
            Item item = serviceItemRelease.getItem(identifier);
            System.out.println("+--------------------------------------------------+");
            System.out.println("|" + String.format("%50s", item.getName()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Mô tả: " + String.format("%-42s", item.getDescription()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        } else {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Không Tìm Thấy Item                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    private void buyItem(Account account) {
        String identifier = ValidateInputValue.getStringInput("Mã định danh:");
        if (serviceItemRelease.isItemReleased(identifier)) {
            Item item = serviceItemRelease.getItem(identifier);
            String own = item.getOwn();
            double price = serviceItemRelease.getPrice(item);
            if (serviceAccount.isAmount(account, price)) {
                serviceItemRelease.removeItem(item);
                serviceAccount.transfer(account, own, price);
                serviceItemChest.removeItem(own, item);
                item.setOwn(account.getAccountNumber());
                item.setRelease(false);
                serviceItemChest.addItem(account, item);
                System.out.println("+--------------------------------------------------+");
                System.out.println("|                  Mua Thành Công                  |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("");
                    if (choice == 1) {
                        return;
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
            } else {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|                   Mua Thất Bại                   |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| Notify: Số dư không đủ thể thực hiện gia dịch    |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("");
                    if (choice == 1) {
                        return;
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
            }
        } else {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Không Tìm Thấy Item                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    public void showChest(Account account) {
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                      Kho Đồ                      |");
            System.out.println("+--------------------------------------------------+");
            StringBuilder line = new StringBuilder();
            for (Item item : serviceItemChest.getChest(account)) {
                String identifier = item.getIdentifier();
                String name = item.getName();
                String itemLine = String.format("%-48s", identifier + " " + name);
                line.append("| ").append(itemLine).append(" |\n");
            }
            System.out.print(line);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Xem                                           |");
            System.out.println("| 2. Sử dụng                                       |");
            System.out.println("| 3. Thêm Item                                     |");
            System.out.println("| 4. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    showDetailedItem(account);
                    break;
                case 2:
                    usedItem(account);
                    break;
                case 3:
                    addItem(account);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void addItem(Account account) {
        String name = ValidateInputValue.getStringInput("Tên Item: ");
        String material = ValidateInputValue.getStringInput("Chất liệu: ");
        LocalDate releaseDate = ValidateInputValue.getDateInput("Ngày sản xuất: ");
        String country = ValidateInputValue.getStringInput("Quốc gia: ");
        String description = ValidateInputValue.getStringInput("Mô tả: ");
        String own = account.getAccountNumber();
        Item newItem = new Item(name, material, releaseDate, country, description, own);
        serviceItemChest.addItem(account, newItem);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|           Đăng Kí Thêm Item Thành Công           |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| Notify: Người của tổ chức đang trên đường đến lấy|");
        System.out.println("| Item.                                            |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void usedItem(Account account) {
        String identifier = ValidateInputValue.getStringInput("Mã định danh: ");
        if (serviceItemChest.isItem(account, identifier)) {
            Item item = serviceItemChest.getItem(account, identifier);
            if (!item.isRelease()) {
                if (account.getBalance() < 0) {
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("|                 Sử Dụng Thất Bại                 |");
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("| Notify: Tài khoản của bạn bị khóa chức năng này  |");
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("| 1. Trở về                                        |");
                    System.out.println("+--------------------------------------------------+");
                    while (true) {
                        int choice = ValidateInputValue.getIntInput("");
                        if (choice == 1) {
                            return;
                        } else {
                            System.out.println("Lựa chọn không hợp lệ.");
                        }
                    }
                } else {
                    serviceItemChest.removeItem(account, identifier);
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("|                Sử Dụng Thành Công                |");
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("| Notify: Người của tổ chức đang trên đường vận    |");
                    System.out.println("| chuyển Item đến chỗ bạn.                         |");
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("| 1. Trở về                                        |");
                    System.out.println("+--------------------------------------------------+");
                    while (true) {
                        int choice = ValidateInputValue.getIntInput("");
                        if (choice == 1) {
                            return;
                        } else {
                            System.out.println("Lựa chọn không hợp lệ.");
                        }
                    }
                }
            } else {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|                 Sử Dụng Thất Bại                 |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| Notify: Item đang được bày bán                   |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("");
                    if (choice == 1) {
                        return;
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
            }
        } else {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Không Tìm Thấy Item                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    public void showDetailedItem(Account account) {
        String identifier = ValidateInputValue.getStringInput("Mã định danh: ");
        if (serviceItemChest.isItem(account, identifier)) {
            Item item = serviceItemChest.getItem(account, identifier);
            System.out.println("+--------------------------------------------------+");
            System.out.println("|" + String.format("%50s", item.getName()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Mô tả: " + String.format("%-42s", item.getDescription()) + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        } else {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Không Tìm Thấy Item                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    public void showHistory(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|               Lịch Sử Giao Dịch                  |");
        System.out.println("+--------------------------------------------------+");
        System.out.print(serviceAccount.readHistory(account));
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void transfer(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|" + String.format("%50s", account.getLastName() + " " + account.getFirstName()) + "|");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| Số Tài khoản: " + String.format("%-35s", account.getAccountNumber()) + "|");
        System.out.println("| Số dư: " + String.format("%-42s", String.format("%.2f", account.getBalance()) + " VND") + "|");
        System.out.println("+--------------------------------------------------+");
        String accountNumber = ValidateInputValue.getStringInput("Số tài khoản: ");
        if (serviceAccount.isAccountNumber(account, accountNumber)) {
            double amount = ValidateInputValue.getAmount("Số tiền: ");
            if (serviceAccount.isAmount(account, amount)) {
                serviceAccount.transfer(account, accountNumber, amount);
                System.out.println("+--------------------------------------------------+");
                System.out.println("|              Giao Dịch Thành Công                |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("");
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
                System.out.println("| Notify: Số dư không đủ để thực hiện giáo dịch. Số|");
                System.out.println("| dư tài khoản phải trên 50000 VND để trả phí duy  |");
                System.out.println("| trì                                              |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("| 1. Trở về                                        |");
                System.out.println("+--------------------------------------------------+");
                while (true) {
                    int choice = ValidateInputValue.getIntInput("");
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

    public void logout() {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|              Đăng Xuất Thành Công                |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void recharge(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                  Chọn Nhà Mạng                   |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Vietell                                       |");
        System.out.println("| 2. Mobiphone                                     |");
        System.out.println("| 3. Vinaphone                                     |");
        System.out.println("| 4. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
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
        System.out.println("+--------------------------------------------------+");
        System.out.println("|               Chọn Mệnh Giá Thẻ Nạp              |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. 10,000 VND                                    |");
        System.out.println("| 2. 20,000 VND                                    |");
        System.out.println("| 3. 50,000 VND                                    |");
        System.out.println("| 4. 100,000 VND                                   |");
        System.out.println("| 5. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    isCard(account, 10000 * rate);
                    return;
                case 2:
                    isCard(account, 20000 * rate);
                    return;
                case 3:
                    isCard(account, 50000 * rate);
                    return;
                case 4:
                    isCard(account, 10000002 * rate);
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void isCard(Account account, double amount) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|" + String.format("%50s", "Nạp Thẻ " + amount) + "|");
        System.out.println("+--------------------------------------------------+");
        ValidateInputValue.getSeriCard("Số seri: ");
        ValidateInputValue.getCodeCard("Mã thẻ: ");
        account.setBalance(account.getBalance() + amount);
        account.setTotalRecharge(account.getTotalRecharge() + amount);
        serviceAccount.recharge(account, amount);
        serviceAccount.writerHistory(account, "| " + String.format("%-49s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": + " + amount + " VND") + "|\n");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                 Nạp Thẻ Thành Công               |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
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
            System.out.println("| Loại: " + String.format("%-43s", "Tín dụng") + "|");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Đổi Email                                     |");
            System.out.println("| 2. Đổi số điện thoại                             |");
            System.out.println("| 3. Đổi mật khẩu                                  |");
            System.out.println("| 4. Đăng kí tài khoản VIP                         |");
            System.out.println("| 5. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            int choice = ValidateInputValue.getIntInput("");
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
                    registerVIPAccount(account);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void registerVIPAccount(Account account) {
        if (account.getTotalRecharge() < 500000) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|          Đăng Kí Tài Khoản VIP Thất Bại          |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Notify: Tài khoản của bạn chưa đủ uy tín.        |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } else if (serviceAccount.isVIP(account)) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|          Đăng Kí Tài Khoản VIP Thất Bại          |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Notify: Tài khoản của bạn đã được đăng kí VIP.   |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } else {
            serviceAccount.registerVIP(account);
            System.out.println("+--------------------------------------------------+");
            System.out.println("|         Đăng Kí Tài Khoản VIP Thành Công         |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Notify: Đăng nhập lại để sử dụng chức năng VIP.  |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }
    }


    public void changePassword(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                   Đổi Mật Khẩu                   |");
        System.out.println("+--------------------------------------------------+");
        String oldPassword = ValidateInputValue.getNameAccountOrPassword("Mật khẩu: ");
        if (!account.getPassword().equals(oldPassword)) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Đổi Mật Khẩu Thất Bại              |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Trở về                                        |");
            System.out.println("+--------------------------------------------------+");
            while (true) {
                int choice = ValidateInputValue.getIntInput("");
                if (choice == 1) {
                    return;
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }
        String password = ValidateInputValue.getPassword("Mật khẩu mới: ");
        account.setPassword(password);
        serviceAccount.changePassword(account, password);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|              Đổi Mật Khẩu Thành Công             |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void changePhoneNumber(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                Đổi Số Điện Thoại                  |");
        System.out.println("+--------------------------------------------------+");
        String phoneNumberInput = ValidateInputValue.getPhoneNumberInput("Số điện thoại mới: ");
        account.setPhoneNumber(phoneNumberInput);
        serviceAccount.changePhoneNumber(account, phoneNumberInput);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|           Đổi Số Điện Thoại Thành Công           |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void changeEmail(Account account) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                    Đổi Email                     |");
        System.out.println("+--------------------------------------------------+");
        String email = ValidateInputValue.getEmailInput("Email mới: ");
        account.setEmail(email);
        serviceAccount.changeEmail(account, email);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                Đổi Email Thành Công              |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1. Trở về                                        |");
        System.out.println("+--------------------------------------------------+");
        while (true) {
            int choice = ValidateInputValue.getIntInput("");
            if (choice == 1) {
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
