import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test(expected = AssertionError.class)
    public void testExample() throws Exception {
        assertEquals(Integer.MIN_VALUE, Integer.MIN_VALUE + 1);
    }
}
