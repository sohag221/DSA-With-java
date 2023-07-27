import java.util.Scanner;

public class Selection_Sort {

    public static void selectionSort(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            int smallest = i;      // guess in this position the number is smallest
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[smallest] > ar[j]) {
                    smallest = j;             // in this loop trying to find out ,is there any smallest number?
                }
            }
            int templet = ar[smallest];          // then swap this smallest number in the position firstly
            ar[smallest] = ar[i];
            ar[i] = templet;
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter Array size: ");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = input.nextInt();
        }
        selectionSort(ar);

        for (int i = 0; i < ar.length; i++) {
            System.out.print(" " + ar[i]);
        }
    }
}
