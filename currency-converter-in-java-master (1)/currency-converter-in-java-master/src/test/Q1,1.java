import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class MainWindowBlackBoxTest {

    @Test
    void testSuccessfulConversion() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("US Dollar", "Euro", currencies, 100.0);
        assertTrue(result > 0);
    }

    @Test
    void testConversionWithInvalidCurrency() {
        ArrayList<Currency> currencies = Currency.init();
        double resultWithInvalidSource = MainWindow.convert("Invalid", "Euro", currencies, 100.0);
        assertEquals(0.0, resultWithInvalidSource);

        double resultWithInvalidTarget = MainWindow.convert("US Dollar", "Invalid", currencies, 100.0);
        assertEquals(0.0, resultWithInvalidTarget);
    }

    @Test
    void testConversionWithZeroAmount() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("US Dollar", "Euro", currencies, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConversionWithNegativeAmount() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("US Dollar", "Euro", currencies, -100.0);
        assertEquals(0.0, result);
    }
}
