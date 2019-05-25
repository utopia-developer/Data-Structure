package chapter3_linkedlist.linkedlist_stack;

import java.util.Random;

public class PerformanceTest {
    public static double testPush(MyStack<Integer> stack, int count) {
        double startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double testPop(MyStack<Integer> stack, int count) {
        double startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 100000;
        MyArrayStack<Integer> arrayStack = new MyArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        double arrayStackPushTime = testPush(arrayStack, count);
        System.out.println("ArrayStack: push time = " + arrayStackPushTime + " s");
        double linkedlistStackPushTime = testPush(linkedListStack, count);
        System.out.println("LinkedListStack: push time = " + linkedlistStackPushTime + " s");

        //TODO: dequeue性能差距异常, 差了10倍,初步怀疑ArrayQueue存在问题
        double arrayStackPopTime = testPop(arrayStack, count);
        System.out.println("ArrayStack: pop time = " + arrayStackPopTime + " s");
        double linkedlistStackPopTime = testPop(linkedListStack, count);
        System.out.println("LinkedListStack: pop time = " + linkedlistStackPopTime + " s");
    }
}
