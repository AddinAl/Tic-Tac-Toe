import java.util.Scanner;

public class TicTacToe {
    static char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char currentPlayer = 'X';

    static void displayBoard() {
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + board[i] + (i % 3 == 2 ? "\n" : " |"));
            if (i % 3 == 2 && i < 6) System.out.println("---|---|---");
        }
    }

    static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i + 3] && board[i] == board[i + 6]) return true;
            if (board[3 * i] == board[3 * i + 1] && board[3 * i] == board[3 * i + 2]) return true;
        }
        return (board[0] == board[4] && board[0] == board[8]) || (board[2] == board[4] && board[2] == board[6]);
    }

    static boolean checkDraw() {
        for (char c : board) if (c != 'X' && c != 'O') return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayBoard();
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = sc.nextInt();

            if (move < 1 || move > 9 || board[move - 1] == 'X' || board[move - 1] == 'O') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[move - 1] = currentPlayer;

            if (checkWinner()) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (checkDraw()) {
                displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        sc.close();
    }
}