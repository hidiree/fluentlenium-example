import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;

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

    @Ignore
    @Test
    public void _3行目のチェックボックスをチェック() throws Exception {
        listPage.check(1);
        assertThat(findFirst("#checkbox3").isSelected()).isEqualTo(true);
    }

    @Test
    public void _3行目のチェックボックスをチェックPageObject() throws Exception {
        listPage.list().row(3).check();

        assertThat(findFirst("#tid\\.3\\.checkbox").isSelected()).isEqualTo(true);

    }

    @Test
    public void 指定のIDを持つ要素が無いことを検証() throws Exception {
        assertThat(find("#xxx").isEmpty()).isEqualTo(true);

    }
}
