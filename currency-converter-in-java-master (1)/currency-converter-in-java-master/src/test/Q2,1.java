import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class MainWindowWhiteBoxTests {

    @Test
    void testWithValidCurrencies() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("US Dollar", "Euro", currencies, 100.0);
        assertTrue(result > 0, "Conversion devrait réussir avec des devises valides.");
    }

    @Test
    void testWithInvalidSecondCurrency() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("US Dollar", "Invalid", currencies, 100.0);
        assertEquals(0.0, result, "Conversion devrait échouer avec une deuxième devise invalide.");
    }

    @Test
    void testWithInvalidFirstCurrency() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("Invalid", "Euro", currencies, 100.0);
        assertEquals(0.0, result, "Conversion devrait échouer avec une première devise invalide.");
    }

    @Test
    void testWithZeroAmount() {
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("US Dollar", "Euro", currencies, 0.0);
        assertEquals(0.0, result, "Conversion avec montant zéro devrait donner zéro.");
    }
}
