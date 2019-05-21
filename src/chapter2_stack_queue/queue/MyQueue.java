package chapter2_stack_queue.queue;

/**
 * 队列是一种线性数据结构，操作是数组的子集
 * FIFO
 *
 * @param <E> 支持的泛型
 */
public interface MyQueue<E> {
    /**
     * 入队操作
     *
     * @param e 入队的元素
     */
    void enqueue(E e);

    /**
     * 出队操作
     *
     * @return 出队的元素
     */
    E dequeue();

    /**
     * 得到队首的元素
     *
     * @return 队首的元素
     */
    E getFront();

    /**
     * 队列的长度
     *
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();
}
