import java.util.ArrayList;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> arr = new MyLinkedList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.set(3,6);
        arr.remove(3);
        arr.removeLast();
//        arr.addLast(6);
//        arr.addFirst(0);
        //arr.set(2,983);
       // System.out.println(arr.size());
//        for (int i= arr.size()-1;i>=0;i--){
//            System.out.println(arr.get(i));
//        }
        System.out.println(Arrays.toString(arr.toArray()));
    }
}