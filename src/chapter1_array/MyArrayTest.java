package chapter1_array;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(2, 3);
        System.out.println(array);
        array.add(7, 0);
        System.out.println(array);
        array.remove(1);
        System.out.println(array);
        array.removeElement(4);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.remove(7);
        System.out.println(array);
    }
}
