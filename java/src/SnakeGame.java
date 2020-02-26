public class SnakeGame {
    // Attributes
    private boolean[][] game;
    private int headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    //Constructors
    public SnakeGame(){
        boolean [][] emptyBoard = {};
    }
    public SnakeGame(boolean[][] board, int x, int y){
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board.length; j++){
                game[i][j] = board[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    // Methods
    public int neighbors(int x, int y){
        int neighCount = 0;
        if(game[x +1]{y}){
            neighCount++;
            boolean num = game [x + 1][y];
        }
        if (game[x - 1][y]){
            neighCount++;
            boolean num = game[x - 1][y];
        }
        if(game[x][y + 1]){
            neighCount++;
            boolean num = game[x][y + 1];
        }
        if(game[x][y - 1]){
            neighCount++;
            boolean num = game[x][y - 1];
        }
    }
}


