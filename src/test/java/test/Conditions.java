package test;
import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
public class Conditions {
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {

        DriverSingleton.closeDriver();

    }
}
