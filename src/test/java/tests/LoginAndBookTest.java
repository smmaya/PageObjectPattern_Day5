package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginAndBookPage;

import java.util.concurrent.TimeUnit;

public class LoginAndBookTest {
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
    public void makeBooking(){
        LoginAndBookPage login = new LoginAndBookPage(driver);
        login.loginUser("test-23.11.2021-08.39.18@gmail.com","1234qwerty");
        LoginAndBookPage book = new LoginAndBookPage(driver);
        book.searchRooms("Poland", "30-11-2021", "10-12-2021");
        LoginAndBookPage chkout = new LoginAndBookPage(driver);
        //chkout.roomCheckout("Ogarna 5", "80-333","Gdańsk", "1122334455", "adres domowy");
        Assert.assertEquals("Your order on MyBooking is complete.", chkout.confirmedBookedMessage());
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
