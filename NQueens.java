public class NQueens {

    static int N = 4;
    static int[][] board = new int[N][N];

    // Check if queen can be placed safely
    static boolean isSafe(int row, int col) {

        // Check same column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Place queens row by row
    static boolean solve(int row) {

        // All queens placed
        if (row == N)
            return true;

        // Try every column in current row
        for (int col = 0; col < N; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                if (solve(row + 1))
                    return true;

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // First queen is already placed at (0, 1)
        board[0][1] = 1;

        if (solve(1)) {
            System.out.println("Solution:");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}