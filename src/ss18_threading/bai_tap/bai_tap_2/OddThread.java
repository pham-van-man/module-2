package ss18_threading.bai_tap.bai_tap_2;

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
