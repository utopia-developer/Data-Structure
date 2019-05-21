package chapter2_stack_queue.queue;

import java.util.Arrays;

/**
 * 实现循环队列
 * 解决dequeue()时间复杂度为O(n)的问题, 通过维护front实现O(1)的效果
 * 通过front==tail判断队列为空;
 * (tail+1)%data.length==front判断队列为满
 * 即需要有意识的空出一个空间
 *
 * @param <E> 队列支持的泛型
 */
public class LoopQueue<E> implements MyQueue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    /**
     * 带参构造创建指定容量的循环队列
     * 需要空出一个空间,所以为capacity+1
     *
     * @param capacity 指定容量
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造,创建容量为10的循环队列
     */
    public LoopQueue() {
        this(10);
    }


    /**
     * 入队操作,实现循环队列的元素添加
     * O(1)均摊
     *
     * @param e 入队的元素
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队操作,实现循环队列的元素删除
     * O(1)均摊
     *
     * @return 出队的元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue() failed! Queue is empty");
        }
        E res = data[front];
        //防止loitering object
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && (getCapacity() / 2) != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    /**
     * 得到队首的元素
     * O(1)
     *
     * @return 队首的元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront() failed! Queue is empty");
        }
        return data[front];
    }

    /**
     * 得到队列中的元素个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 得到队列的总容量
     * 总容量需要减去一个空间
     *
     * @return 队列的总容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 实现动态容量改变
     *
     * @param newCapacity 新的队列容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size %d, capacity %d\n", size, getCapacity()));
        res.append("front -> [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] <- tail");
        return res.toString();
    }
}
