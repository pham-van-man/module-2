package ss18_threading.bai_tap.bai_tap_3;

public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int count = 0;
        int primeFactor = 2;
        while (count < 10) {
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(primeFactor); i++) {
                if (primeFactor % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(primeFactor);
                count++;
            }
            primeFactor++;
        }
    }
}
