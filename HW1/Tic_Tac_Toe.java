
// Course: CMPE 131
// Team: Denim
// HW 1: Tic-Tac-Toe
// Date: 03/24/2024

import java.util.*;

class Tic_Tac_Toe {
    char arr[][];
    boolean R_DIAGONAL;
    boolean L_DIAGONAL;
    boolean VERTICAL;
    boolean HORIZONTAL;
    String V_LOCATION;
    String H_LOCATION;
    char Tic;
    char WINNER;
    int SIZE;
    char PLAYER_1;
    char PLAYER_2;

    private Tic_Tac_Toe() {
        arr = new char[3][3];
        R_DIAGONAL = false;
        L_DIAGONAL = false;
        VERTICAL = false;
        HORIZONTAL = false;
        V_LOCATION = " ";
        H_LOCATION = " ";
        Tic = 'O';
        WINNER = ' ';
        SIZE = 3;
        PLAYER_1 = 'O';
        PLAYER_2 = 'X';
    }

    private Tic_Tac_Toe(int size) {
        arr = new char[size][size];
        R_DIAGONAL = false;
        L_DIAGONAL = false;
        VERTICAL = false;
        HORIZONTAL = false;
        V_LOCATION = " ";
        H_LOCATION = " ";
        Tic = 'O';
        WINNER = ' ';
        SIZE = size;
        PLAYER_1 = 'O';
        PLAYER_2 = 'X';
    }

