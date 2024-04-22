import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    private class MyNode<E>{
        E data;
        MyNode next ;
        MyNode prev ;
        MyNode head ;
        MyNode(E data){
            this.prev=null;
            this.next=null;
            this.data=data;
        }
        MyNode(MyNode prev,MyNode next, E data){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
    }
    MyNode head;
    MyNode tail;
    private int size=0;
    MyLinkedList(){
        this.head=null;
        this.tail=null;
    }

    @Override
      public void add(T item) {
        MyNode newNode = new MyNode(item);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next = newNode;
            tail.prev=tail;
            tail=newNode;
            newNode.next=null;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode node = new MyNode(item);
        MyNode newHead=head;
        for(int i=0;i<index-1;i++){
            newHead=newHead.next;
        }
        newHead.data=item;
    }

    @Override
    public void add(int index, T item) {
        MyNode node = new MyNode(item);
        MyNode newHead=head;
        for(int i=0;i<index-1;i++){
            newHead=newHead.next;
        }
        newHead.next=node;
        node.next=newHead.next.next;
        node.prev=newHead;

    }

    @Override
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        MyNode current = head;
        current.prev=node;
        node.next=current;
        head=node;
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);


    }

    @Override
    public T get(int index) {
        MyNode current=head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }

        return (T) current.data;
    }

    @Override
    public T getFirst() {
        return (T) head.data;
    }

    @Override
    public T getLast() {
        return(T) tail.data;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if(head==null || head.next==null){
            head=null;
            return;
        }
        head=head.next;
        head.prev=null;


        size = size-1;
    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        MyNode current = head;
        while (current.next != null) {
            if (current.data.equals(object)) {
                return true;
            }
            else
                current= current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size+1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        MyList.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return MyList.super.spliterator();
    }

}
