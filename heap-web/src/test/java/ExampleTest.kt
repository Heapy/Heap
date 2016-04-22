import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleTest {

    @Test(expected = java.lang.AssertionError::class)
    @Throws(Exception::class)
    fun `test example`() {
        assertEquals(Integer.MIN_VALUE.toLong(), (Integer.MIN_VALUE + 1).toLong())
    }
}
