import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList <T extends Comparable<T>> implements MyList<T> {

    private static final int default_capacity = 10;
    private Object[] element_data;
    private static int size = 0;


    public MyArrayList() {
        element_data = new Object[default_capacity];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            element_data = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("capacity can't be a negative number :" + initialCapacity);
        }

    }


    @Override
    public void add(T item) {
        if (element_data.length == size + 1) {
            increaseCapacity();
        }

        element_data[size] = item;
        size++;
    }

    public void increaseCapacity() {
        Object[] temp = new Object[element_data.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = element_data[i];
        }
        element_data = temp;
    }


    @Override
    public void set(int index, T item) {
        element_data[index] = item;
    }

    @Override
    public void add(int index, T item) {
        element_data[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        if (size >= element_data.length) {
            increaseCapacity();
        }
        Object[] temp = new Object[element_data.length + 1];
        temp[0] = item;
        for (int i = 1; i < element_data.length; i++) {
            temp[i] = element_data[i - 1];
        }
        element_data = temp;
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index >= size) {
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
        return (T) element_data[size - 1];
    }

    @Override
    public void remove(int index) {

        Object[] temp = new Object[element_data.length];

        for (int i = 0; i < index; i++) {
            temp[i] = element_data[i];
        }

        for (int i = index; i < size - 1; i++) {
            temp[i] = element_data[i + 1];
        }
        size--;
        element_data = temp;

    }

    @Override
    public void removeFirst() {
        Object[] temp = new Object[size - 1];

        for (int i = 0; i < size - 1; i++) {
            temp[i] = element_data[i + 1];
        }
        element_data = temp;
        size--;
    }

    @Override
    public void removeLast() {
        Object[] temp = new Object[size - 1];
        for (int i = 0; i < size - 1; i++) {
            temp[i] = element_data[i];
        }
        element_data = temp;
        size--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - i - 1; j++) {
            }
        }
    }

        @Override
        public int indexOf (Object object){
            for (int i = 0; i < size; i++) {
                if (element_data[i] == object) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf (Object object){
            for (int i = size; i >= 0; i--) {
                if (element_data[i] == object) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public boolean exists (Object object){
            int check = 0;
            for (int i = 0; i < size; i++) {
                if (element_data[i] == object) {
                    check++;
                }

            }
            if (check > 0) {
                return true;
            } else return false;
        }

        @Override
        public Object[] toArray () {
            Object[] temp = new Object[size];
            for (int i = 0; i < size; i++) {
                temp[i] = element_data[i];
            }
            return temp;
        }

        @Override
        public void clear () {
            Object[] temp = new Object[default_capacity];
            element_data = temp;
        }

        @Override
        public int size () {
            return size;
        }

        @Override
        public Iterator<T> iterator () {
            return new MyIterator();
        }

        public class MyIterator implements Iterator<T> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) element_data[index++];
            }
        }

}
