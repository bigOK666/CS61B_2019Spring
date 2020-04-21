public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;
    /* Create Node class to define a Node*/
    private class Node {
        public T item;
        public Node pre, next;
        public Node(T i, Node prv, Node nex){
            item = i;
            pre = prv;
            next = nex;
        }
    }
    /* Create an empty linked list deque*/
    public LinkedListDeque(){
        sentinel = new Node(null, null,null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /* initial with one element*/
    public LinkedListDeque(T x){
        sentinel = new Node(null, null, null);

        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.pre = sentinel.next;
        size = 1;
    }

    /* add First element*/
    public void addFirst(T item){
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = node;
        sentinel.next = node;
        size += 1;
    }
    /*Add element to last position*/
    public void addLast(T item){
        Node node = new Node(item, sentinel.pre,sentinel);
        sentinel.pre.next = node;
        sentinel.pre = node;
        size += 1;
    }
    /*check if list is empty*/
    public boolean isEmpty(){
        return size == 0;
    }
    /*Return the number of elements in the list*/
    public int size(){
        return size;
    }

    /*print all the elements*/
    public void printDeque(){
        Node p = sentinel.next;
        while(p.item != null){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(" ");
    }

    /*remove first element*/
    public T removeFirst(){
        if (size != 0){
            T v = sentinel.next.item;
            sentinel.next.next.pre = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return v;
        }else{
            return null;
        }

    }

    public LinkedListDeque(LinkedListDeque other){


    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<>(10);
        test.addFirst(20);
        test.addLast(30);
//        test.printDeque();
        test.removeFirst();
    }
}
