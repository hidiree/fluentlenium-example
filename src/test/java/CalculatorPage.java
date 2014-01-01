import org.fluentlenium.core.FluentPage;
import services.Calculator;

public class CalculatorPage extends FluentPage {

    @Override
    public String getUrl() {
        return "http://localhost:8080/devkan-calc/index.html";
    }

    public CalculatorPage fillAddValue(int x1, int x2) {
        return fillCalcValue(x1, x2).selectExpression(ExpressionSelector.ADD);
    }

    public CalculatorPage fillSubtractValue(int x1, int x2) {
        return fillCalcValue(x1, x2).selectExpression(ExpressionSelector.SUBTRACT);
    }

    public CalculatorPage fillCalcValue(int x1, int x2) {
        fill("#x1").with(String.valueOf(x1));
        fill("#x2").with(String.valueOf(x2));
        return this;
    }

    public CalculatorPage selectExpression(ExpressionSelector expression) {
        find("#op").find("option[value='" + expression.getValue() + "']").click();
        return this;
    }

    public void send() {
        click("#send");
    }

    public int result() {
        return Integer.valueOf(find("#result").getText());
    }

    private enum ExpressionSelector {
        ADD("add"), SUBTRACT("subtract");

        private final String value;

        ExpressionSelector(String value) { this.value = value; }

        private String getValue() { return value; }
    }
}
