package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public Login openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public Main login(User user) {
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        logger.info("Login performed");
        Main mainPage = new Main(driver);
        mainPage.setUsername(user.getUsername());

        return mainPage;
    }
    public void clearField() {
        usernameInput.clear();
        passwordInput.clear();
    }
}
