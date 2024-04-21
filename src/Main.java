import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] b = new int[20];
        for(int i=0;i<20;i++){
            b[i]=i;
        }
        for(int i=0;i<20;i++){
            arr.add(b[i]);
        }
        arr.addLast(999);
        arr.addFirst(-84124);
        System.out.println(arr.get(6));
        System.out.println(arr.getFirst());
        System.out.println(arr.getLast());
        arr.remove(7);
        System.out.println(arr.get(7));
        arr.removeFirst();
        arr.removeLast();

        System.out.println(arr.getFirst());
        System.out.println(arr.getLast());
        arr.sort();
        for(Integer elem : arr){
            System.out.println(elem);
        }
        System.out.println(arr.indexOf(13));
        System.out.println(arr.exists(200));
        System.out.println(arr.size());
        System.out.println(Arrays.toString(arr.toArray()));


//        int a = in.nextInt();
//        int b = in.nextInt();
//
//        if((a <= b) == false){
//            System.out.println(false);
//        }
//        else
//            System.out.println(true);

    }


}