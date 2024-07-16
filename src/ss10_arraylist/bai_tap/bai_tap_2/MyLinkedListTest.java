package ss10_arraylist.bai_tap.bai_tap_2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(3, 9);
        ll.add(4, 9);
        ll.printList();
    }
}
