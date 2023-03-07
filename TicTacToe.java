import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayerMark;

    private static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
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

    private static boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    private static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }

        return false;
    }

    private static void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    private static boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayerMark;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();
        currentPlayerMark = 'X';
        boolean isGameFinished = false;
        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!isGameFinished) {
            System.out.println("Player " + currentPlayerMark + ", enter a row (0, 1, or 2):");
            int row = scanner.nextInt();
            System.out.println("Player " + currentPlayerMark + ", enter a column (0, 1, or 2):");
            int col = scanner.nextInt();

            if (placeMark(row, col)) {
                printBoard();
                if (checkForWin()) {
                    System.out.println("Player " + currentPlayerMark + " wins! Game over.");
                    isGameFinished = true;
                } else if (isBoardFull()) {
                    System.out.println("Tie game! Game over.");
                    isGameFinished = true;
                } else {
                    changePlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }
}
