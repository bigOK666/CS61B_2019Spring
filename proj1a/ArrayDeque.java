public class ArrayDeque<T> {
    private int size, nextFirst, nextLast;
    private T[] items;

    public ArrayDeque() {
        size = 0;
        nextFirst = 0;
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
}
