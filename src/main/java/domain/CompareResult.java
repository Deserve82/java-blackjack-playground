package domain;

public enum CompareResult {
    WIN, LOSE, DRAW;

    public boolean isWin() {
        return this.equals(WIN);
    }

    public boolean isLose() {
        return this.equals(LOSE);
    }

    public boolean isDraw() {
        return this.equals(DRAW);
    }
}
