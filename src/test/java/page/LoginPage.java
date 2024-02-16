package page;
import driver.DriverSingleton;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    public LoginPage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }

    public MainPage login(User user) {
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        logger.info("Login performed");
        MainPage mainPage = new MainPage();
        mainPage.setUsername(user.getUsername());

        return mainPage;
    }
}
