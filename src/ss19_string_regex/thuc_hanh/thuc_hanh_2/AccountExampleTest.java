package ss19_string_regex.thuc_hanh.thuc_hanh_2;

public class AccountExampleTest {
    private static AccountExample accountExample;
    public static final String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
    public static final String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        accountExample = new AccountExample();
        for (String account : validAccount) {
            boolean isValidate = accountExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isValidate);
        }
        for (String account : invalidAccount) {
            boolean isValidate = accountExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isValidate);
        }
    }
}
