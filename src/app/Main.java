package app;

public class Main {

    final static int MAGIC = 4;

    public static void main(String[] args) {

        int [][] matrix = {
                {2, 24, 8, 33},
                {31, 7, 18, 26},
                {40, 1, 7, 15},
                {8, 38, 17, 4}
        };

        System.out.println("Матриця 4x4: ");

        for (int[] arrayOut : matrix){
            for (int arrayIn : arrayOut){
                System.out.print(arrayIn + "\t");
            }
            System.out.println();
        }

        int sumEvenRows = 0; //Змінна, яка накопичує суму парних рядків
        int sumOddRows = 0; //Змінна, яка накопичує суму непарних рядків
        int firstEvenRow = 0; //<-індекс рядку в масиві
        int firstOddRow = 1; //<-індекс рядку в масиві
        int secondEvenRow = 2;
        int secondOddRow = 3;

        //Рахуємо суму у парних рядках
        for (int n = 0; n < matrix[firstEvenRow].length; n++) {
            sumEvenRows += matrix[firstEvenRow][n] + matrix[secondEvenRow][n];
        }
        //та непарних рядках
        for (int v = 0; v < matrix[firstOddRow].length; v++) {
            sumOddRows += matrix[firstOddRow][v] + matrix[secondOddRow][v];
        }

        int multiEvenColumns = 1; // Змінна, яка накопичує добуток парних стовбців
        int multiOddColumns = 1; // 1 оскільки множення на 0 завжди буде давати 0
        int firstEvenColumns = 0;
        int secondEvenColumns = 2;
        int firstOddColumns = 1; //<-індекс рядку в масиві
        int secondOddColumns = 3; //<-індекс рядку в масиві

        // Знаходимо добуток парних стовбчиків
        for (int[] rowEven : matrix){
                multiEvenColumns *= rowEven[firstEvenColumns] * rowEven[secondEvenColumns];
        }
        //та непарних стовбчиків
        for (int[] rowOdd : matrix){
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

        for (int i = 0; i < MAGIC; i++){
            //[i][i] оскільки числа головної діагоналі матриці будуть мати індекси [0][0], [1][1] і т.д.
            sumMainDiagonal += matrix[i][i];
            //Побічна діагональ [0] та [4 - 1 - 0], [1][4 - 1 - 1]...
            sumSideDiagonal += matrix[i][MAGIC - 1 - i];
        }
        if (sumMainDiagonal != sumSideDiagonal)
            isMagicSquare = false; // Визначаємо чи рівна сума двох діагоналей

        for (int i = 0; i < MAGIC; i++){
            int totalRows = 0; //<-змінна, яка буде накопичувати суму чисел у рядках
            int totalColumns = 0; //<-змінна, яка буде накопичувати суму чисел у стовбцях

            for (int j = 0; j < MAGIC; j++){
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
