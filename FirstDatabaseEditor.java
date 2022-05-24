import java.io.*;
import java.util.Scanner;

public class FirstDatabaseEditor {
      /**
     * main
     * Scans the file into Word and Int Arrays + Loops all the methods/introductory statements together
     * parameter (String[] args)
     * return void 
     */
    public static void main (String [] args) throws Exception {
        Scanner scan = new Scanner(new File("database.txt"));
        int size = 0;
        while (scan.hasNext()) {
            size++;
            scan.next();

        }
        scan = new Scanner(new File("database.txt"));
        int count = 0;
        int count2=0;

        String[ ] Words = new String[size/2];
        int [ ] Ints = new int[size/2];

        scan = new Scanner(new File("database.txt"));
        while (scan.hasNext()) {
            Words[count] = scan.next();
            count++;
            Ints[count2] = scan.nextInt();

            count2++;
        }

        boolean game = true;
        while (game = true) {
            Scanner scan2 = new Scanner(System.in);
            System.out.println("(1)Word Order");
            System.out.println("(2)Number Order");
            System.out.println("(3)Exit");
            int ans = scan2.nextInt();
            if (ans == 1) {
                SortStrings(Words, Ints);
                printOtherA(Words, Ints);
            }
            else if (ans == 2) {
                SortNumbers(Words, Ints);
                printOtherA(Words, Ints);
            }
            else if (ans == 3){

                break;
            }
            else {
                System.out.println("Invalid Input!!! (Type 1 2 or 3 bozo)");
            }
        }
    }

     /**
     * SortStrings
     * Orders word array using insertion sort (and aligns the numbers that correspond)
     * parameter @Words @Ints
     * return void
     */
    public static void SortStrings(String[] Words, int[] Ints) {
        String wordInsertion = "filler";
        int numInsertion = 0;
        for(int i=1;i<Words.length;i++) {
            wordInsertion = Words[i];
            numInsertion = Ints[i];
            for(int j=i-1;j>-1;j--) {
                if(wordInsertion.compareToIgnoreCase(Words[j])<0) {

                    Words[j+1]=Words[j];
                    Ints[j+1]=Ints[j];
                } else {
                    Words[j+1]=wordInsertion;
                    Ints[j+1]=numInsertion;
                    break;
                }
                if(j==0) {
                    Words[0]=wordInsertion;
                    Ints[0]=numInsertion;
                    break;
                }
            }
        }
    }
    
     /**
     * SortNumbers
     * Orders number array using selection sort (and aligns the words that correspond)
     * parameter @Words @Ints
     * return void
     */
    public static void SortNumbers(String[] Words, int[] Ints) {
        int swap = 0;
        int min = 0;
        String otherWord= "filler";
        for(int i=0;i<Ints.length;i++) {
            min = 2147483647;
            for(int j=i;j<Ints.length;j++) {
                if(Ints[j]<min) {
                    min=Ints[j];
                    otherWord = Words[j];
                    swap = j;
                }
            }
            // swap places in the array
            Ints[swap] = Ints[i];
            Words[swap] = Words[i];
            Ints[i] = min;
            Words[i] = otherWord;
        }
    }

    /**
     * printOtherA
     * prints the Words next to their corresponding numbers
     * parameter N/A
     * return void
     */
    
    public static void printOtherA(String[] Words, int[] Ints) {
        //clear();
        for(int i=0;i<Ints.length;i++) {
            System.out.println(Words[i] + " " + Ints[i]);
        }
    }

}
