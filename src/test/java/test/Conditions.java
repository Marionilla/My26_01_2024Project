package test;
import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import service.TestDataReader;

public class Conditions {
    @BeforeMethod
    public void runUrl() {
        TestDataReader readerNew = new TestDataReader();
       String siteUrl = readerNew.getProperty("url");
        DriverSingleton.getDriver().get(siteUrl);
    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {

        DriverSingleton.closeDriver();

    }
}
