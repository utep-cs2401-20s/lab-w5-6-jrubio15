import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SnakeGameTester {
        @Test
        public void testExhaustive(){
            boolean[][] round = {
                    {false, false, false, false, false},
                    {false, true, true, true, false},
                    {false, true, false, false, false},
                    {false, true, false, false, true},
                    {false, true, false, false, true},
                    {false, true, true, true, true},
                    {false, false, false, false, false}};
            SnakeGame sg = new SnakeGame(round, 1, 3);
            int[] result = sg.findTailExhaustive();
            int[] rtrn = new int[3];
            rtrn[0] = 5;
            rtrn[1] = 3;
            rtrn[1] = 3;
            rtrn[2] = 12;
            assertArrayEquals(rtrn, result);
        }
}
