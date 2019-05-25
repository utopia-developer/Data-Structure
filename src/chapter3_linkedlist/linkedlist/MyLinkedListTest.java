package chapter3_linkedlist.linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList_v2<Integer> linkedList = new MyLinkedList_v2<>();
        for (int i = 4; i >= 0; i--) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(3, 69);
        System.out.println(linkedList);
        linkedList.addLast(100);
        System.out.println(linkedList);

        System.out.println("=========================================");
        linkedList.remove(4);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
