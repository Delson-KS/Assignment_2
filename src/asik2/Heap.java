package asik2;

public class Heap {
    public class MyHeap <T extends Comparable<T>>  {

        //heap that based on arraylist
        MyArrayList<T> heap = new MyArrayList<>();
        //constructor without any parameters
        public MyHeap() {
        }

        //clear function
        public void empty() {
            heap.clear();
        }

        //return size(number of element in heap) of heap
        public int size() {
            return heap.size();
        }

        //return maximum data
        public T getMax() {
            return heap.get(0);
        }

        // Extracts the maximum data from the heap.
        public T extractMax() {
            T max = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            heap_sort(0);
            return max;
        }
        //insert data to heap
        public void insert(T item) {
            heap.add(item);
            int i = heap.size() - 1;
            heap_sort(i);
        }
        //sorting function
        private void heap_sort(int i) {
            int left = left_child_of(i);
            int right = right_child_of(i);
            int max = i;
            if (left < heap.size() && heap.get(left).compareTo(heap.get(max)) > 0) {
                max = left;
            }
            if (right < heap.size() && heap.get(right).compareTo(heap.get(max)) > 0) {
                max = right;
            }
            if (max != i) {
                swap(i, max);
                heap_sort(max);
            }
        }

        private void traverse(int i) { // print function
            if (i < heap.size()) {
                System.out.println(heap.get(i));
                traverse(left_child_of(i));
                traverse(right_child_of(i));
            }
        }

        public int left_child_of(int i) {
            return 2 * i;
        } // return left child's index

        public int right_child_of(int i) {
            return 2 * i+1;
        }//return right child's index

        public int parent(int i) {
            return i / 2;
        } //return parent's index

        public void swap(int i, int j) { //swap two element in heap
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

    }
}
