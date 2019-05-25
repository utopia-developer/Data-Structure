package chapter3_linkedlist.linkedlist_stack;

public class LinkedListStack<E> implements MyStack<E> {

    private MyLinkedList_v2 list;

    public LinkedListStack() {
        list = new MyLinkedList_v2();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    // TODO: 2019/5/25 多余的类型转换，原因未知
    @Override
    public E pop() {
        return (E) list.removeFirst();
    }

    // TODO: 2019/5/25 多余的类型转换，原因未知
    @Override
    public E peek() {
        return (E) list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList_Stack: top -> [");
        res.append(list);
        res.append(']');
        return res.toString();
    }
}
