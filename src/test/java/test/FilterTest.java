package test;
import driver.DriverSingleton;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import service.TestDataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
public class FilterTest extends Conditions {
    private final Logger logger = LogManager.getLogger(FilterTest.class);

    @Test
   public void successfulLogin() {
        TestDataReader reader = new TestDataReader();
        String usernameOne = reader.getProperty("usernameTwo");
        String passwordOne = reader.getProperty("passwordTwo");
        User testUserOne = new User(usernameOne, passwordOne);
        new LoginPage()
                .login(testUserOne);
        String giveCurrentUrl = DriverSingleton.getDriver().getCurrentUrl();
        if (giveCurrentUrl.contains("inventory.html")) {
            logger.info("User successfully logged in.");
        } else {
            logger.error("Epic sadface: Username and password do not match any user in this service");
        }
    }

    @Test
    public void filterTest() {
        try {
            TestDataReader readerTwo = new TestDataReader();
        String username = readerTwo.getProperty("usernameOne");
        String password = readerTwo.getProperty("passwordOne");
        User testUserTwo = new User(username, password);
        new LoginPage()
                .login(testUserTwo)
                 .selectFilter(MainPage.FilterOption.az);
            List<String> actualList = new MainPage().getItemsList();
            List<String> expectedList = new ArrayList<>(actualList);
            Collections.sort(expectedList);
            assertEquals(actualList, expectedList, "Not all categories are sorted");
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            throw e;
        }
    }
}
