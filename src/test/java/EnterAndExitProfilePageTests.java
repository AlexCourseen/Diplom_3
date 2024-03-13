import org.junit.Assert;
import org.junit.Test;

public class EnterAndExitProfilePageTests extends BaseTest{

    @Test
    public void testEnterUserProfile() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.waitForLoadExitButton();
        Assert.assertTrue(profilePage.isDisplayedExitButton());
    }

    @Test
    public void testExitFromUserProfile() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.waitForLoadExitButton();
        profilePage.clickExitButton();
        loginPage.waitForLoadEnterTitle();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }


}
