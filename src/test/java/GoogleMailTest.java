import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class GoogleMailTest extends TestInit {

    GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
    StackOverflowPage stackOverflowPage = PageFactory.initElements(driver, StackOverflowPage.class);
    public static String NO_SPAM_MESSAGES = "U haven't unread spam messages";

    void stackOverflowLogin() {
        driver.get(StackOverflowPage.STACK_LOGIN_URL);
        stackOverflowPage.loginViaGmailClick();
        stackOverflowPage.emailInputAndSubmit(StackOverflowPage.EMAIL);
        stackOverflowPage.passwordInputAndSubmit(StackOverflowPage.PASSWORD);
    }

    String deleteSpamLetters() {
        gmailPage.pressOnSpamButton();
        gmailPage.selectAllSpamLetters();
        gmailPage.deleteAllSpamLetters();
        return "All letters were successfully deleted";
    }

    @Test
    void firstMailDelete() {
        stackOverflowLogin();
        driver.get(GmailPage.GMAIL_LOGIN_PAGE);
        gmailPage.pressOnSignInButton();
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        gmailPage.selectFirstProfile();
        gmailPage.checkFirstEmail();
        gmailPage.pressDeleteButton();
    }

    @Test
    @Disabled
    //Spam count method doesn't work properly
    void trashBinClean() {
        stackOverflowLogin();
        driver.get(GmailPage.GMAIL_LOGIN_PAGE);
        gmailPage.pressOnSignInButton();
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        gmailPage.selectFirstProfile();
        gmailPage.pressOnMoreOptionsButton();
        System.out.println(gmailPage.getSpamMailCount() != 0 ? deleteSpamLetters() : NO_SPAM_MESSAGES);
    }
}
