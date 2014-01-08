import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by hijiri on 2014/01/07.
 */
public class ListOperationTest extends FluentTest {

    @Page
    private ListOperationPage listPage;

    @ClassRule
    public static GlassFishTamer tamer = new GlassFishTamer("devkan-calc", 8080);

    @Override
    public WebDriver getDefaultDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        return driver;
    }

    @Before
    public void setUp() throws Exception {
        listPage.go();
    }

    @Test
    public void _1_plus_2_equal_3() throws Exception {
        listPage.check(1);
        assertThat(findFirst("#checkbox3").isSelected()).isEqualTo(true);
    }
}
