package ss11_stack_quece.thuc_hanh.thuc_hanh_1;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    LinkedList<T> stack = new LinkedList<>();

    public MyGenericStack() {
    }

    public void push(T type) {
        stack.addFirst(type);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public int size() {
        return stack.size();
    }
    public boolean isEmpty() {
        if (stack.size()==0) {
            return true;
        }
        return false;
    }
}
