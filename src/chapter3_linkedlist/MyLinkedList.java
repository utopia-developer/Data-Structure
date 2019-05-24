package chapter3_linkedlist;

/**
 * 链表
 * 优点: 是真正的动态数据结构,无需担心容量问题
 * 缺点: 失去了随机访问能力
 */
public class MyLinkedList<E> {

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

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public MyLinkedList(E[] array) {
        Node node;
        for (int i = 0; i < array.length; i++) {
            E e = array[i];
            if (e != null) {
                node = new Node(e);
                size++;
            }
        }
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
     * 向链表头添加元素
     *
     * @param e 待添加的元素
     */
    public void addFirst(E e) {
//        写法一:
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        //写法二:
        head = new Node(e, head);

        size++;
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
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            写法一:
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
//
            //写法二:
            prev.next = new Node(e, prev.next);

            size++;
        }
    }

    /**
     * 在链表尾添加元素
     *
     * @param e 待添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }
}
