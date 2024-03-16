package site.nomoreparties.stellarburgers.models.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage{

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
    private By loginButton = By.className("Auth_link__1fOlj");


    @Step("Кликнуть кнопку ВОЙТИ")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
