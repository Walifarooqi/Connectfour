
import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int p1Choice; //Player 1 choice of which column they want to place their token in
        int p2Choice; //Player 2 choice of which column they want to place their token in

        int col; //size of column
        int row; //size of row

        char p1Token = 'x'; //Player 1 token
        char p2Token = 'o'; //Player 2 token

        int p1Position; //Tracks Player ones position on the board
        int p2Position; //Tracks player twos position on the board

        boolean letsPlay = true; //While loop to repeat the menu


        System.out.print("What would you like the height of the board to be? ");
        row = scnr.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        col = scnr.nextInt();


        char[][] board = new char[row][col]; //Initialize and declare array
        initializeBoard(board);
        printBoard(board);

        System.out.print("Player 1: " + p1Token + "\n");

        System.out.print("Player 2: " + p2Token + "\n");


        while (letsPlay) { //Start of while loop

            System.out.print("\n" + "Player 1: Which column would you like to choose? ");
            p1Choice = scnr.nextInt();

            p1Position = insertChip(board, p1Choice, p1Token);
            printBoard(board);


            System.out.print("\n" + "Player 2: Which column would you like to choose? ");
            p2Choice = scnr.nextInt();

            p2Position = insertChip(board, p2Choice, p2Token);
            printBoard(board);


            if (p1Position == p1Token) {
                if (checkIfWinner(board, col, row, p1Token)) {
                    System.out.println("Player 1 won the game!");
                    break;
                }
            }

            else if (p2Position == p2Token) {
                if (checkIfWinner(board, col, row, p2Token)) {
                    System.out.println("Player 2 won the game!");
                }
            else {
                    System.out.println("Draw. No one wins");
                }
                break;
            }
        }
    }

    //Method 1: Prints Board//

    public static void printBoard(char[][] array) {

        // Loop through all elements of current row
        // Loop through all rows

        for (char[] chars : array) { //Using an enhanced for loop to print the menu

            // Loop through all elements of current row
            for (char aChar : chars) {

                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Method 2: Intializes all values in the array to '-'//
    public static void initializeBoard(char[][] array) {

        for (char[] chars : array) Arrays.fill(chars, '-');

    }

    //Method 3: replaces '-' on the board with the players token in their column of choice//

    public static int insertChip(char[][] array, int col, char chipType) {

        int chipPosition = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                chipPosition = chipType;
                break;
            }
        }
        return chipPosition;
    }

    //Method 3: Determines the winner of the game
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {

        boolean winner = false;

        //First for-loop checks if the player has connected 4 tokens vertically
        for(row = 0; row < array.length- 3; row++) {

            for (col = 0; col < array[0].length; col++) {

                if (array[row][col] == chipType && array[row + 1][col] == chipType && array[row + 2][col] == chipType && array[row + 3][col] == chipType) { //Checks each successive column in the array

                    if (chipType == 'x') {
                        winner = true;

                    } else if (chipType == 'o') {

                        winner = true;
                    }

                }
            }
        }
        //Second for-loop checks if the player has connected 4 tokens horizontally
        for(row = 0; row < array.length; row++) {

            for (col = 0; col< array[0].length-3; col++) {

                if ((array[row][col] == chipType && array[row][col + 1] == chipType && array[row][col + 2] == chipType && array[row][col + 3] == chipType)) { //Checks each successive column in the array

                    if (chipType == 'x') {
                        winner = true;

                    } else if (chipType == 'o') {
                        winner = true;

                    }
                }
            }

        }

        return winner;

    }
}
















