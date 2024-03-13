import org.junit.Assert;
import org.junit.Test;

public class TransitionsFromProfileToHomePageTests extends BaseTest{
    @Test
    public void testTransitionsFromProfileToHomePageByConstructorButton() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.clickConstructorButton();
        Assert.assertTrue(homePage.isDisplayedCreateBurgerTitle());
    }

    @Test
    public void testTransitionsFromProfileToHomePageByLogoButton() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.clickLogoButton();
        Assert.assertTrue(homePage.isDisplayedCreateBurgerTitle());
    }

}
