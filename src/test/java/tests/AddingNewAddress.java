package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginAndBookPage;

import java.util.concurrent.TimeUnit;

public class AddingNewAddress {
    private WebDriver driver;

    @Given("zalogowany na coderslab w zakladce dodaj adres")
    public void goingToMyAccountPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }
    @When("dodanie nowego adresu")
    public void addingNewAddress(){
        LoginAndBookPage login = new LoginAndBookPage(driver);
        login.loginUser("test-23.11.2021-08.39.18@gmail.com","1234qwerty");
        driver.get("https://hotel-testlab.coderslab.pl/en/address");
        LoginAndBookPage address = new LoginAndBookPage(driver);
        address.addNewAddress("Ogarna 6", "80-353","Gdańsk", "1122334455", "adres domowy");
    }
    @Then("wyswietlenie wiadomosci o dodaniu adresu")
    public void checkingIfAddressAdded() {
        LoginAndBookPage address = new LoginAndBookPage(driver);
        Assert.assertEquals("Your addresses are listed below.", address.addressAddedConfirmation());
    }
}
