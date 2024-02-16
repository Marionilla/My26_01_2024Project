package page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.DriverSingleton;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private String username;
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(className = "product_sort_container")
    private WebElement productContainer;
    @FindBy(className = "inventory_item")
    private List<WebElement> productElements;
    public MainPage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }
    public MainPage selectFilter(FilterOption filterOption) {
        Select filter = new Select(productContainer);

         filter.selectByValue(filterOption.toString());
        logger.info(String.format("Filter '%s' performed", filterOption));
        return this;

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

public List<String> getItemsList() {
        List<String> forReturn = new ArrayList<>();
        for (WebElement product : productElements) {
            forReturn.add(product.getText());
        }
        return forReturn;
}
    public enum FilterOption {
        az,
        za,
        lohi,
        hilo;
    }

}
