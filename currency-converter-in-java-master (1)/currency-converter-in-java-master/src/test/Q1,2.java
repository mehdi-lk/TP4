import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CurrencyConversionTests {

    private ArrayList<Currency> currencies;

    @BeforeEach
    void setUp() {
        currencies = Currency.init();
    }

    @Test
    public void testValidConversion() {
        double exchangeValue = currencies.get(0).getExchangeValues().get("EUR");
        double convertedAmount = Currency.convert(100.0, exchangeValue);
        assertTrue(convertedAmount >= 0 && convertedAmount <= 1000000);
    }

    @Test
    public void testConversionWithInvalidAmount() {
        double exchangeValue = currencies.get(0).getExchangeValues().get("EUR");

        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(-100.0, exchangeValue);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(1000001.0, exchangeValue);
        });
    }

    @Test
    public void testBoundaryValues() {
        double exchangeValue = currencies.get(0).getExchangeValues().get("EUR");

        assertEquals(0, Currency.convert(0, exchangeValue));
        assertTrue(Currency.convert(1000000, exchangeValue) > 0);
    }
}
