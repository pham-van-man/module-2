package ss11_stack_quece.thuc_hanh.thuc_hanh_2;

public class MyLinkedListQueue<E> {
    public static class Node<E> {
        private Node<E> next;
        private final E key;

        public Node(E key) {
            this.key = key;
        }

        public E getKey() {
            return key;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public MyLinkedListQueue() {
    }

    public void enqueue(E key) {
        Node<E> temp = new Node<>(key);
        if (tail == null) {
            head = tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public Node<E> dequeue() {
        if (head == null) {
            return null;
        }
        Node<E> temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return temp;
    }
}
