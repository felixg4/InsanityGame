public class Board {
    private Peg[] gameBoard;
    public Board() {
        gameBoard = new Peg[10];
        for (int i = 0; i < 4; i++) gameBoard[i] = new Peg(true, i);
        for (int i = 6; i < 10; i++) gameBoard[i] = new Peg(false, i);
    }
    public boolean gameOver() {
        boolean res = true;
        for (int i = 0; i < 4; i++) if (gameBoard[i] == null || gameBoard[i].isRed()) res = false;
        for (int i = 6; i < 10; i++) if (gameBoard[i] == null || gameBoard[i].isBlue()) res = false;
        return res;
    }
    public Peg getPeg(int idx) {
        return gameBoard[idx];
    }
    public boolean makeMove(int idx) {
        if (idx < gameBoard.length - 1) {
            System.out.println("can't move that peg, it has reached the end.");
            return false;
        }
        if (gameBoard[idx + 1] == null) {
            gameBoard[idx + 1] = gameBoard[idx];
            gameBoard[idx] = null;
            return true;
        }
        if (idx + 2 < gameBoard.length - 1) {
            System.out.println("That peg cannot jump over the other peg.");
            return false;
        }
        if (gameBoard[idx + 1].isBlue() && gameBoard[idx + 2] == null) {
            gameBoard[idx + 2] = gameBoard[idx];
            gameBoard[idx] = null;
            return true;
        }
        return false;
    }
    public String toString() {
        String str = "|";
        for (int i = 0; i < gameBoard.length; i++) str += (gameBoard[i] == null) ? " " + i + " |" : gameBoard[i] + "|";
        return str;
    }
}
