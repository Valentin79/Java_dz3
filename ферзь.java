
public class ферзь {
    public static void main(String[] args) {
        int[][] board = new int[8][8];

        solve(board, 0);
        // Можно вывести так:
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board.length; j++) {
        //         System.out.print("|"+board[j][i]+"|");
        //     }
        //     System.out.println();
        // }

        // А так - типа визуализация =)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 1) {
                    System.out.print("|#|");
                } else {
                    System.out.print("|-|");
                }
            }
            System.out.println();
        }
    }

    public static boolean checPosition(int[][] board, int row, int column) {
        // row
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int[][] board, int column) {
        if (column >= board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (checPosition(board, i, column)) {
                // ставим ферзя
                board[i][column] = 1;
                if (solve(board, column + 1)) {
                    return true;
                }
                board[i][column] = 0;
            }
        }
        return false;
    }

}
