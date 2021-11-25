package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private WebElement buttonLoginAccount;
    @FindBy(xpath = "//*[@id=\"user_info_acc\"]/span[1]")
    private WebElement loginSuccess;

    public LoginUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAccount(String email, String password){
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonLoginAccount.click();
    }
    public String loginSuccessful() {
        return loginSuccess.getText();
    }
}
