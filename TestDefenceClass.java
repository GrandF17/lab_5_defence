import java.lang.reflect.Array;
import java.util.Arrays;

public class TestDefenceClass<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public TestDefenceClass(int capacity, T... dummy) {
        if (dummy.length > 0)
            throw new IllegalArgumentException("Do not provide values for dummy argument.");
        Class<?> c = dummy.getClass().getComponentType();
        array = (T[]) Array.newInstance(c, capacity);
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);

        Defence_5th<Integer> t1 = new Defence_5th<Integer>(size);
        TestDefenceClass<Integer> mass = new TestDefenceClass<>(size);

        for(int i = 0; i < size; i++) {
            t1.append(size - i);
        }
        for(int i = 0; i < size; i++) {
            mass.array[i] = t1.get(i);
        }
        t1.print();
        t1.sort(mass.array, size, true);
        for(int i = 0; i < size; i++) {
            t1.insert(mass.array[i], i);
        }
        System.out.println(Arrays.toString(mass.array));
        t1.print();
    }
}