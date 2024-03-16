import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


import java.util.Random;

public class RegistrationTests extends BaseTest {
    @Test
    @DisplayName("Успешная авторизация")
    public void testSuccessRegister(){
        homePage.clickEnterAccountButton();
        loginPage.clickRegisterButton();
        registerPage.registerUser(newUser.getName(),newUser.getEmail(),newUser.getPassword());
        loginPage.waitForLoadEnterTitle();
        Assert.assertTrue(loginPage.isDisplayedEnterTitle());
    }

    @Test
    @DisplayName("Отображается сообщение при некорректном пароле менее 5 символов")
    public void testSmallPasswordMessage(){
        homePage.clickEnterAccountButton();
        loginPage.clickRegisterButton();
        String smallPassword = String.format("pass%s",  new Random().nextInt(9));
        registerPage.registerUser(newUser.getName(),newUser.getEmail(),smallPassword);
        Assert.assertTrue(loginPage.isDisplayedMessageIncorrPassword());
    }
}
