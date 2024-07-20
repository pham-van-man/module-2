package ss11_stack_quece.bai_tap.bai_tap_3;

public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        // Thực hiện các thao tác với hàng đợi
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        System.out.println("Hàng đợi sau khi thêm phần tử:");
        queue.display();
        System.out.println("Phần tử bị loại bỏ: " + queue.deQueue());
        System.out.println("Hàng đợi sau khi lấy phần tử:");
        queue.display();
    }
}
