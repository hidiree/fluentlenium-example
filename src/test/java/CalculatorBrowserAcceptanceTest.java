import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    public void _1plus2_equal_3() throws Exception {
        calcPage.go();
        calcPage.fillAddValue(1, 2).send();
        assertThat(calcPage.result()).isEqualTo(3);
    }

    @Test
    public void _3minus2_equal_1() throws Exception {
        goTo("http://localhost:8080/devkan-calc/index.html");
        fill("#x1").with("3");
        find("#op").find("option[value='subtract']").click();
        fill("#x2").with("2");
        click("#send");
        assertThat(find("#result").getText()).isEqualTo("1");
    }
}
