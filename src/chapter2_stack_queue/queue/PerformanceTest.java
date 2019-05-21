package chapter2_stack_queue.queue;

import java.util.Random;

public class PerformanceTest {
    public static double testEnqueue(MyQueue<Integer> queue, int count) {
        double startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double testDequeue(MyQueue<Integer> queue, int count) {
        double startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 100000;
        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        double arrayQueueEnqueueTime = testEnqueue(arrayQueue, count);
        System.out.println("ArrayQueue: enqueue time = " + arrayQueueEnqueueTime + " s");
        double loopQueueEnqueueTime = testEnqueue(loopQueue, count);
        System.out.println("LoopQueue: enqueue time = " + loopQueueEnqueueTime + " s");

        //TODO: dequeue性能差距异常, 差了10倍,初步怀疑ArrayQueue存在问题
        double arrayQueueDequeueTime = testDequeue(arrayQueue, count);
        System.out.println("ArrayQueue: dequeue time = " + arrayQueueDequeueTime + " s");
        double loopQueueDequeueTime = testEnqueue(loopQueue, count);
        System.out.println("LoopQueue: dequeue time = " + loopQueueDequeueTime + " s");
    }
}
