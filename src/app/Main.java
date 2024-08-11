package app;

public class Main {

    public static void main(String[] args) {

        int [][] matrix = {
                {40, 34, 4, 7},
                {8, 5, 22, 16},
                {31, 6, 27, 9},
                {44, 7, 39, 8}
        };

        System.out.println("Матриця 4x4: ");

        for (int[] arrayOut : matrix){
            for (int arrayIn : arrayOut){
                System.out.print(arrayIn + " \t");
            }
            System.out.println();
        }
    }
}