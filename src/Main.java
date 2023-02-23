import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board game = new Board();
        while (!game.gameOver()) {
            System.out.print("Player Red, which index peg would you like to move? ");
            int move = scan.nextInt();
            while (move < 0 || move > 8 || !game.getPeg(move).isRed() || !game.makeMove(move)) {
                System.out.print("Player Red, which index peg would you like to move? ");
                move = scan.nextInt();
            }
            System.out.println(game);
            if (game.gameOver()) return;
            System.out.print("Player Blue, which index peg would you like to move? ");
            move = scan.nextInt();
            while (move < 1 || move > 9 || !game.getPeg(move).isBlue() || !game.makeMove(move)) {
                System.out.print("Player Blue, which index peg would you like to move? ");
                move = scan.nextInt();
            }
            System.out.println(game);
            if (game.gameOver()) return;
        }
        scan.close();
    }
}