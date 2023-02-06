public class Peg {
    private boolean isRed;
    public Peg(boolean red) {
        isRed = red;
    }
    public boolean isRed() {
        return isRed;
    }
    public String toString() {
        return isRed ? "" : "";
    }
}
