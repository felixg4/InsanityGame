public class Board {
    private Peg[] gameBoard;
    public Board() {
        gameBoard = new Peg[10];
        for (int i = 0; i < 4; i++) gameBoard[i] = new Peg(true, i);
        for (int i = 6; i < 10; i++) gameBoard[i] = new Peg(false, i);
        System.out.println(this);
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
        if (gameBoard[idx].isRed()) {
            if (idx == gameBoard.length - 1) {
                System.out.println("can't move that peg, it has reached the end.");
                return false;
            } else if (idx == gameBoard.length - 2 && gameBoard[idx + 1] != null) {
                System.out.println("Cannot jump over the piece in front because it is at the end");
                return false;
            }
            if (gameBoard[idx + 1] == null) {
                gameBoard[idx].setIdx(idx + 1);
                gameBoard[idx + 1] = gameBoard[idx];
                gameBoard[idx] = null;
                System.out.println("move by 1 index successful");
                return true;
            } else if (gameBoard[idx + 2] == null) {
                gameBoard[idx + 2] = gameBoard[idx];
                gameBoard[idx].setIdx(idx + 2);
                gameBoard[idx] = null;
                System.out.println("move by 2 indices successful");
                return true;
            }
        }
        if (gameBoard[idx].isBlue()) {
            if (idx == 0) {
                System.out.println("can't move that peg, it has reached the end.");
                return false;
            } else if (idx == 1 && gameBoard[0] != null) {
                System.out.println("Cannot jump over the piece in front because it is at the end");
                return false;
            }
            if (gameBoard[idx - 1] == null) {
                gameBoard[idx].setIdx(idx - 1);
                gameBoard[idx - 1] = gameBoard[idx];
                gameBoard[idx] = null;
                System.out.println("move by 1 index successful");
                return true;
            } else if (gameBoard[idx - 2] == null) {
                gameBoard[idx - 2] = gameBoard[idx];
                gameBoard[idx].setIdx(idx - 2);
                gameBoard[idx] = null;
                System.out.println("move by 2 indices successful");
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String str = "|";
        for (int i = 0; i < gameBoard.length; i++) str += (gameBoard[i] == null) ? " " + i + " |" : gameBoard[i] + "|";
        return str;
    }
}
