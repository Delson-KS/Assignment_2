package asik2;

import asik2.MyArrayList;

public class Queue {
    public static class MyQueue<T extends Comparable<T>> {
        MyArrayList<T> queue = new MyArrayList<>();
        public MyQueue() { // empty constructor
        }
        public T front() {
            return queue.get(0);
        } //return fist element
        public T back() {
            return queue.get(queue.size() - 1);
        } //return last element
        public T dequeue() { // return first element and delete it
            T item = queue.get(0);
            queue.remove(0);
            return item;
        }
        public void enqueue(T item) {
            queue.add(item);
        } // add function
        public boolean isEmpty() { // checking is empty or no
            if(queue.size()==0){
                return true;
            }
            return false;
        }
        public int size() { // return size of queue
            return queue.size();
        }
        public void clear() { // delete all elements
            queue.clear();
        }
    }
}
