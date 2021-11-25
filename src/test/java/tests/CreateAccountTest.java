package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;

import java.util.concurrent.TimeUnit;

public class CreateAccountTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void createNewUserTest() {
        CreateAccountPage createPage = new CreateAccountPage(driver);
        createPage.createAccount(CreateAccountPage.fakeEmail());
        Assert.assertEquals("https://hotel-testlab.coderslab.pl/en/login?back=my-account#account-creation", createPage.getLandingURL());
        createPage.registerAccount("Adam", "Adamski", "1234qwerty");
        Assert.assertEquals("Your account has been created.", createPage.registrationSuccessful());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
