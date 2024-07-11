package ss7_abstract_class_interface.thuc_hanh.thuc_hanh_1;

public class Main {
}
abstract class Fruit implements Edible{
}
class Apple extends Fruit {
    public String howToEat(){
        return "Apple could be slided";
    }
}
class Orange extends Fruit {
    public String howToEat(){
        return "Orange could be juiced";
    }
}
abstract class Animal {
    public abstract String makeSound();
}

class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}

class Tiger extends Animal {
    @Override
    public String makeSound() {
        return "Tiger: tiger-tiger!";
    }
}

interface Edible {
    String howToEat();
}

