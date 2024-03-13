import org.junit.Assert;
import org.junit.Test;

public class OpenLoginPageTests extends BaseTest{

    @Test
    public void testGoLoginPageFromHomeByProfileButton() {
        homePage.clickProfileButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    public void testGoLoginPageFromHomeByEnterAccountButton() {
        homePage.clickEnterAccountButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    public void testGoLoginPageFromRegisterPage() {
        homePage.clickEnterAccountButton();
        loginPage.clickRegisterButton();
        registerPage.clickEnterButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    public void testGoLoginPageFromForgotPasswordPage() {
        homePage.clickEnterAccountButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickLoginButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }
}
