
public class Stack {
    public class MyStack<T extends Comparable<T>> {

        private MyLinkedList<T> stack = new MyLinkedList<T>();

        public MyStack() {
        }

        public T top() {
            return (T) stack.getLast();
        }

        public T pop() {
            T item = (T) stack.getLast();
            stack.removeLast();
            return item;
        }

        public void push(T item) {
            stack.addLast(item);
        }

        public boolean isEmpty() {
            return stack.size() == 0;
        }

        public int size() {
            return stack.size();
        }

        public void clear() {
            stack.clear();
        }


    }
}
