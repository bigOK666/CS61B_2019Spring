public class ArrayDeque<T> implements Deque<T>{
    private int size, nextFirst, nextLast;
    private T[] items;


    public ArrayDeque() {
        size = 0;
        nextFirst = 7;
        nextLast = 0;
        items = (T []) new Object[8];
    }
    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[other.items.length];
        for (int i = 0; i < other.items.length; i++) {
            items[i] = (T) other.items[i];
        }
        size = other.size();
        nextFirst = other.nextFirst();
        nextLast = other.nextLast();
    }

    /*resize the array*/
    private void resize(int capacity) {
        //copy the old array to the new one
        T[] a = (T []) new Object[capacity];
        for (int newIndex = 0; newIndex < size; newIndex++) {
            a[newIndex] = get(newIndex);
            //a[newIndex] = items[(newIndex + nextFirst + 1) % items.length];
        }

        nextLast = size;
        nextFirst = capacity - 1;


        items = a;

    }

    /*add item to the last*/
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1)% items.length;
        size++;
    }

    /*add item to the first*/
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;//to make sure the nextFirst is not negative
        size++;
    }

    /*show the size of the arraylist*/
    @Override
    public int size() {
        return size;
    }

    public int nextFirst() {
        return nextFirst;
    }

    public int nextLast() {
        return nextLast;
    }
    /*show the item in the array list*/
    @Override
    public void printDeque() {
        int L = items.length;
        int firstIndex = (nextFirst + 1) % L;
        for (int i = 0; i < size; i++) {
            System.out.print(items[(i + firstIndex) % L] + " ");
        }
        System.out.println(" ");
    }

    /*remove the first element*/
    @Override
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
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T x = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast = (nextLast - 1) % items.length;
            size--;
            if (items.length >= 16 && (double) size / items.length < 0.25) {
                resize(size * 2);
            }
            return x;
        }
    }

    /*get the ith element*/
    @Override
    public T get(int i) {
        if (i > size - 1) {
            return null;
        } else {
            return items[(i + nextFirst + 1) % items.length];
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
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

        ArrayDeque<Integer> test2 = new ArrayDeque<>(test);
        test2.removeLast();
        test2.removeFirst();
        test2.removeLast();
        test2.addFirst(0);

    }
}
