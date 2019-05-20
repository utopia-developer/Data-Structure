package chapter2_stack_queue.stack;

/**
 * @author Utopia
 * 复用动态数组，创建动态栈
 */
public class MyArrayStack<E> implements MyStack<E> {
    private MyArray<E> array;

    /**
     * 带参构造
     * 已知栈容量的情况下创建栈
     *
     * @param capacity 栈的容量
     */
    public MyArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    /**
     * 无参构造
     * 未知栈容量的情况下，创建容量为10的栈
     */
    public MyArrayStack() {
        array = new MyArray<>(10);
    }

    /**
     * 入栈操作
     * O(1) 均摊
     *
     * @param e 需要压入的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈操作
     * O(1) 均摊
     *
     * @return 栈顶元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * O(1)
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    /**
     * 得到栈中元素的数量
     *
     * @return 栈中元素的数量
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return 栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 得到数组的总长度
     *
     * @return 数组的总长度
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] <- top");
        return res.toString();
    }
}
