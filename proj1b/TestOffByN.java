import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testOffByN() {
        OffByN test = new OffByN(3);
        assertTrue(test.equalChars('a', 'd'));
        assertTrue(test.equalChars('d', 'a'));
        assertFalse(test.equalChars('a', 'a'));
    }
}
