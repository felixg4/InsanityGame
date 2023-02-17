import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board game = new Board();
        while (!game.gameOver()) {
            System.out.print("Player 1, which index peg would you like to move?");
            int move = scan.nextInt();
            while (move < 0 && move > 9 && game.getPeg(move).isRed()) {
                System.out.print("Player 1, which index peg would you like to move?");
                move = scan.nextInt();
            }
            game.makeMove(move);
            if (game.gameOver()) return;
            System.out.println("Player 2, which index peg would you like to move?");
            move = scan.nextInt();
            while (move < 0 && move > 9 && game.getPeg(move).isBlue()) {
                System.out.print("Player 2, which index peg would you like to move?");
                move = scan.nextInt();
            }
            game.makeMove(move);
        }
    }
}
