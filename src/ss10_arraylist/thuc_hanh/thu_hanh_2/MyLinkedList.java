package ss10_arraylist.thuc_hanh.thu_hanh_2;

public class MyLinkedList<E> {
    private static class Node<E> {
        private Node<E> next;
        private final E element;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList(E element) {
        head = new Node<>(element);
        tail = head;
        size = 1;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = head;
            Node<E> holder;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node<>(element);
            temp.next.next = holder;
        }
        size++;
    }

    public void addFirst(E element) {
        Node<E> temp = head;
        head = new Node<>(element);
        head.next = temp;
        size++;
    }

    public Node<E> get(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
}
