package ss21_design_patterns.thuc_hanh.thuc_hanh_2;

public class ObjectPoolDemo {
    public static final int NUM_OF_CLIENT = 8;

    public static void main(String[] args) {
        TaxiPool taxiPool = new TaxiPool();
        for (int i = 1; i < NUM_OF_CLIENT; i++) {
            Runnable client = new TaxiThread(taxiPool);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}
