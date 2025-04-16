
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", pilih posisi (1-9): ");
            int move = scanner.nextInt();

            if (!placeMark(move)) {
                System.out.println("Posisi sudah diisi! Coba lagi.");
                continue;
            }

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " menang! 🎉");
                gameEnded = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("Seri! Tidak ada pemenang.");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
        System.out.println();
    }

    static boolean placeMark(int position) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == (char)(position + '0')) {
                    board[i][j] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer &&
                 board[i][1] == currentPlayer &&
                 board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer &&
                 board[1][i] == currentPlayer &&
                 board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer &&
             board[1][1] == currentPlayer &&
             board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer &&
             board[1][1] == currentPlayer &&
             board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
