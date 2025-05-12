import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-5, calculator.add(-2, -3));
        assertEquals(100, calculator.add(50, 50));
    }

    @Test
    void dif() {
        assertEquals(1, calculator.dif(3, 2));
        assertEquals(-1, calculator.dif(2, 3));
        assertEquals(0, calculator.dif(5, 5));
        assertEquals(-10, calculator.dif(-5, 5));
    }

    @Test
    void div() {
        assertEquals(2, calculator.div(4, 2));
        assertEquals(-3, calculator.div(9, -3));
        assertEquals(0, calculator.div(0, 5));

        // Test division by zero
        assertThrows(ArithmeticException.class, () -> calculator.div(10, 0));
    }

    @Test
    void times() {
        assertEquals(6, calculator.times(2, 3));
        assertEquals(0, calculator.times(0, 5));
        assertEquals(-8, calculator.times(2, -4));
        assertEquals(25, calculator.times(-5, -5));
    }

    @Test
    void solver() {
        // Testing the solver method which should return (5+3)*2 - 8/4 = 14
        assertEquals(14, calculator.solver());

        // You could also test with a different implementation if solver() changes
        Calculator customCalc = new Calculator() {
            @Override
            public int solver() {
                return times(add(10, 20), dif(5, 2)); // (10+20)*(5-2) = 90
            }
        };
        assertEquals(90, customCalc.solver());
    }
}