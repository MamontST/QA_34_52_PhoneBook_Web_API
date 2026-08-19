package ui_tests;

import dto.UserLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.UserFactory.positiveLoginUser;
import static utils.UserFactory.positiveUser;

public class LoginTests extends AppManager {
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void goToLoginPage() {
        new HomePage(getDriver()).clickBtnLogin();
        loginPage = new LoginPage(getDriver());
        softAssert = new SoftAssert();

    }

    @Test
    public void loginPositiveTest() {
        UserLombok user = positiveLoginUser();
        loginPage.typeLoginRegistrationForm(user);
        loginPage.clickBtnLogin();
        softAssert.assertTrue(new ContactsPage(getDriver()).validateActiveLink("CONTACTS"));
        softAssert.assertTrue(new ContactsPage(getDriver()).isUrlContainsText("contacts"));
        softAssert.assertAll();
    }

    @Test
    public void loginNegativeEmptyEmailTest() {
        UserLombok user = positiveUser();
        user.setUsername("");
        loginPage.typeLoginRegistrationForm(user);
        loginPage.clickBtnLogin();
        Assert.assertTrue(loginPage.closeAlert().contains("Wrong email or password"));
    }
}
