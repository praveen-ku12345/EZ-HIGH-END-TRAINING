import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        printBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter row (0-2) and column (0-2) separated by space (or type 'exit' to end the game): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Game over. Thanks for playing!");
                break;
            }

            if (isValidInput(input)) {
                int row = Character.getNumericValue(input.charAt(0));
                int col = Character.getNumericValue(input.charAt(2));

                if (isCellEmpty(row, col)) {
                    makeMove(row, col);
                    printBoard();

                    if (checkWin()) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isBoardFull()) {
                        System.out.println("It's a tie!");
                        break;
                    }

                    switchPlayer();
                } else {
                    System.out.println("Cell is already taken. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter row and column (e.g., '1 2').");
            }
        }

        scanner.close();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidInput(String input) {
        return input.matches("[0-2] [0-2]");
    }

    private static boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
