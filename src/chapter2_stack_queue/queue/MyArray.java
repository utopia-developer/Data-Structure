package chapter2_stack_queue.queue;

/**
 * @author Utopia
 * <p>
 * 数组最大的优点：快速查询，所以最好用于“索引有语意”的情况，
 * 但是并非所有有语意的索引都适用于数组
 */
public class MyArray<E> {
    private E[] data;
    /**
     * 数组中第一个没有元素的索引
     */
    private int size;

    /**
     * 带参构造方法
     * 根据用户传入的容量创建数组
     *
     * @param capacity 数组容量
     */
    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造方法
     * 创建容量为100的数组
     */
    public MyArray() {
        this(10);
    }

    /**
     * 向数组尾添加元素
     * O(n)
     *
     * @param e 待添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头添加元素
     * O(1)
     *
     * @param e 待添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组指定位置插入数据
     * <p>
     * 需要判断数组是否有足够的空间存放数据；
     * 需要判断传入的index是否合法
     * O(n)
     *
     * @param index 待插入的位置
     * @param e     待插入的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed! Not have enough space!");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }


    /**
     * 获取指定位置的元素
     * <p>
     * 需要对index进行合法性判断
     * O(1)
     *
     * @param index 指定位置
     * @return 指定位置的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get() failed! Index is illegal!");
        }
        return data[index];
    }

    /**
     * 更新指定位置的元素
     * <p>
     * 需要对index进行合法性判断
     * O(1)
     *
     * @param index 指定位置
     * @param e     待更新的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set() failed! Index is illegal!");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含指定元素
     * O(n)
     *
     * @param e 指定元素
     * @return 数组包含此元素与否
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中指定元素的索引
     * O(n)
     *
     * @param e 指定元素
     * @return 指定元素的索引，若不存在指定元素则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //TODO: findElements()

    /**
     * 删除数组中指定索引的元素
     * O(n)
     *
     * @param index 指定索引
     * @return 删除的元素值
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove() failed! Input index illegal!");
        }
        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        //修改为泛型后添加此语句，方便GC（属于loitering objects，不属于memory leak）
        data[size] = null;
        /*
        修改判断条件size==data.length/2为size==data.length/4，防止出现复杂度震荡
        添加判断条件data.length/2!=0，防止出现数组缩容后长度为0的情况
         */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 删除数组中的第一个元素
     * O(n)
     *
     * @return 删除的元素值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素
     * O(1)
     *
     * @return 删除的元素值
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中的指定元素值（删除单个）
     *
     * @param e 指定元素值
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    //TODO: removeAllElements

    /**
     * 实现数组的动态容量更改
     * O(n)
     *
     * @param newCapacity 新的数组容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}