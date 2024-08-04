package ss23_behavioral_design_pattern.test.test_4;

public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Look like a RubberDuck");
    }

    @Override
    public void fly() {
        // Do nothing. It cannot fly
    }
}
