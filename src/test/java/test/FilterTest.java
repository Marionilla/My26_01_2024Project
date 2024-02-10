package test;
import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import page.Login;
import model.User;
import page.Main;
import service.TestDataReader;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class FilterTest extends Conditions {
    private Main mainPage;
    private User testUser;
    private Main filterNewTest;
    private final Logger logger = LogManager.getLogger(FilterTest.class);

    @Test
   public void successfulLogin() {
        String usernameOne = TestDataReader.getProperty("usernameOne");
        String passwordTwo = TestDataReader.getProperty("passwordTwo");
        User testUser = new User(usernameOne, passwordTwo);
        mainPage = new Login(driver)
                .openPage()
                .login(testUser);
        String giveCurrentUrl = driver.getCurrentUrl();
        if (giveCurrentUrl.contains("inventory.html")) {
            logger.info("User successfully logged in.");
        } else {
            logger.error("Epic sadface: Username and password do not match any user in this service");
        }
    }

    @Test
    public void filterTest() {
        try {
        String username = TestDataReader.getProperty("username");
        String password = TestDataReader.getProperty("password");
        User testUserTwo = new User(username, password);
      filterNewTest = new Login(driver)
                .openPage()
                .login(testUserTwo);
        //logger.info("!!!!!!!!!!!!!!!!!!!!!!!!.");
       // String loggedInUserName = filterNewTest.getUsername();
            // assertThat(loggedInUserName, is(equalTo(testUserTwo.getUsername())));
        filterNewTest.filterButton();
        boolean allCategoriesMatch = filterNewTest.filterAssertTest();

        assertTrue(allCategoriesMatch, "Not all categories are sorted");
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            throw e;
        } finally {

            DriverSingleton.closeDriver();
        }
    }
}
