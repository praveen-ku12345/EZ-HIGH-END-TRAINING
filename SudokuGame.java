import java.util.Scanner;

public class SudokuGame {

    private static int[][] board = new int[9][9];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (!isSudokuSolved()) {
            if (getUserInput()) {
                printBoard();
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("Congratulations! Sudoku solved!");
    }

    private static void initializeBoard() {
       
     }

    private static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row (1-9), column (1-9), and value (1-9) separated by spaces: ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;
        int value = scanner.nextInt();

        if (isValidInput(row, col, value)) {
            board[row][col] = value;
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidInput(int row, int col, int value) {
        return isValidRow(row, value) && isValidColumn(col, value) && isValidBox(row, col, value);
    }

    private static boolean isValidRow(int row, int value) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColumn(int col, int value) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidBox(int startRow, int startCol, int value) {
       
        int boxSize = 3;
        int boxStartRow = startRow - startRow % boxSize;
        int boxStartCol = startCol - startCol % boxSize;

        for (int row = 0; row < boxSize; row++) {
            for (int col = 0; col < boxSize; col++) {
                if (board[row + boxStartRow][col + boxStartCol] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSudokuSolved() {
       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
