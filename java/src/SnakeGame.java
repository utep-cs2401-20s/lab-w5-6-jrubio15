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
        int [] hold = new int [2];
        hold [0] = x;
        hold [0] = y;
        this.headPosition = hold;
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
            for (int c = 0; c < game[r].length; c++) {
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
                        if ((r + 1) < game.length - 1 && (c + 1) < game.length - 1 ){
                            if(game[r + 1][c + 1]) {
                                neighCount++;
                            }
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
    public int[] findTailRecursive() {
        recursiveChecks++;
        int [] neighbor = new int [2];
        int [] results = {0, 0, 0};
        if((headPosition[0] + 1) < game.length && game[headPosition[0] + 1] [headPosition[1]]){
            neighbor[0] = headPosition[0] + 1;
            neighbor[0] = headPosition[1];
        }
        if((headPosition[0] - 1) < game.length && game[headPosition[0]] [headPosition[1] + 1]){
            neighbor[0] = headPosition[0];
            neighbor[0] = headPosition[1] + 1;
    }
        if((headPosition[0] - 1) < game.length && game[headPosition[0]] [headPosition[1] - 1]){
            neighbor[0] = headPosition[0] - 1;
            neighbor[0] = headPosition[1];
}
        if((headPosition[1]-1)>= 0 && game[headPosition[0]][headPosition[1]-1]) {
            neighbor[0]=headPosition[0];
            neighbor[1]=headPosition[1]-1;
        }
        int [] tail = findTailRecursive(neighbor,headPosition);
        tail[2]++;
        return results;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        recursiveChecks++;
        int [] neighbor = new int [2];
        int [] results = {0,0,0};
        if((currentPosition[0]+1)< game.length && game[currentPosition[0]+1][currentPosition[1]]&&(!(currentPosition[0]+1==previousPosition[0]&&currentPosition[1]==previousPosition[1]))) {
            neighbor[0]=currentPosition[0]+1;
            neighbor[1]=currentPosition[1];
        }
        if((currentPosition[1]+1) < game.length && game[currentPosition[0]][currentPosition[1]+1]&&(!(currentPosition[0]==previousPosition[0]&&currentPosition[1]+1==previousPosition[1]))) {
            neighbor[0]=currentPosition[0];
            neighbor[1]=currentPosition[1]+1;
        }
        if((currentPosition[0]-1) >= 0 && game[currentPosition[0]-1][currentPosition[1]]&&(!(currentPosition[0]-1==previousPosition[0]&&currentPosition[1]==previousPosition[1]))) {
            neighbor[0]=currentPosition[0]-1;
            neighbor[1]=currentPosition[1];
        }
        if((currentPosition[1]-1)>=0&& game[currentPosition[0]][currentPosition[1]-1]&&(!(currentPosition[0]==previousPosition[0]&&currentPosition[1]-1==previousPosition[1]))) {
            neighbor[0]=currentPosition[0];
            neighbor[1]=currentPosition[1]-1;
        }
        int [] tail = findTailRecursive(neighbor,currentPosition);
        tail[2]++;
        return results;
    }

    private void resetCounters() {
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }

    private static int getRecursiveChecks() {
        return exhaustiveChecks;
    }

    private static int getExhaustiveChecks() {
        return recursiveChecks;
    }
}
