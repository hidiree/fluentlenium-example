import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorBrowserRuleAcceptanceTest {

    @Rule
    public FluentLeniumDriver driver = new FluentLeniumDriver(FluentLeniumDriver.Driver.CHROME);

    private CalculatorPage calcPage;

    @Before
    public void setUp() throws Exception {
        calcPage = driver.createPage(CalculatorPage.class);
        calcPage.go();
    }

    @Test
    public void _1_plus_2_equal_3() throws Exception {
        calcPage.fillAddValue(1, 2).send();

        assertThat(calcPage.result()).isEqualTo(3);
    }

    @Test
    public void _10_plus_20_equal_30() throws Exception {
        calcPage.fillAddValue(10, 20).send();

        assertThat(calcPage.result()).isEqualTo(30);
    }

    @Test
    public void _3_minus_2_equal_1() throws Exception {
        calcPage.fillSubtractValue(3, 2).send();

        assertThat(calcPage.result()).isEqualTo(1);
    }

    @Test
    public void _30_minus_20_equal_1() throws Exception {
        calcPage.fillSubtractValue(30, 20).send();

        assertThat(calcPage.result()).isEqualTo(10);
    }
}
