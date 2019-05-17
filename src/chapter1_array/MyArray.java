package chapter1_array;

/**
 * @author Utopia
 * <p>
 * 数组最大的优点：快速查询，所以最好用于“索引有语意”的情况，
 * 但是并非所有有语意的索引都适用于数组
 */
public class MyArray {
    private int[] data;
    private int size;

    /**
     * 带参构造方法
     * 根据用户传入的容量创建数组
     *
     * @param capacity 数组容量
     */
    public MyArray(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    /**
     * 无参构造方法
     * 创建容量为100的数组
     */
    public MyArray() {
        this(100);
    }

    /**
     * 向数组尾添加元素
     *
     * @param e 待添加的元素
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 向数组头添加元素
     *
     * @param e 待添加的元素
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向数组指定位置插入数据
     * <p>
     * 需要判断数组是否有足够的空间存放数据；
     * 需要判断传入的index是否合法
     *
     * @param index 待插入的位置
     * @param e     待插入的元素
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add() failed! Not have enough space!");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed! Input index is illegal!");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取指定位置的元素
     * <p>
     * 需要对index进行合法性判断
     *
     * @param index 指定位置
     * @return 指定位置的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get() failed! Index is illegal!");
        }
        return data[index];
    }

    /**
     * 更新指定位置的元素
     * <p>
     * 需要对index进行合法性判断
     *
     * @param index 指定位置
     * @param e     待更新的元素值
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set() failed! Index is illegal!");
        }
        data[index] = e;
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