    private Tic_Tac_Toe(int size, char player) {
        arr = new char[size][size];
        R_DIAGONAL = false;
        L_DIAGONAL = false;
        VERTICAL = false;
        HORIZONTAL = false;
        V_LOCATION = " ";
        H_LOCATION = " ";
        Tic = player;
        WINNER = ' ';
        SIZE = size;
        PLAYER_1 = 'O';
        PLAYER_2 = 'X';
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("_ | _ | _");
            System.out.println();
        }
    }

    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] == '\u0000')
                    System.out.print("   ");
                else
                    System.out.print(" " + arr[i][j] + " ");
                if (j < SIZE - 1)
                    System.out.print(" | ");

            }
            System.out.println();
            for (int k = 0; k < SIZE; k++) {
                System.out.print("_____");
            }
            System.out.println();
        }
    }

    public void inserElements(String row, String column, char t) {
        int rowNum = Character.getNumericValue(row.charAt(2));
        int colNum = Character.getNumericValue(column.charAt(2));
        Tic = t;

        arr[rowNum - 1][colNum - 1] = Tic;
    }

    public boolean checkHorizontal() {
        int counter;
        char compareTic;

        for (int i = 0; i < SIZE; i++) {
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] == Tic) {
                    counter++;
                }
            }
            if (counter == SIZE) {
                WINNER = Tic;
                HORIZONTAL = true;
                return true;
            }
        }
        return false;
    }

    public boolean checkVertical() {
        int counter;
        char compareTic;

        for (int i = 0; i < SIZE; i++) {
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (arr[j][i] == Tic) {
                    counter++;
                }
            }
            if (counter == SIZE) {
                WINNER = Tic;
                VERTICAL = true;
                return true;
            }
        }
        return false;
    }

    public boolean check_L_Diagnol() {
        int counter = 0;
        char compareTic = arr[0][0];
        if (Tic == compareTic) {
            for (int i = 0; i < SIZE; i++) {
                if (arr[i][i] == compareTic) {
                    counter++;
                }
            }
            if (counter == SIZE) {
                WINNER = compareTic;
                L_DIAGONAL = true;
            }
        }
        return L_DIAGONAL;
    }

    public boolean check_R_Diagnol() {
        int counter = 0;
        char compareTic = arr[SIZE - 1][0];
        if (Tic == compareTic) {
            for (int i = 0; i < SIZE; i++) {
                if (arr[i][SIZE - 1 - i] == compareTic) {
                    counter++;
                }
            }
            if (counter == SIZE) {
                WINNER = compareTic;
                R_DIAGONAL = true;
            }
        }
        return R_DIAGONAL;
    }

    public String checkInput() {
        Scanner in = new Scanner(System.in);
        String input = "";
        char validInputArr[] = { 'R', 'C' };
        char location;
        char index;
        boolean check = true;

        while (check) {
            try {
                input = in.nextLine();
                location = Character.toUpperCase(input.charAt(0));
                index = input.charAt(2);

                if ((validInputArr[0] == location || validInputArr[1] == location) &&
                        (index >= '1' && index <= (char) (SIZE + '0'))) {
                    check = false;
                } else {
                    System.out.println(
                            "Invalid input. Please enter a valid input (e.g., R 1 or C 2) within " + SIZE + " :");
                }
            } catch (Exception e) {
                System.out
                        .println("Invalid input format. Please enter a valid input (e.g., R 1 or C 2) " + SIZE + " :");
            }

        }

        return input;

    }

    public boolean checkLocation(String row, String column) {
        int rowNum = Character.getNumericValue(row.charAt(2));
        int colNum = Character.getNumericValue(column.charAt(2));

        if (arr[rowNum - 1][colNum - 1] != '\u0000') {
            System.out.println("The selected location is already occupied. Please choose another location.");
            return false;
        }

        return true;
    }

    public int inputUser() {
        Scanner in = new Scanner(System.in);
        int input = 0;
        boolean check = true;
        while (check) {
            if (in.hasNextInt()) {
                input = in.nextInt();
                if (input > 0 && input <= SIZE) {
                    check = false;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + SIZE + ":");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number:");
                in.next(); // consume invalid input
            }
        }
        return input;
    }

    public void restGame() {
        arr = new char[SIZE][SIZE];
        R_DIAGONAL = false;
        L_DIAGONAL = false;
        VERTICAL = false;
        HORIZONTAL = false;
        V_LOCATION = " ";
        H_LOCATION = " ";
        Tic = 'O';
        WINNER = ' ';
        display();
    }

    public void checkWinner() {
        if (checkVertical() || check_R_Diagnol() || check_L_Diagnol() || checkHorizontal()) {
            System.out.println("The Winner is: " + WINNER);
            if (HORIZONTAL)
                System.out.println("The Winner won by: Horixontal Match");
            else if (VERTICAL)
                System.out.println("The Winner won by: Vertical Match");
            else if (R_DIAGONAL)
                System.out.println("The Winner won by: Right Diagonal Match ");
            else if (L_DIAGONAL)
                System.out.println("The Winner won by: Left Diagonal Match ");
        }

    }

    public void takeInput() {
        Scanner in = new Scanner(System.in);
        String inputPlayerRow = "";
        String inputPlayerCol = "";

        boolean location = true;
        while (location) {

            System.out.println("Enter your Row");
            inputPlayerRow = checkInput();
            System.out.println("Enter your Column");
            inputPlayerCol = checkInput();
            if (checkLocation(inputPlayerRow, inputPlayerCol))
                location = false;
        }
        inserElements(inputPlayerRow, inputPlayerCol, Tic);
        checkWinner();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] == '\u0000') {
                    return false; // Found an empty cell, board is not full
                }
            }
        }
        return true; // No empty cells found, board is full
    }

    public void playTheGame() {
        Scanner in = new Scanner(System.in);
        this.display();
        boolean continueGame = true;

        while (WINNER == ' ') {
            if (!isBoardFull()) {
                Tic = PLAYER_1;
                System.out.println("Player 1:");
                takeInput();
                displayBoard();
            }
            if (!isBoardFull()) {

                if (WINNER == ' ') {

                    System.out.println("Player 2:");
                    Tic = PLAYER_2;
                    takeInput();
                    displayBoard();
                }
            }
            if (WINNER != ' ' || isBoardFull()) {
                System.out.println("Do you want to play Tic-Tac-Toe again?\n" +
                        "Enter 'Y' to continue or 'N' to discontinue the game.");

                while (continueGame) {
                    String playTheGameAgain = in.nextLine();
                    if (playTheGameAgain.equalsIgnoreCase("Y")) {
                        restGame();
                        continueGame = false;
                    } else if (playTheGameAgain.equalsIgnoreCase("N")) {
                        System.out.println("Thank you for playing Tic-Tac-Toe. Have a nice day!");
                        continueGame = false;
                    } else {
                        System.out.println("Please enter a valid input (Y/N)");
                    }
                }
            }
            continueGame = true;
        }
    }

    public static void main(String[] args) {
        char Player1 = 'O';
        char Player2 = 'X';
        Tic_Tac_Toe playGame = new Tic_Tac_Toe();
        System.out.println("Welcome to the Tic-Tac-Toe Game!");
        System.out.println("The rules of the game are:\n" +
                "1. Both the players will get one chance in each round.\n" +
                "2. The players have to enter rows and columns in this format:\n" +
                "   For Row: R 2 (any number within the limits) and for Column: C 3 (any number within the limits)\n" +
                "3. If the Tic matched diagonally, left or right, vertically or horizontally,\n" +
                "   that will be the winner.\n" +
                "4. You can also replay the game at any point by resetting the game.");

        System.out.println("Player 1 is: " + Player1);
        System.out.println("Player 2 is: " + Player2);
        System.out.println("All the best players!");
        playGame.playTheGame();
    }
}
