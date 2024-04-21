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
        ArrayList<Integer> a = new ArrayList<>();

        int[] b = new int[37];
        for(int i=1;i<37;i++){
            b[i]=i;
        }
        for(int i=0;i<36;i++){
            arr.add(b[i]);
        }
//        for(int i=0;i<20;i++){
//            System.out.println(arr.get(i));
//        }
        System.out.println(arr.exists(56));
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