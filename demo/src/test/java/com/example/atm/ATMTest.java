package com.example.atm;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void testValidWithdraw() {
        ATM atm = new ATM(Arrays.asList(200, 100, 50, 20, 10));

        Result result = atm.withdraw(380);

        assertEquals(1, result.getCoins().get(200));
        assertEquals(1, result.getCoins().get(100));
        assertEquals(1, result.getCoins().get(50));
        assertEquals(1, result.getCoins().get(20));
        assertEquals(1, result.getCoins().get(10));
    }

    @Test
    void testImpossibleWithdraw() {
        ATM atm = new ATM(Arrays.asList(200, 100, 50, 20, 10));

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> atm.withdraw(385)
        );

        assertTrue(ex.getMessage().contains("Cannot produce exact amount"));
    }

    @Test
    void testWithdrawZero() {
        ATM atm = new ATM(Arrays.asList(100, 50));
        Result result = atm.withdraw(0);

        assertTrue(result.getCoins().isEmpty());
    }
}
