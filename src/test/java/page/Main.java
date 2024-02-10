package page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.util.List;

public class Main extends AbstractPage{
    private String username;
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://www.saucedemo.com/inventory.html";
    @FindBy(className = "product_sort_container")
    private WebElement productContainer;
    @FindBy(xpath = "//option[text()='Name (Z to A)']")
    private WebElement optionText;
    @FindBy(xpath = "//option[@ value = 'za']")
    private WebElement optionValue;
    @FindBy(className = "inventory_list")

    private WebElement inventoryList;
    @FindBy(className = "inventory_item")
    private List<WebElement> productElements;
    public Main(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public Main filterButton() {
        productContainer.click();
        optionText.click();
        logger.info("Filter performed");
        return this;

    }
    @Override
    public Main openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean filterAssertTest() {
        boolean allCategoriesMatch = true;
        for (WebElement product : productElements) {
            WebElement categoryElement = optionValue;
            String categoryText = categoryElement.getText();
            if (!categoryText.equals("Name (Z to A)")) {
                allCategoriesMatch = false;
                break;
            }
        }
        return allCategoriesMatch;
    }

}
