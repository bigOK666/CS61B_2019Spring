public class ArrayDeque<T> {
    private int size, nextFirst, nextLast;
    private T[] items;

    public ArrayDeque() {
        size = 0;
        nextFirst = 7;
        nextLast = 0;
        items = (T []) new Object[8];
    }
    public ArrayDeque(ArrayDeque other) {

    }

    /*resize the array*/
    private void resize(int capacity) {
        int[] a = new int[capacity];

    }

    /*add item to the last*/
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast++;
        size++;
    }

    /*add item to the first*/
    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    /*check if array is empty*/
    public boolean isEmpty() {
        return size == 0;
    }
}
