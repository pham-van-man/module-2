package ss10_arraylist.bai_tap.bai_tap_2;

public class MyLinkedList<E> {
    private static class Node<E> {
        private Node<E> next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<E> holder = temp.next;
            temp.next = new Node<>(data);
            temp.next.next = holder;
            size++;
        }
    }

    public void addFirst(E data) {
        Node<E> temp = head;
        head = new Node<>(data);
        head.next = temp;
        size++;
    }

    public void addLast(E data) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
        }
        temp.next = new Node<>(data);
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            Node<E> temp = head;
            head = head.next;
            size--;
            return temp.data;
        } else if (index == 1) {
            Node<E> temp = head.next;
            head.next = head.next.next;
            size--;
            return temp.data;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<E> holder = temp.next;
            temp.next = temp.next.next;
            size--;
            return holder.data;
        }
    }

    public boolean remove(E data) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(data)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    //    public E clone(){
//        //??
//    }
    public boolean contains(E data) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E data) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(data)) {
                return i;
            }
        }
        return -1;
    }

    //    public boolean add(E data) {
//    //??
//    }
//    public void ensureCapa() {
//        //??
//    }
    public E get(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E getFist() {
        return head.next.data;
    }

    public E getLast() {
        Node<E> temp = head;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void clean() {
        head = tail = null;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
