import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(1);
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(4);
        arr.add(9);
        arr.add(-2);
        arr.addFirst(101);

        System.out.println(arr.getFirst());
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