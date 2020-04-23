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

    /*show the size of the arraylist*/
    public int size() {
        return size;
    }

    /*show the item in the array list*/
    public void printDeque() {
        int L = items.length;
        int firstIndex = (nextFirst + 1) % 8;
        for(int i = 0; i < size; i++) {
            System.out.print(items[(i + firstIndex) % L] + " ");
        }
        System.out.println(" ");
    }

    /*remove the first element*/
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T x = items[(nextFirst + 1) % 8];
            items[(nextFirst + 1) % 8] = null;
            nextFirst++;
            size--;
            return x;
        }
    }

    /*remove the last element*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T x = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast--;
            size--;
            return x;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> test= new ArrayDeque<>();
        test.addFirst(1);
        test.addLast(2);
        test.addFirst(0);
        test.addLast(3);
        test.printDeque();
        test.removeFirst();
        test.printDeque();
        test.removeLast();
        test.printDeque();

    }
}
