package chapter2_stack_queue.queue;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue);
        }
    }
}
