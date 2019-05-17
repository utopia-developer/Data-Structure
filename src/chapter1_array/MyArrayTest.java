package chapter1_array;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray array = new MyArray(20);
        for(int i = 0; i < 10; i++){
            array.addLast(i);
        }
        array.add(2, 3);
        array.add(7, 0);
        System.out.println(array);
    }
}
