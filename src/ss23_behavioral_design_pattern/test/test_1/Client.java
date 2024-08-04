package ss23_behavioral_design_pattern.test.test_1;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new Observer() {
            public void update(String message) {
                System.out.println("Message 1 changed: " + message);
            }
        };
        Observer observer2 = new Observer() {
            public void update(String message) {
                System.out.println("Message 2 changed: " + message);
            }
        };
        subject.attach(observer1);
        subject.attach(observer2);
        subject.notifyChange("Test change state 1");
        subject.detach(observer1);
        subject.notifyChange("Test change state 2");
    }
}
