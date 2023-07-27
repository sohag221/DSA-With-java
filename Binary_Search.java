import java.util.Scanner;

public class Binary_Search {


    public static int binaryS(int [] ar,int target){
        int start=0;
        int end=ar.length-1;
        while (end>=start){
            int mid=(start+end)/2;
            if (ar[mid]==target){
                System.out.println("found!");
                return mid;
            }
            else if (ar[mid]<target){
                start=mid+1;
            }
            else end=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Enter your demandable value!");
        int k;
        Scanner input = new Scanner(System.in);
        k = input.nextInt();
       int result= binaryS(array, k);
        System.out.println(result);

    }
}
