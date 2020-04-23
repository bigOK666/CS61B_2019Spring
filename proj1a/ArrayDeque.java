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
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        if (nextFirst + 1 > nextLast - 1) {
            System.arraycopy(items, (nextFirst + 1) % items.length, a, (nextFirst + 1 + capacity - items.length) % capacity, size - nextLast);
            nextFirst = nextFirst + capacity - items.length;
        }

        items = a;

    }

    /*add item to the last*/
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast++;
        size++;
    }

    /*add item to the first*/
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 +items.length) % items.length;
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
        int firstIndex = (nextFirst + 1) % L;
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
            T x = items[(nextFirst + 1) % items.length];
            items[(nextFirst + 1) % items.length] = null;
            nextFirst = (nextFirst + 1) % items.length;
            size--;
            if (items.length >= 16 && (double) size / items.length < 0.25) {
                resize(size * 2);
            }
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
            if (items.length >= 16 && (double) size / items.length < 0.25) {
                resize(size * 2);
            }
            return x;
        }
    }

    /*get the ith element*/
    public T get(int i) {
        if (i > size - 1) {
            return null;
        } else {
            return items[(i + nextFirst + 1) % items.length];
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> test= new ArrayDeque<>();
        test.addFirst(1);
        test.addLast(2);
        test.addFirst(0);
        test.addLast(3);
        test.addLast(4);
        test.addLast(5);
        test.addLast(6);
        test.addLast(7);
        test.printDeque();
        test.addLast(8);
        test.removeFirst();
        test.removeFirst();
//        test.printDeque();
        test.removeLast();
        test.removeFirst();
//        test.printDeque();
//        System.out.print(test.get(2));
        test.removeFirst();
        test.removeLast();
        System.out.print(test.get(2));

    }
}
