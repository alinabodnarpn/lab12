package atm.test;

import com.example.atm.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GreedyATMTest {

    @Test
    public void testMakeChangePossible() {
        GreedyATM atm = new GreedyATM(List.of(50, 20, 10, 5));
        ChangeResult result = atm.makeChange(135);

        assertTrue(result.isPossible());
        assertEquals(2, result.getCoins().get(50));
        assertEquals(1, result.getCoins().get(20));
        assertEquals(1, result.getCoins().get(10));
        assertEquals(1, result.getCoins().get(5));
    }

    @Test
    public void testMakeChangeImpossible() {
        GreedyATM atm = new GreedyATM(List.of(50, 20));
        ChangeResult result = atm.makeChange(35);

        assertFalse(result.isPossible());
    }
}
