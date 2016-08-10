# RaggedArray
A simple implementation of Ragged Arrays with Java
Perfect for any hackathon question about RaggedArrays
see RaggedArray.java

##TODO
* Add Mean And Standard Deviation
* Print dimention of array

## About
This Example contains snippets that will create a CLI RaggedArray of any 2D size 
and calculate 
* Average
* Total number of elements


## Making use of simple control statements to take in the input
```java
static void collectInputForRow() {
        System.out.println("Enter row " + (ROW_LENGHT + 1) + " data:\nor n for save and go to next row and q if done");
        while (end == false) {
            String reply = input.next();
            if (reply.equals("q")) {
                System.out.println("");
                printArray();
                end = true;

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
```

##The array is then resized according to the input given

```java

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


```

