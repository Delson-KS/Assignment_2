import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{

    private static final int default_capacity = 10;

    private static final Object[] empty_data={};
    public Object[] element_data;
    private static int size=0;
    private int capacity ;


    public MyArrayList(){
        element_data=new Object[default_capacity];

    }
    public MyArrayList(int initialCapacity){
        if(initialCapacity==0){
            element_data=empty_data;
            capacity=default_capacity;
        }
        else if(initialCapacity>0){
            element_data=new Object[initialCapacity];
            capacity=initialCapacity;
        }
        else {
            throw new IllegalArgumentException("capacity can't be a negative number :" + initialCapacity);
        }

    }



    @Override
    public void add(T item) {
        if(size >= capacity){
            increaseCapacity();
        }
        element_data[size]=item;
        size++;
    }
    public void increaseCapacity(){
        element_data=new Object[capacity*2];
        capacity = capacity *2;
    }






    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {
        Object[] temp = new Object[element_data.length+1];
        temp[0]= item;
        for(int i=1;i<element_data.length;i++){
            temp[i]=element_data[i-1];
        }
        element_data=temp;

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        if(index>capacity){
            System.out.println("out of length");
        }
        return (T) element_data[index];
    }

    @Override
    public T getFirst() {
        return (T) element_data[0];
    }

    @Override
    public T getLast() {
        return (T) element_data[size];
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
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
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator();
    }


}
