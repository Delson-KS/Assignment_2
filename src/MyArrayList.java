import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>{

    private static final int default_capacity = 10;

    private static final Object[] empty_data={};
    public Object[] element_data;
    private static int size=0;
    private int capacity ;

    //constructor without parameters
    public MyArrayList(){
        element_data=new Object[default_capacity];
        capacity = default_capacity;
    }
    //constructor with 1 parameter
    public MyArrayList(int initialCapacity){
        if(initialCapacity==0){
            capacity=0;
            element_data=empty_data;
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
    public void add(T item) { //insert function
        if(element_data.length==size+1){
            increaseCapacity();
        }

        element_data[size]=item;
        size++;
    }
    public void increaseCapacity(){//increase capacity if there no empty slots
        capacity = capacity+1;
        Object[] temp = new Object[capacity];
        for(int i=0;i<size;i++){
            temp[i]=element_data[i];
        }
        element_data=temp;
    }






    @Override
    public void set(int index, T item) {
        element_data[index] = item;
    }//set data into index

    @Override
    public void add(int index, T item) {
        if(element_data.length==size+1){
            increaseCapacity();
        }
        element_data[index]=item;
        size++;
    }//set data into index

    @Override
    public void addFirst(T item) {
        if(size >= capacity){
            increaseCapacity();
        }
        Object[] temp = new Object[element_data.length+1];
        temp[0]= item;
        for(int i=1;i<element_data.length;i++){
            temp[i]=element_data[i-1];
        }
        element_data=temp;
        size++;
    } // insert data as first element

    @Override
    public void addLast(T item) {
        add(item);
    }//insert data as last element

    @Override
    public T get(int index) {
        if(index>capacity){
            System.out.println("out of length");
        }
        return (T) element_data[index];
    }//return data on index

    @Override
    public T getFirst() {
        return (T) element_data[0];
    } // return data of first element

    @Override
    public T getLast() {
        return (T) element_data[size-1];
    }//return data of last element

    @Override
    public void remove(int index) {

        Object[] temp = new Object[element_data.length];

        for(int i =0; i< index;i++){
            temp[i] = element_data[i];
        }

        for(int i=index ;i<size-1;i++){
            temp[i]=element_data[i+1];
        }
        size--;
        element_data=temp;
    }//delete data from index

    @Override
    public void removeFirst() {
        Object[] temp = new Object[size-1];

        for(int i=0;i<size-1;i++){
            temp[i]=element_data[i+1];
        }
        element_data=temp;
        size--;
    }//delete first element

    @Override
    public void removeLast() {
        Object[] temp = new Object[size-1];
        for(int i =0 ;i<size-1;i++){
            temp[i]=element_data[i];
        }
        element_data =temp ;
        size--;
    }//delete last element

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable)element_data[j]).compareTo(element_data[j+1]) < 0) {
                    Object temp = element_data[j];
                    element_data[j] = element_data[j+1];
                    element_data[j+1] = temp;
                }
            }
        }
    }//sorting function

    @Override
    public int indexOf(Object object) {
        for(int i=0;i<size;i++){
            if(element_data[i].equals(object)){
                return i;
            }
        }
        return -1;
    }//function that checks index of data(if exist)

    @Override
    public int lastIndexOf(Object object) {
        for(int i = size; i>=0; i--) {
            if (element_data[i] == object) {
                return i;
            }
        }
        return -1;
    }//function that checks last index of data(if exist)

    @Override
    public boolean exists(Object object) {
        int check=0;
        for(int i=0;i<size;i++){
            if(element_data[i].equals(object)){
                check++;
            }
        }

        return check>0;
    }//check to existing

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(element_data, size);
    }//return as array

    @Override
    public void clear() {
        Object[] temp = new Object[default_capacity];
        element_data=temp;
    }//delete all data

    @Override
    public int size() {
        return size+1;
    }//return size

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T>{
        private int index =0;
        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public T next() {
            return (T) element_data[index++];
        }
    }
}
