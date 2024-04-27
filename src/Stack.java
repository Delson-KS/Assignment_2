
public class Stack {
    public class MyStack<T extends Comparable<T>> {

        //stack configured/based on Linked list
        private MyLinkedList<T> stack = new MyLinkedList<T>();

        //empty constructor
        public MyStack() {
        }

        //return last inserted data
        public T top() {
            return (T) stack.getLast();
        }

        //return last inserted data and delete it
        public T pop() {
            T item = (T) stack.getLast();
            stack.removeLast();
            return item;
        }

        //insert data
        public void push(T item) {
            stack.addLast(item);
        }

        //function that checking is empty or no
        public boolean isEmpty() {
            if(stack.size()==0){
                return true;
            }
            return false;
        }

        //return size of stack
        public int size() {
            return stack.size();
        }

        //clear whole stack
        public void clear() {
            stack.clear();
        }


    }
}
