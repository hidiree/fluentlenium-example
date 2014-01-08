import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CalculatorPage;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorBrowserAcceptanceTest extends FluentTest {

    @Page
    private CalculatorPage calcPage;

    @Override
    public WebDriver getDefaultDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        return driver;
    }

    @Before
    public void setUp() throws Exception {
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
