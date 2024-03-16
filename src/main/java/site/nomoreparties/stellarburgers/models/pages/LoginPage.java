package site.nomoreparties.stellarburgers.models.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By inputEmail = By.xpath(".//input[@type='text']");
    private By inputPassword = By.xpath(".//input[@type='password']");
    private By loginButton = By.className("button_button__33qZ0");
    private By registrButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    private By incorrectPassMessage = By.xpath(".//p[contains(@class,'input__error ')]");
    private By enterTitle = By.xpath(".//h2[text()='Вход']");
    private By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    @Step("Ожидание появления заголовка ВХОД")
    public void waitForLoadEnterTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(enterTitle));
    }

    @Step("Отображается заголовок ВХОД")
    public boolean isDisplayedEnterTitle() {
        return findBy(enterTitle).isDisplayed();
    }

    @Step("Клинкуть кнопку ЗАРЕГИСТРИРОВАТЬСЯ")
    public void clickRegisterButton() {
        findBy(registrButton).click();
    }

    @Step("Кликнуть кнопку ВОССТАНОВИТЬ ПАРОЛЬ")
    public void clickForgotPasswordButton() {
        findBy(forgotPasswordButton).click();
    }

    @Step("Отображается сообщение о некорректном пароле")
    public boolean isDisplayedMessageIncorrPassword() {
        return findBy(incorrectPassMessage).isDisplayed();
    }

    @Step("Авторизоваться")
    public void login(String email, String password) {
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

