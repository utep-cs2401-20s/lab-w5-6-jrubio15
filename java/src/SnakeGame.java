//Javier Rubio
public class SnakeGame {
	private boolean gameboard[][];
	private int position[];
	private static int recursiveCounter;
	private static int exhaustiveCounter;
	//Constructor
	public SnakeGame() {
		this.gameboard = new boolean[1][1];
		this.recursiveCounter=0;
		this.exhaustiveCounter=0;
	}
	//Constructor
	public SnakeGame(boolean[][]gameboard,int x,int y) {
		this.gameboard=gameboard;
		int[] hold = new int[2];
		hold[0] = x;
		hold[1] = y;
		this.position = hold;
		this.exhaustiveCounter=0;
		this.recursiveCounter=0;	
	}
	
	
	private static int exhaustiveChecks;
	
	private static int recursiveChecks;
	
	//snakelength counts the length, everytime a cell is true.
	//pos holds the x and y of the tail
	public int[] findTailExhaustive() {
		resetCounters();
        int snakeLength = 0;
        int[] results = {0, 0, 0};
        int[] pos = new int[2];
        //2 for loops, 1 for columns, 1 for rows
        for(int i = 0; i<gameboard.length; i++) {
            for(int j = 0; j<gameboard[i].length; j++) {
                exhaustiveCounter++;
            	if(gameboard[i][j]){
                    snakeLength++;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        //update results and return answer
        results[0] = pos[0];
        results[1] = pos[1];
        results[2] = snakeLength;
        return results;
    }
	
	//this method checks cells above/below and left/right to the head and iterates through until we reach the tail
	public int[] findTailRecursive() {
		resetCounters();
		//the recursive counter counts the length of the snake too
		recursiveCounter++;
		int[] hold = new int[2];
		hold[0] = position[0];
		hold[1] = position[1];
		int[] results = {0, 0, 0};
		int[] holdReturn = new int[2];
		//this if statement checks the cell above our head
		if(hold[0]-1>0) {
			if(gameboard[hold[0]-1][hold[1]]) {
				recursiveCounter++;
				hold[0] -= 1;
				holdReturn = findTailRecursive(hold, position);
			}
		}
		//this if statement check the cell below our head
		if(hold[0]+1<gameboard.length) {
			if(gameboard[hold[0]+1][hold[1]]) {
				recursiveCounter++;
				hold[0] += 1;
				holdReturn = findTailRecursive(hold, position);
			}
		}
		//this if statement checks the cell left to our head
		if(hold[1]-1>0) {
			if(gameboard[hold[0]][hold[1]-1]) {
				recursiveCounter++;
				hold[1]-=1;
				holdReturn = findTailRecursive(hold, position);
			}
		}
		//this if statement checks the cell right to our head
		if(hold[1]+1<gameboard[0].length) {
			if(gameboard[hold[0]][hold[1]+1]) {
				recursiveCounter++;
				hold[1] += 1;
				holdReturn = findTailRecursive(hold, position);
			}
		}
		results[0] = holdReturn[0];
		results[1] = holdReturn[1];
		results[2] = recursiveCounter;
		return results;
	}
	
	//here we do our recursion
	public int[] findTailRecursive(int hold[], int prev[]) {
		//above our head cell
		//counter tracks our length, prev holds our previous cell, and hold is our current cell
		//second if statement checks if we are not comparing our current cell to our previous
		//last if statement checks if our current cell is part of the snake
		if(hold[0]-1>0) {
			if(hold[0]-1 != prev[0] || hold[1] != prev[1]) {
				if(gameboard[hold[0]-1][hold[1]]) {
					recursiveCounter++;
					prev[0] = hold[0];
					prev[1] = hold[1];
					hold[0] -= 1;
					return findTailRecursive(hold, prev);
				}
			}
		}
		//below our head cell
		if(hold[0]+1<gameboard.length) {
			if(hold[0]+1 != prev[0] || hold[1] != prev[1]) {
				if(gameboard[hold[0]+1][hold[1]]) {
					recursiveCounter++;
					prev[0] = hold[0];
					prev[1] = hold[1];
					hold[0] += 1;
					return findTailRecursive(hold, prev);
				}
			}
		}
		//left to our head cell
		if(hold[1]-1>0) {
			if(hold[0] != prev[0] || hold[1]-1 != prev[1]) {
				if(gameboard[hold[0]][hold[1]-1]) {
					recursiveCounter++;
					prev[0] = hold[0];
					prev[1] = hold[1];
					hold[1]-=1;
					return findTailRecursive(hold, position);
				}
			}
		}
		//right to our head cell
		if(hold[1]+1<gameboard[0].length) {
			if(hold[0] != prev[0] || hold[1]+1 != prev[1]) {
				if(gameboard[hold[0]][hold[1]+1]) {
					recursiveCounter++;
					prev[0] = hold[0];
					prev[1] = hold[1];
					hold[1] += 1;
					return findTailRecursive(hold, position);
				}
			}
		}
		//if we have a tail, it would have failed all if cases and it is returned
		return hold;
	}
	
	private void resetCounters() {
		this.exhaustiveCounter=0;
		this.recursiveCounter=0;
	}
	
	private static int getRecursiveChecks() {
		 return exhaustiveCounter;
	}
	
	private static int getExhaustiveChecks() {
		return recursiveCounter;
	}
}