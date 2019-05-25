package chapter3_linkedlist.linkedlist_stack;

/**
 * @author Utopia
 * 栈也是一种线性结构，对应的操作是数组的子集
 * LIFO（后进先出），从栈顶取出元素
 * <p>
 * 栈的应用：
 * 1. 撤销（undo）操作；
 * 2. 程序调用的系统栈
 */
public interface MyStack<E> {
    /**
     * 入栈操作
     * @param e 需要压入的元素
     */
    void push(E e);

    /**
     * 出栈操作
     * @return 出栈的元素
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    E peek();

    /**
     * 得到栈中元素的数量
     * @return 栈中元素的数量
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return 栈是否为空
     */
    boolean isEmpty();
}
