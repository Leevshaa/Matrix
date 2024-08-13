package app;

public class Main {

    final static int magic = 4;

    public static void main(String[] args) {

        int [][] matrix = {
                {5, 28, 13, 7},
                {9, 33, 16, 1},
                {2, 28, 34, 8},
                {5, 12, 20, 4}
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

        // За замовчуванням вважаємо, що матриця є магічним квадратом
        boolean isMagicSquare = true;

        int sumMainDiagonal = 0; //<-змінна, яка буде накопичувати суму чисел головної діагоналі
        int sumSideDiagonal = 0; //<-змінна, яка буде накопичувати суму чисел побічної діагоналі

        for (int i = 0; i < magic; i++){
            //[i][i] оскільки числа головної діагоналі матриці будуть мати індекси [0][0], [1][1] і т.д.
            sumMainDiagonal += matrix[i][i];
            //Побічна діагональ [0] та [4 - 1 - 0], [1][4 - 1 - 1]...
            sumSideDiagonal += matrix[i][magic - 1 - i];
        }
        if (sumMainDiagonal != sumSideDiagonal)
            isMagicSquare = false; // Визначаємо чи рівна сума двох діагоналей

        for (int i = 0; i < magic; i++){
            int totalRows = 0; //<-змінна, яка буде накопичувати суму чисел у рядках
            int totalColumns = 0; //<-змінна, яка буде накопичувати суму чисел у стовбцях

            for (int j = 0; j < magic; j++){
                totalRows += matrix[i][j]; // Проходимо по рядках масиву
                totalColumns += matrix[j][i]; // Проходимо по стовбцях масиву
            }
            //Якщо сума рядків, сума стовбців та сума чисел по діагоналі не рівні між собою,
            //то матриця не є магічним квадратом
            if (totalRows != totalColumns || totalColumns != sumMainDiagonal)
                isMagicSquare = false;
        }
        if (isMagicSquare)
            System.out.println("\nВідчувається якась магія, оскільки ваша матриця є магічним квадратом! :)");
        else
            System.out.println("\nМатриця не є магічним квадратом.");
    }
}