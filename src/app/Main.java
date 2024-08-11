package app;

public class Main {

    public static void main(String[] args) {

        int [][] matrix = {
                {2, 8, 4, 7},
                {3, 1, 5, 11},
                {9, 10, 12, 13},
                {17, 7, 10, 8}
        };

        System.out.println("Матриця 4x4: ");

        for (int[] arrayOut : matrix){
            for (int arrayIn : arrayOut){
                System.out.print(arrayIn + "\t");
            }
            System.out.println();
        }

        int sumEvenRows = 0;
        int sumOddRows = 0;
        int firstEvenRow = 0;
        int firstOddRow = 1;
        int secondEvenRow = 2;
        int secondOddRow = 3;

        if (matrix[firstEvenRow].length == matrix[secondEvenRow].length){
            for (int i = 0; i < matrix[firstEvenRow].length; i++)
                sumEvenRows += matrix[firstEvenRow][i] + matrix[secondEvenRow][i];
        }

        if (matrix[firstOddRow].length == matrix[secondOddRow].length){
            for (int k = 0; k < matrix[firstOddRow].length; k++)
                sumOddRows += matrix[firstOddRow][k] + matrix[secondOddRow][k];
        }

        int multiEvenColumns = 1;
        int multiOddColumns = 1;
        int firstEvenColumns = 0;
        int secondEvenColumns = 2;
        int firstOddColumns = 1;
        int secondOddColumns = 3;

        for (int[] rowEven : matrix){
            if (firstEvenColumns < rowEven.length && secondEvenColumns < rowEven.length)
                multiEvenColumns *= rowEven[firstEvenColumns] * rowEven[secondEvenColumns];
        }
        for (int[] rowOdd : matrix){
            if (firstOddColumns < rowOdd.length && secondOddColumns < rowOdd.length)
                multiOddColumns *= rowOdd[firstOddColumns] * rowOdd[secondOddColumns];
        }

        System.out.println("\nСума елементів у парних рядках (рядок " + firstEvenRow +
                ", " + secondEvenRow + ") : " + sumEvenRows + "\nСума елементів у непарних рядках (рядок " +
                firstOddRow + ", " + secondOddRow + ") : " + sumOddRows +
                "\nДобуток елементів у парних стовпцях (стовпець " + firstEvenColumns + ", " + secondEvenColumns +
                ") : " + multiEvenColumns + "\nДобуток елементів у непарних стовпцях (стовпець " + firstOddColumns +
                ", " + secondOddColumns + ") : " + multiOddColumns);

        //TODO Магічний квадрат
    }
}