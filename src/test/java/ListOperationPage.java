import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

/**
 * Created by hijiri on 2014/01/07.
 */
public class ListOperationPage extends FluentPage{

    @Override
    public String getUrl() {
        return "http://localhost:8080/devkan-calc/listoperation.html";
    }

    public void checkLast(){
        findFirst("table tr:last-child").find("input").click();
    }

    public void check(int no){
        find("#tid").find("tbody").find("tr:nth-child(3)").find("input").click();
    }

    public ListTable list() {
        return new ListTable(findFirst("#tid"));
    }

    public class ListTable {

        private final FluentWebElement element;

        public ListTable(FluentWebElement element) {
            this.element = element;
        }

        public ListRow row(int no) {
            return new ListRow(element.findFirst("tbody tr:nth-child(" + no + "')"));
        }
    }

    public class ListRow {

        private final FluentWebElement element;

        public ListRow(FluentWebElement element) {
            this.element = element;
        }

        public void check() {
            element.find("input").click();
        }
    }
}
