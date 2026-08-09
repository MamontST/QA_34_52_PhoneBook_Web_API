package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/h1")
//    @FindBy(xpath = "//h1[text()=' No Contacts here!']")
    WebElement textMessage;

    public boolean validateTextInMessage(String text) {
        return isTextInElementPresent(textMessage, text);
    }
}
