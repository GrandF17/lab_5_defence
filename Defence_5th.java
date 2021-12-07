import java.util.Arrays;

/*
 * Написать метод сортировки динамического массива из 3 л.р. используя
 * сортировку вставками. У метода должен быть параметр
 * задающий порядок сортировки (по возрастанию, по убыванию)
 * Написать тестовый класс демонстрирующий работу метода
 */

@SuppressWarnings("unchecked")
public class Defence_5th<T>{
    private T[] arr;
    private int size;
    private int max_size;

    public Defence_5th(){
        this.arr = (T[])new Object[1];
        this.max_size = 1;
        this.size = 0;
    }

    public Defence_5th(int capacity){
        this.arr = (T[])new Object[capacity];
        this.max_size = capacity;
        this.size = 0;
    }

    private void resize(){
        T[] new_arr = (T[])new Object[2 * this.max_size + 10];
        if (this.max_size >= 0) System.arraycopy(this.arr, 0, new_arr, 0, this.max_size);
        this.arr = new_arr;
        this.max_size = 2 * this.max_size + 10;
    }

    public void append(T element){
        if (this.size == this.max_size) resize();
        this.arr[size] = element;
        this.size++;
    }

    public void insert(T element, int index){
        if (index > this.size || index < 0)
            return;

        if (this.size == this.max_size) resize();
        size++;
        arr[index] = element;
    }

    public void print() {
        System.out.println(Arrays.toString(this.arr));
    }

    public T get(int index) {
        return this.arr[index];
    }

    public <T extends Comparable<T>> void sort(T[] array, int size, boolean fromSmallestToLargest) {
        for (int left = 0; left < size; left++) {
            T value = array[left];

            int i = left - 1;
            for (; i >= 0; i--) {
                if(fromSmallestToLargest && value.compareTo((T) array[i]) < 0 || !fromSmallestToLargest && value.compareTo((T) array[i]) > 0) {
                    array[i + 1] = array[i];
                } else  { break; }
            }
            array[i + 1] = value;
        }
    }
}