package chapter2_stack_queue.queue;

/**
 * @author Utopia
 */
public class MyArrayQueueTest {
    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue);
        }
    }
}
