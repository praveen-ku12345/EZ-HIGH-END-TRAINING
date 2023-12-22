import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the chessboard (N): ");
        int n = scanner.nextInt();

        int[] queens = new int[n];
        solveNQueens(queens, 0, n);

        scanner.close();
    }

    private static void solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            printSolution(queens);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(queens, row, i)) {
                queens[row] = i;
                solveNQueens(queens, row + 1, n);
            }
        }
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(int[] queens) {
        int n = queens.length;
        System.out.println("Solution:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
