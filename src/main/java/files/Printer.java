package files;

import java.util.Scanner;

public class Printer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Printer() {}


    public void printMatrix(int[][] matrix)
    {

        for(int i = 0;i <=4;i++) {
            System.out.print(i+" ");
        }
        System.out.println(" ");
        int c=1;
        for(int i = 0;i <4;i++) {
            System.out.print( ANSI_RESET+c+" "+ANSI_GREEN);
            for (int j = 0; j < 4; j++) {
                System.out.print(ANSI_GREEN+matrix[i][j]+" ");
            }
            c++;
            System.out.println("");
        }
        System.out.print(ANSI_RESET);
    }
}
