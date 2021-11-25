package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")
    private WebElement signInLink;
    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement buttonCreateAccount;

    @FindBy(id = "id_gender1")
    private WebElement checkBoxGender;
    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement inputFirstName;
    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement inputLastName;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private WebElement buttonRegisterAccount;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    private WebElement registrationSuccess;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createAccount(String email) {
        signInLink.click();
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        buttonCreateAccount.click();
    }

    public void registerAccount(String firstName, String lastName, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkBoxGender.click();
        inputFirstName.click();
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        inputLastName.click();
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonRegisterAccount.click();
    }

    public String getLandingURL() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }

    public String registrationSuccessful() {
        return registrationSuccess.getText();
    }

    public static String fakeEmail(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy-hh.mm.ss");
        String date = simpleDateFormat.format(new Date());
        return "test-" + date + "@gmail.com";
    }
}
