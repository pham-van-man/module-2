package ss23_behavioral_design_pattern.test.test_4;

public class Test {
    public static void main(String[] args) {
        Duck mallarDuck = new MallarDuck();
        Duck rubberDuck = new RubberDuck();
        mallarDuck.quack();
        mallarDuck.fly();
        rubberDuck.fly();
    }
}