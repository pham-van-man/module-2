package ss11_stack_quece.bai_tap.bai_tap_3;

public class CircularQueue {
    private Node front;
    private Node rear;

    public CircularQueue() {
        front = rear = null;
    }

    public void enQueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    public Integer deQueue() {
        if (front == null) {
            return null;
        }
        int value = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        return value;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void display() {
        if (front == null) {
            System.out.println("Hàng đợi trống");
            return;
        }
        Node temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}

