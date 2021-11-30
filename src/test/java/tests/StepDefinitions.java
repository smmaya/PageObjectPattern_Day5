package tests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    private WebDriver driver;

    @Given("wejscie na strone hotel-testlab.coderslab.pl")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl");
    }

    @When("tworzenie konta nowego użytkownika")
    public void createNewUserTest() {
        CreateAccountPage createPage = new CreateAccountPage(driver);
        createPage.createAccount(CreateAccountPage.fakeEmail());
        createPage.registerAccount("Adam", "Adamski", "1234qwerty");
        Assert.assertEquals("https://hotel-testlab.coderslab.pl/pl/moje-konto", createPage.getLandingURL());
    }

    @Then("przekierowanie do strony profilu i wyświetlenie wiadomości o utworzeniu konta")
    public void accountCreatedSuccessfuly(){
        CreateAccountPage createPage = new CreateAccountPage(driver);
        Assert.assertEquals("Your account has been created.", createPage.registrationSuccessful());
    }

}
