package chapter1_array;

public class StudentTest {
    private String name;
    private int score;

    public StudentTest(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("name = %s, score = %d", name, score);
    }

    public static void main(String[] args) {
        MyArray<StudentTest> array = new MyArray<>();
        array.addLast(new StudentTest("A", 100));
        array.addLast(new StudentTest("B", 60));
        array.addLast(new StudentTest("C", 85));
        System.out.println(array);
    }
}
