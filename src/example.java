import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class example {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList <Integer> list=new ArrayList<>();
        for (int i=0;i<10;i++){
       list.add(input.nextInt());      }
        System.out.println("without sorting!");
        for (int x:list )
             {
            System.out.println(x);
        }
        System.out.println("with sorting!");
        Collections.sort(list);
        for (int x1:list )
        {
            System.out.println(x1);
        }

     /*   System.out.println("In reverse order!");
       Collections.sort(list,Collections.reverseOrder());
        for (int w: list
             ) {
            System.out.println(w);
        }*/
    }
}