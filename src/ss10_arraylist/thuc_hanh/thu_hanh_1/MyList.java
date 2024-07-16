package ss10_arraylist.thuc_hanh.thu_hanh_1;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public MyList() {
    }

    public void ensureCapa() {
        if (size == elements.length) {
            E[] newElements = (E[]) new Object[2 * size];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public void add(E e) {
        ensureCapa();
        elements[size++] = e;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return elements[index];
        }
    }

}