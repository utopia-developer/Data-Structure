package chapter3_linkedlist.linkedlist_stack;

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> arrayStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
