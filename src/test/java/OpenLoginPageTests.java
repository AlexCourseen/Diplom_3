import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class OpenLoginPageTests extends BaseTest{

    @Test
    @DisplayName("Переход на страницу авторизации по кнопке ВОЙТИ В АККАУНТ на главной странице")
    public void testGoLoginPageFromHomeByProfileButton() {
        homePage.clickProfileButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    @DisplayName("Переход на страницу авторизации по кнопке ЛИЧНЫЙ КАБИНЕТ")
    public void testGoLoginPageFromHomeByEnterAccountButton() {
        homePage.clickEnterAccountButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    @DisplayName("Переход на страницу авторизации по кнопке ВОЙТИ на странице регистрации")
    public void testGoLoginPageFromRegisterPage() {
        homePage.clickEnterAccountButton();
        loginPage.clickRegisterButton();
        registerPage.clickEnterButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    @DisplayName("Переход на страницу авторизации по кнопке ВОЙТИ на странице восстановления пароля")
    public void testGoLoginPageFromForgotPasswordPage() {
        homePage.clickEnterAccountButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickLoginButton();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }
}
