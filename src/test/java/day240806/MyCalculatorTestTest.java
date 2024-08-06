package day240806;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTestTest {
    @Test
    void add() {
        int expected = 5;
        int actual = MyCalculator.add(2, 3);

        //(你想要的数,实际的数)
        assertEquals(expected, actual);
    }
}