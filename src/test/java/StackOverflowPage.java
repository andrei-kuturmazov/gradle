import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StackOverflowPage {
    WebDriver driver;
    public static String STACK_LOGIN_URL = "https://ru.stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fru.stackoverflow.com%2f";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";

    public StackOverflowPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(@class, 'grid--cell')][1]")
    public WebElement gmailButton;
    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInputField;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInputField;

    public void emailInputAndSubmit(String email) {
        emailInputField.sendKeys(email + Keys.ENTER);
    }

    public void passwordInputAndSubmit(String password) {
        passwordInputField.sendKeys(password + Keys.ENTER);
    }

    public void loginViaGmailClick() {
        gmailButton.click();
    }

}
