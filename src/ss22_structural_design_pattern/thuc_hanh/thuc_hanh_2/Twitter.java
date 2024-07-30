package ss22_structural_design_pattern.thuc_hanh.thuc_hanh_2;

public class Twitter implements SocialShare {
    private String message;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void share() {
        System.out.println("Sharing to Twitter: " + this.message);
    }
}