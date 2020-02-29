public class SnakeGame {
    // Attributes
    private boolean game[][];
    private int headPosition[];
    public static int exhaustiveChecks;
    public static int recursiveChecks;

    public SnakeGame() {
        this.game = new boolean[1][1];
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }

    //Constructors
    boolean[][] emptyBoard = {};

    public SnakeGame(boolean[][] game, int x, int y) {
        this.game = game;
        headPosition[0] = x;
        headPosition[1] = y;
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }

    // Methods
    public static int getExhaustiveChecks;
    public static int getRecursiveChecks;

    public int[] findTailExhaustive() {
        exhaustiveChecks++;
        int neighCount = 0;
        int[] results = {0, 0, 0};
        for (int r = 0; r < game.length; r++) {            //r is row, c is column
            for (int c = 0; c < game.length; c++) {
                neighCount = 0;
                if (game[r][c]) {
                    if (game[r + 1][c]) {
                        results[2]++;
                        if ((r - 1) >= 0 && (c - 1) >= 0 && game[r - 1][c - 1]) {
                            neighCount++;
                        }
                        if ((r - 1) >= 0 && game[r - 1][c]) {
                            neighCount++;
                        }
                        if ((c - 1) >= 0 && game[r][c - 1]) {
                            neighCount++;
                        }
                        if ((r + 1) < game.length && (c + 1) < game.length && game[r + 1][c + 1]) {
                            neighCount++;
                        }
                        if ((r + 1) < game.length && game[r + 1][c]) {
                            neighCount++;
                        }
                        if ((c - 1) >= 0 && (c + 1) < game.length && game[r + 1][c - 1]) {
                            neighCount++;
                        }
                        if ((r + 1) < game.length && (c - 1) >= 0 && game[r + 1][c - 1]) {
                            neighCount++;
                        }
                    }
                    if ((neighCount == 1) && (!(headPosition[0] == r) && (headPosition[1] == c))) {
                        results[0] = r;
                        results[1] = c;
                    }
                }
            }
        }
        return results;
    }
}
