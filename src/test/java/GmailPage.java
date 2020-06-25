import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

public class GmailPage {
    WebDriver driver;
    public static String GMAIL_LOGIN_PAGE = "https://www.google.com/intl/ru/gmail/about/#";

    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "(//*[@class='h-c-header__nav-li-link '])[4]")
    public WebElement signInButton;
    @FindBy(xpath = "(//div[@role='link'])[1]")
    public WebElement firstProfileLink;
    @FindBy(xpath = "(//div[@role='checkbox'])[1]")
    public WebElement firstMailCheckbox;
    @FindBy(xpath = "(//div[@role='button'])[11]")
    public WebElement deleteButton;
    @FindBy(xpath = "(//span[@role='button'])[1]")
    public WebElement moreOptionsButton;
    @FindBy(xpath = "//a[contains(@title, 'Спам')]")
    public WebElement spamButton;
    @FindBy(xpath = "//a[contains(@title, 'Спам')]/../following-sibling::div")
    public WebElement spamMailCount;
    @FindBy(xpath = "(//span[@role='checkbox'])[2]")
    public WebElement checkAllSpamLetters;
    @FindBy(xpath = "(//div[@role='button'])[24]")
    public WebElement permanentlyDeleteSpam;

    public void pressOnSignInButton() {
        signInButton.click();
    }

    public void selectFirstProfile() {
        firstProfileLink.click();
    }

    public void checkFirstEmail() {
        firstMailCheckbox.click();
    }

    public void pressDeleteButton() {
        deleteButton.click();
    }

    public void pressOnMoreOptionsButton() {
        moreOptionsButton.click();
    }

    public void pressOnSpamButton() {
        spamButton.click();
    }

    public void selectAllSpamLetters() {
        checkAllSpamLetters.click();
    }

    public void deleteAllSpamLetters() {
        permanentlyDeleteSpam.click();
    }

    public int getSpamMailCount() {
        return Optional.of(spamMailCount.getText())
                .map(Integer::parseInt)
                .orElse(0);
    }
}
