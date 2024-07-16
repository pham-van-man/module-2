package ss10_arraylist.bai_tap.bai_tap_1;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 8;
    private E[] array = (E[]) new Object[DEFAULT_CAPACITY];

    public MyList() {
    }

    public MyList(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public void add(int index, E element) {
        ensureIndex(index);
        size++;
        ensureCapa();
        if (index == size) {
            array[index] = element;
        } else {
            for (int i = index; i < array.length; i++) {
                array[i + 1] = array[i];
            }
            array[index] = element;
        }
    }

    public void ensureCapa() {
        if (size == array.length) {
            E[] newArray = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    public E remove(int index) {
        ensureIndex(index);
        size--;
        E element = array[index];
        array[index] = null;
        return element;
    }

    public void ensureIndex(int index) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

//    public E clone() {
//    //???
//    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
//    public boolean add(E element) {
//    //???
//    }
    public E get(int index) {
        ensureIndex(index);
        return array[index];
    }

    public void clean() {
        size = 0;
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }
}
