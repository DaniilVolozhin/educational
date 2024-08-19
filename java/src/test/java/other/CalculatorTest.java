package other;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void close() {
        calculator = null;
    }

    @Test
    public void whenAddTenToFiveThenResultFifteen() {
        int expected = 15;
        int result = calculator.add(10, 5);
        assertEquals(expected, result);
    }

    @Test
    public void whenAdd5To10ThenResult15() {
        int expected = 15;
        int result = calculator.add("10", "5");
        assertEquals(expected, result);
    }

    @Test
    public void addWhenInputIncorrectValueThenThrowException() {
        assertThrows(NumberFormatException.class, () -> calculator.add("adjfkdj", "5"));
    }

    @Test
    void whenAdd100To50ThenResult150() {
        int expected2 = 150;
        int result2 = calculator.add(100, 50);
        assertEquals(expected2, result2);
    }

    @Test
    void minus10Take5ThenResult5() {
        double expected = 5;
        double result = calculator.minus(10, 5);
        assertEquals(expected, result);
    }

    @Test
    void minus100Take50ThenResult50() {
        double expected2 = 50;
        double result2 = calculator.minus(100, 50);
        assertEquals(expected2, result2);
    }

    @Test
    void multipleDouble100To50ThenResult50() {
        double expected2 = 5000.0;
        double result2 = calculator.multiple(100.0, 50.0);
        assertEquals(expected2, result2);
    }

    @Test
    void multipleDouble10To5ThenResult50() {
        double expected = 50.0;
        double result = calculator.multiple(10.0, 5.0);
        assertEquals(expected, result);
    }

    @Test
    void divideDouble10divide5ThenResult2() {
        double expected = 2.0;
        double result = calculator.divide(10.0, 5.0);
        assertEquals(expected, result);
    }

    @Test
    void divideDouble100divide20ThenResult5() {
        double expected2 = 5.0;
        double result2 = calculator.divide(100.0, 20.0);
        assertEquals(expected2, result2);
    }

    @Test
    void divideString100divide20ThenResult5() {
        double expected2 = 5.0;
        double result2 = calculator.divide("100.0", "20.0");
        assertEquals(expected2, result2);
    }

    @Test
    void divideWhenInputIncorrectStringThenThrowException() {
        assertThrows(NumberFormatException.class, () -> calculator.divide("sdfdj", "5.0"));
    }

    @Test
    void square2ThenResult4() {
        double expected = 4;
        double result = calculator.square(2);
        assertEquals(expected, result);
    }

    @Test
    void square50ThenResult2500() {
        double expected2 = 2500;
        double result2 = calculator.square(50);
        assertEquals(expected2, result2);
    }
}