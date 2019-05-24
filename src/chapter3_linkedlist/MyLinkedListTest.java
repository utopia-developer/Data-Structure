package chapter3_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(array);
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.println(linkedList);
        }
    }
}
