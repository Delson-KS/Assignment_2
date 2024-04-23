import java.lang.reflect.Member;
import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T extends Comparable<T>>extends check_Index implements MyList{

    private class Node<D>{
        D data;
        Node next;
        Node prev;
        Node(D data){
            this.data = data;
            next=null;
            prev=null;
        }
        Node(D data,Node next,Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node head;
    private Node tail;
    MyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    private int size;
    @Override
    public void add(Object item) {
        Node node = new Node(item);

        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail.prev=tail;
            tail=node;
        }
        size++;
    }

    @Override
    public void set(int index, Object item) {
        index_check(index,size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }


    @Override
    public void add(int index, Object item) {
        Node node = new Node(item);
        if(index==0){
            node.next=head;
            head=node;
        }
        else if(index==size-1){
            tail.next=node;
            tail.prev=tail;
            tail=node;
        }
        else{
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            current.next.prev = node;
            current.next = node;
        }
        size++;
    }

    @Override
    public void addFirst(Object item) {
        Node node = new Node(item);
        node.next=head;
        head=node;
        size++;
    }

    @Override
    public void addLast(Object item) {
        Node node = new Node(item);
        tail.next=node;
        tail.prev=tail;
        tail=node;
        size++;
    }

    @Override
    public Object get(int index) {
        index_check(index,size-1);
        Node current=head;
        if(index==0)
            return head.data;
        if(index==size-1)
            return tail.data;
        else {
            for(int i=0;i<index;i++){
                current=current.next;
            }
        }
        return current.data;
    }

    @Override
    public Object getFirst() {
        return head.data;
    }

    @Override
    public Object getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        index_check(index,size);
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            Node current = head;
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
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        Node current = head;
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
        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        Node current = head;
        for(int i=0;i<size;i++){
            if(current.data.equals(object)){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        for (int i=0;i<size;i++){
            arr[i]=current.data;
            current=current.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    public class MyIterator implements Iterator<T> {
        private Node current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext() != true) {
                throw new NoSuchElementException();
            }
            T element = (T) current.data;
            current = current.next;
            index++;
            return element;
        }
    }
}
