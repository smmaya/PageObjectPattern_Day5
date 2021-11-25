package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class LoginAndBookPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private WebElement buttonLoginAccount;
    @FindBy(xpath = "//*[@id=\"user_info_acc\"]/span[1]")
    private WebElement loginSuccess;

    @FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
    private WebElement homePage;

    @FindBy(id = "hotel_location")
    private WebElement inputLocation;

    @FindBy(css = "#hotel_cat_name")
    private WebElement categoryName;

    @FindBy(xpath = "//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li")
    private WebElement dropdownValue;

    @FindBy(xpath = "//*[@id=\"check_in_time\"]")
    private WebElement checkInDate;

    @FindBy(xpath = "//*[@id=\"check_out_time\"]")
    private WebElement checkOutDate;

    @FindBy(xpath = "//*[@id=\"search_room_submit\"]")
    private WebElement searchRoomSubmit;

    @FindBy(xpath = "//*[@id=\"category_data_cont\"]/div[3]/div/div[2]/p[1]")
    private WebElement getFocusLowerOnPage;

    @FindBy(xpath = "//*[@id=\"category_data_cont\"]/div[3]/div/div[2]/a")
    private WebElement bookButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/a")
    private WebElement bookButtonToCheckout;

    //ulica
    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement streetName;
    //kod
    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement postalCode;
    //miasto
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityName;
    //telefon
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumber;
    //nazwa adresu
    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement addressRef;
    //zapisz
    @FindBy(xpath = "//*[@id=\"submitAddress\"]")
    private WebElement buttonSave;
    //czy cart jest otwarty
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[6]/div/div/h3")
    private WebElement cartSummary;
    // Assert
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/p[1]")
    private WebElement confirmMessage;

    // checkbox
    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement checkBox;
    // ban wire transfer
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    private WebElement bankWirePayment;
    //confirm payment
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElement confirmPayment;

    public LoginAndBookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String email, String password){
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonLoginAccount.click();
        homePage.click();
    }

    public void searchRooms(String location, String checkIn, String checkOut){
        inputLocation.click();
        inputLocation.clear();
        inputLocation.sendKeys(location);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        categoryName.click();
        dropdownValue.click();
        checkInDate.sendKeys(checkIn);
        checkOutDate.sendKeys(checkOut);
        searchRoomSubmit.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookButton.sendKeys(Keys.ARROW_UP);
        bookButton.click();
        bookButtonToCheckout.click();
        checkBox.click();
        bankWirePayment.click();
        confirmPayment.click();
    }

    public void roomCheckout(String street, String code, String city, String phone, String refName){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        streetName.click();
        streetName.sendKeys(street);
        postalCode.click();
        postalCode.sendKeys(code);
        cityName.click();
        cityName.sendKeys(city);
        phoneNumber.click();
        phoneNumber.sendKeys(phone);
        addressRef.click();
        addressRef.clear();
        addressRef.sendKeys(refName);
        buttonSave.click();
    }

    public String confirmedBookedMessage() {
        return confirmMessage.getText();
    }

}
