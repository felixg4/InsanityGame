public class Board {
    private Peg[] gameBoard;
    public Board() {
        gameBoard = new Peg[10];
        for (int i = 0; i < 4; i++) gameBoard[i] = new Peg(true);
        for (int i = 6; i < 10; i++) gameBoard[i] = new Peg(false);
    }
    public boolean gameOver() {
        boolean res = true;
        for (int i = 0; i < 4; i++) if (gameBoard[i] == null || gameBoard[i].isRed()) res = false;
        for (int i = 6; i < 10; i++) if (gameBoard[i] == null || !gameBoard[i].isRed()) res = false;
        return res;
    }
    public void makeMove(int idx) {
        return;
    }
}
