package ss18_threading.bai_tap.bai_tap_1;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);
        thread1.start();
        thread2.start();
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.setPriority(Thread.MAX_PRIORITY);
    }
}
