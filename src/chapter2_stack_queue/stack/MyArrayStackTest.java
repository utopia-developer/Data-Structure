package chapter2_stack_queue.stack;

public class MyArrayStackTest {
    public static void main(String[] args) {
        MyArrayStack<Integer> arrayStack = new MyArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
