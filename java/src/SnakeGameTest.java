//Javier Rubio
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SnakeGameTest {
    @Test
    public void testExhaustive(){
        boolean[][] round = {
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, true, true, true, true},
                {false, false, false, false, false}};
        SnakeGame sg = new SnakeGame(round, 1, 3);
        int[] result = sg.findTailExhaustive();
        int[] rtrn = new int[3];
        rtrn[0] = 5;
        rtrn[1] = 4;
        rtrn[2] = 10;
        assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testExhaustive2() {
    	boolean[][] gb = {
    		{true, true, true},
    		{false, false, false},
    		{false, false, false}};
    	SnakeGame sg = new SnakeGame(gb, 0, 0);
    	int[] result = sg.findTailExhaustive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 0;
    	rtrn[1] = 2;
    	rtrn[2] = 3;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testExhaustive3() {
    	boolean[][] gb = {
    		{true, false, false},
    		{true, false, false},
    		{true, false, false}};
    	SnakeGame sg = new SnakeGame(gb, 0, 0);
    	int[] result = sg.findTailExhaustive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 2;
    	rtrn[1] = 0;
    	rtrn[2] = 3;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testExhaustive4() {
    	boolean[][] gb = {
    		{true, false, false},
    		{true, true, false},
    		{false, false, false}};
    	SnakeGame sg = new SnakeGame(gb, 0, 0);
    	int[] result = sg.findTailExhaustive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 1;
    	rtrn[1] = 1;
    	rtrn[2] = 3;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testExhaustive5() {
    	boolean[][] gb = {
    		{false, true, true},
    		{false, true, false},
    		{false, true, true}};
    	SnakeGame sg = new SnakeGame(gb, 0, 2);
    	int[] result = sg.findTailExhaustive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 2;
    	rtrn[1] = 2;
    	rtrn[2] = 5;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void findTailRecursive() {
    	boolean[][] round = {
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, true, true, true, true},
                {false, false, false, false, false}};
        SnakeGame sg = new SnakeGame(round, 1, 3);
        int[] result = sg.findTailRecursive();
        int[] rtrn = new int[3];
        rtrn[0] = 5;
        rtrn[1] = 4;
        rtrn[2] = 10;
        assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testRecursive2() {
    	boolean[][] gb = {
    		{true, true, true},
    		{false, false, false},
    		{false, false, false}};
    	SnakeGame sg = new SnakeGame(gb, 0, 0);
    	int[] result = sg.findTailRecursive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 0;
    	rtrn[1] = 2;
    	rtrn[2] = 3;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testRecursive3() {
    	boolean[][] gb = {
    		{true, false, false},
    		{true, false, false},
    		{true, false, false}};
    	SnakeGame sg = new SnakeGame(gb, 0, 0);
    	int[] result = sg.findTailRecursive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 2;
    	rtrn[1] = 0;
    	rtrn[2] = 3;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testRecursive4() {
    	boolean[][] gb = {
    		{true, false, false},
    		{true, true, false},
    		{false, false, false}};
    	SnakeGame sg = new SnakeGame(gb, 0, 0);
    	int[] result = sg.findTailRecursive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 1;
    	rtrn[1] = 1;
    	rtrn[2] = 3;
    	assertArrayEquals(rtrn, result);
    }
    
    @Test
    public void testRecursive5() {
    	boolean[][] gb = {
    		{false, true, true},
    		{false, true, false},
    		{false, true, true}};
    	SnakeGame sg = new SnakeGame(gb, 0, 2);
    	int[] result = sg.findTailRecursive();
    	int[] rtrn = new int[3];
    	rtrn[0] = 2;
    	rtrn[1] = 2;
    	rtrn[2] = 5;
    	assertArrayEquals(rtrn, result);
    }
    //public int[] findTailRecursive();
}