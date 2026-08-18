package ui_tests;

import dto.UserLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.UserFactory.positiveLoginUser;
import static utils.UserFactory.positiveUser;

public class LoginTests extends AppManager {
    LoginPage loginPage;

    @BeforeMethod
    public void goToRegistrationPage() {
        new HomePage(getDriver()).clickBtnLogin();
        loginPage = new LoginPage(getDriver());

    }

    @Test
    public void loginPositiveTest() {
        UserLombok user = positiveLoginUser();
        loginPage.typeLoginRegistrationForm(user);
        loginPage.clickBtnLogin();
        Assert.assertTrue(new ContactsPage(getDriver()).validateActiveLink("CONTACTS"));
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
