import Commands.Shot;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShotTest_4 {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void before(){
        System.setOut(new PrintStream(output));
    }

    @Parameterized.Parameter(0)
    public String coords;
    @Parameterized.Parameter(1)
    public String result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"0 0 0 ", "MISS"},
                {"-4 0 4", "HIT"},
                {"0 -5 5", "HIT"},
                {"0 0 2", "HIT"},
                {"8 0 8", "HIT"},
                {"4 0 8", "HIT"},
                {"4 8 8", "HIT"},
                {"0 4 4", "HIT"},
                {"-2.1 2 2", "MISS"},
                {"2.1 0.1 4", "MISS"},
                {"2 -2.1 4", "MISS"},
                {"-0.1 -0.1 4", "MISS"},
                {"-1 1 10", "HIT"},
                {"3 3 9", "HIT"},
                {"2 -2 4", "HIT"},
                {"Not a number", "Wrong usage of shot command. Use help for details"},
                {"1 2", "Wrong usage of shot command. Use help for details"},
                {"1 2 3 4", "Wrong usage of shot command. Use help for details"},
                {null, "Wrong usage of shot command. Use help for details"}
        };
        return Arrays.asList(data);
    }

    @org.junit.Test
    public void execute() {
        Shot shot = new Shot();
        shot.setArgs(coords);
        shot.execute();
        assertEquals(result + "\r\n", output.toString());
    }
}