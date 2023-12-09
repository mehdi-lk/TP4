import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import currencyConverter.Currency;

class CurrencyConvertWhiteBoxTest {

    @Test
    void testNormalConversion() {
        double amount = 100.0;
        double exchangeValue = 1.5;
        double expected = 150.0; // 100.0 * 1.5 arrondi à deux décimales
        double result = Currency.convert(amount, exchangeValue);
        assertEquals(expected, result, "Conversion normale devrait fonctionner.");
    }

    @Test
    void testConversionWithZeroAmount() {
        double amount = 0.0;
        double exchangeValue = 1.5;
        double expected = 0.0;
        double result = Currency.convert(amount, exchangeValue);
        assertEquals(expected, result, "Conversion avec un montant de zéro devrait être zéro.");
    }

    @Test
    void testConversionWithNegativeAmount() {
        double amount = -100.0;
        double exchangeValue = 1.5;
        double expected = -150.0;
        double result = Currency.convert(amount, exchangeValue);
        assertEquals(expected, result, "Conversion avec un montant négatif devrait être négative.");
    }

    @Test
    void testConversionWithZeroExchangeValue() {
        double amount = 100.0;
        double exchangeValue = 0.0;
        double expected = 0.0;
        double result = Currency.convert(amount, exchangeValue);
        assertEquals(expected, result, "Conversion avec un taux de change de zéro devrait être zéro.");
    }

    @Test
    void testConversionWithNegativeExchangeValue() {
        double amount = 100.0;
        double exchangeValue = -1.5;
        double expected = -150.0;
        double result = Currency.convert(amount, exchangeValue);
        assertEquals(expected, result, "Conversion avec un taux de change négatif devrait être négative.");
    }
}
