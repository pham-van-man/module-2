package ss18_threading.bai_tap.bai_tap_2;

public class TestThread {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        evenThread.start();
        oddThread.start();
        try {
            evenThread.join();
            System.out.println("EvenThread Finished");
            oddThread.join();
            System.out.println("OddThread Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}