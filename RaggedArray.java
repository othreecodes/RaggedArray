import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author OBI UCHENNA DAVID
 */
public class RaggedArray {

    static Scanner input;
    static int ROW_LENGHT = 0;
    static int COLUMN_LENGHT = 0;
    static int raggedArray[][];
    static int row[] = new int[0];
    static boolean end = false;

    public static void main(String[] args) {
        raggedArray = new int[ROW_LENGHT][];
        //ROW_LENGHT = 0 initially
        input = new Scanner(System.in);
        collectInputForRow();
        double average = computeAverage(raggedArray);

        System.out.println("The Average is " + average);
        int number = count(raggedArray);

        System.out.println("The Total number of elements are " + number);

        System.out.println("Ragged array:");
        printArray();

        System.out.println("Ragged array with zeroed elements");
        zeroed(raggedArray);
    

    }

    static void collectInputForRow() {
        System.out.println("Enter row " + (ROW_LENGHT + 1) + " data:\nor n to save and go to next row and q if done");
        //q or n are the sentinel values
        while (end == false) {
            String reply = input.next();
            if (reply.equals("q")) {
                System.out.println("");
                printArray();
                end = true;
                //end of user input for the array

            } else if (reply.equals("n")) {

                ROW_LENGHT++;
                System.out.println("row " + ROW_LENGHT + " = " + Arrays.toString(row));
                resizeArray(ROW_LENGHT, row);
                COLUMN_LENGHT = 0;
                row = new int[0];
                collectInputForRow();

            } else {
                int number = Integer.parseInt(reply);
                COLUMN_LENGHT++;
                createRow(number, COLUMN_LENGHT);
            }

        }
    }

    static void resizeArray(int ROW_LENGHT, int[] newRow) {
        int arraytemp[][] = raggedArray;
        raggedArray = new int[ROW_LENGHT][];
        System.arraycopy(arraytemp, 0, raggedArray, 0, arraytemp.length);
        raggedArray[arraytemp.length] = newRow;

    }

    private static void createRow(int number, int collenght) {
        int temprow[] = row;
        row = new int[collenght];
        for (int i = 0; i < temprow.length; i++) {
            row[i] = temprow[i];
    
        }
        row[temprow.length] = number;

    }

    private static void printArray() {

        for (int i = 0; i < raggedArray.length; i++) {
            for (int j = 0; j < raggedArray[i].length; j++) {
                System.out.print(raggedArray[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    private static double computeAverage(int[][] raggedArray) {
        int allNumbers = 0;
        int totalElements = 0;
        //using for each loop to loop through the 2D array
        for (int[] raggedArray1 : raggedArray) {
            for (int s : raggedArray1) {
                allNumbers += s;
                totalElements++;
            }
        }
        return allNumbers / totalElements;
    }

    private static int count(int[][] raggedArray) {
        int totalElements = 0;
        //using for each loop to loop through the 2D array
        for (int[] raggedArray1 : raggedArray) {
            for (int s : raggedArray1) {

                totalElements++;
            }
        }
        return totalElements;
    }

    private static void zeroed(int[][] raggedArray) {
        
       for(int i = 0; i<raggedArray.length;i++){
           for (int j = 0; j < raggedArray[i].length; j++) {
               if(i == 0||i==raggedArray.length-1){
                   raggedArray[i][j]=0;
               }
               
           }
       }
       for (int i = 0; i < raggedArray.length; i++) {
            for (int j = 0; j < raggedArray[i].length; j++) {
                System.out.print(raggedArray[i][j] + "\t");
            }
            System.out.println("");
        }
       
    }
}
