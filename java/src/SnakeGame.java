public class SnakeGame {
    // Attributes
    private boolean game [][];
    private int headPosition[];
    public static int exhaustiveChecks;
    public static int recursiveChecks;
    public SnakeGame(){
        this.game = new boolean[1][1];
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }
    //Constructors
    public SnakeGame(){
        boolean [][] emptyBoard = {};
    }
    public SnakeGame(boolean[][] game, int x, int y){
        this.game = game;
        headPosition [0] = x;
        headPosition [1]= y;
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }
    // Methods
    public int neigh(int x, int y){
        int neighCount = 0;
        if(game[x + 1][y]){
            neighCount++;
            boolean num = game [x + 1][y];
        }
        if (game[x - 1][y]){
            neighCount++;
            boolean num = game[x -1][y];
        }
        if(game[x][y + 1]){
            neighCount++;
            boolean num = game[x][y + 1];
        }
        if(game[x][y - 1]){
            neighCount++;
            boolean num = game[x][y - 1];
        }
        return neighCount;
    }
    public int[] findTailExhaustive()

}
