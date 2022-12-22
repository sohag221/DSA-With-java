import java.util.Arrays;
import java.util.Scanner;

public class frequency_alphabet {

    public static void main(String[] args) {
        //Take input from the user
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the  string is: ");
        String str = sc.nextLine();
        int[] freq = new int[str.length()];   //Frequency array to store the frequency of each character
        //Convert the given string into character array
        char str1[] = str.toCharArray();
        Arrays.sort(str1);
        for(int i = 0; i <str.length(); i++)
        {
            freq[i] = 1;
            for(int j = i+1; j <str.length(); j++)
            {
                if(str1[i] == str1[j])
                {
                    freq[i]++;

                    //Set str1[j] to 0 to avoid printing visited character
                    str1[j] = '0';
                }
            }
        }
        //Displays the characters and their corresponding frequency
        for(int i = 0; i <freq.length; i++)
        {
            if(str1[i] != ' ' && str1[i] != '0')
                System.out.println(str1[i] + "       " + freq[i]);
        }
    }
}

