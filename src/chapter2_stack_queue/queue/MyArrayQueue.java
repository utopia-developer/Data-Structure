package chapter2_stack_queue.queue;

/**
 * @author Utopia
 */
public class MyArrayQueue<E> implements MyQueue<E> {
    private MyArray<E> array;

    /**
     * 带参构造，创建指定长度的队列
     *
     * @param capacity 指定长度
     */
    public MyArrayQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    /**
     * 无参构造，创建默认长度（10）的队列
     */
    public MyArrayQueue() {
        array = new MyArray<>();
    }

    /**
     * 入队操作
     * O(1) - 均摊
     *
     * @param e 入队的元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队操作
     * O(n)
     *
     * @return 出队的元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 得到队首元素
     * O(1)
     * @return 队首元素
     */
    @Override
    public E getFront() {
        return array.get(0);
    }

    /**
     * 得到队列的长度
     *
     * @return 队列的长度
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 得到队列的总容量
     *
     * @return 队列的总容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front -> [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] <- tail");
        return res.toString();
    }
}
