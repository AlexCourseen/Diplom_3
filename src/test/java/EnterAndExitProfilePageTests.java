import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class EnterAndExitProfilePageTests extends BaseTest{

    @Test
    @DisplayName("Вход авторизованным юзером в личный кабинет")
    public void testEnterUserProfile() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.waitForLoadExitButton();
        Assert.assertTrue(profilePage.isDisplayedExitButton());
    }

    @Test
    @DisplayName("Выход авторизованным юзером из личного кабинета")
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
