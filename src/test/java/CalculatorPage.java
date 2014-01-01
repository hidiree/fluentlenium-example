import org.fluentlenium.core.FluentPage;
import services.Calculator;

public class CalculatorPage extends FluentPage {

    @Override
    public String getUrl() {
        return "http://localhost:8080/devkan-calc/index.html";
    }

    public CalculatorPage fillAddValue(int x1, int x2) {
        fill("#x1").with(String.valueOf(x1));
        find("#op").find("option[value='add']").click();
        fill("#x2").with(String.valueOf(x2));
        return this;
    }

    public CalculatorPage fillSubtractValue(int x1, int x2) {
        fill("#x1").with(String.valueOf(x1));
        find("#op").find("option[value='subtract']").click();
        fill("#x2").with(String.valueOf(x2));
        return this;
    }

    public void send() {
        click("#send");
    }

    public int result() {
        return Integer.valueOf(find("#result").getText());
    }
}
