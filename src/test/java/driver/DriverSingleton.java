package driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    private DriverSingleton(){}

    public static synchronized WebDriver getDriver(){
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver webDriver = new ChromeDriver();
            driver.set(webDriver);
          //  webDriver.navigate().to("https://www.saucedemo.com/");
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

