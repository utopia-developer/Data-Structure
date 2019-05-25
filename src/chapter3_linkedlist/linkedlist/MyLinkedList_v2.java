package chapter3_linkedlist.linkedlist;

/**
 * 使用虚拟头节点（dummy head）实现链表
 */
public class MyLinkedList_v2<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public MyLinkedList_v2() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表指定位置(0-based)添加元素
     * <p>
     * 练习用, 不属于链表的常用操作
     *
     * @param index 指定位置
     * @param e     待添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed! Input index is illegal!");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 向链表头添加元素
     *
     * @param e 待添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾添加元素
     *
     * @param e 待添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 获取指定位置（0-based）的链表元素值
     * 练习用, 不属于链表的常用操作
     *
     * @param index 指定位置
     * @return 链表的元素值
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get() failed! Input index is illegal!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表头的元素值
     *
     * @return 链表头元素值
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表尾的元素值
     *
     * @return 链表尾元素值
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新链表中指定位置（0-based）的元素值
     * 练习用, 不属于链表的常用操作
     *
     * @param index 指定位置
     * @param e     待更新的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set() failed! Input index is illegal!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断链表中是否包含某元素值
     *
     * @param e 待判断的元素值
     * @return 是否包含该元素
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表中指定位置（0-based）的元素值
     * 练习用, 不属于链表的常用操作
     *
     * @param index 指定位置
     * @return 删除位置的元素值
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove() failed! Input index is illegal!");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node res = prev.next;
        prev.next = res.next;
        res.next = null;
        size--;
        return res.e;
    }

    /**
     * 删除链表头的元素
     *
     * @return 链表头的元素值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表尾的元素
     *
     * @return 链表尾的元素值
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: [");
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + " -> ");
            cur = cur.next;
        }
        res.append("NULL]");
        return res.toString();
    }
}


