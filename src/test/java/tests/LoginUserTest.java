package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginUserPage;

import java.util.concurrent.TimeUnit;

public class LoginUserTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }

    @Test
    public void loginUserTest() {
        LoginUserPage login = new LoginUserPage(driver);
        login.loginAccount("test-23.11.2021-08.39.18@gmail.com","1234qwerty");
        Assert.assertEquals("Adam",login.loginSuccessful());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
