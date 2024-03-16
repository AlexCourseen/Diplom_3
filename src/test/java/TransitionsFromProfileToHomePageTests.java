import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class TransitionsFromProfileToHomePageTests extends BaseTest{
    @Test
    @DisplayName("Выполняется переход на главную из личного кабинета по кнопке Конструктор")
    public void testTransitionsFromProfileToHomePageByConstructorButton() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.clickConstructorButton();
        Assert.assertTrue(homePage.isDisplayedCreateBurgerTitle());
    }

    @Test
    @DisplayName("Выполняется переход на главную из личного кабинета по Логотипу")
    public void testTransitionsFromProfileToHomePageByLogoButton() {
        regUser(newUser);
        homePage.clickProfileButton();
        loginPage.login(newUser.getEmail(), newUser.getPassword());
        homePage.clickProfileButton();
        profilePage.clickLogoButton();
        Assert.assertTrue(homePage.isDisplayedCreateBurgerTitle());
    }

}
