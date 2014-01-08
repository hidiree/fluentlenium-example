import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.FluentPage;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hijiri on 2014/01/01.
 */
public class FluentLeniumDriver extends TestWatcher {

    private FluentTest runner;

    public FluentLeniumDriver(final Driver driver) {
        this.runner = new FluentTest() {
            @Override
            public WebDriver getDefaultDriver() {
                return driver.create();
            }
        };
    }

    @Override
    public Statement apply(Statement base, Description description) {
        Statement statement = base;
        for (Field field : runner.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Rule.class)) {
                try {
                    statement = ((TestRule) field.get(runner)).apply(statement, description);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return statement;
    }

    public <T extends FluentPage> T createPage(Class<T> cls) {
        return runner.createPage(cls);
    }

    public enum Driver {
        CHROME {
            @Override
            WebDriver create() {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
                return driver;
            }
        };

        abstract WebDriver create();
    }
}
