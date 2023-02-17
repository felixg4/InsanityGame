public class Peg {
    private boolean isRed;
    private int idx;
    public Peg(boolean red, int i) {
        isRed = red;
        idx = i;
    }
    public boolean isRed() {
        return isRed;
    }
    public boolean isBlue() {
        return !isRed;
    };
    public String toString() {
        return isRed ? "\033[41m " + idx + " \033[0m" : "\033[44m " + idx + " \033[0m";
    }
}