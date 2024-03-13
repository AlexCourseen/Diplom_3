package site.nomoreparties.stellarburgers.models.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By inputName = By.xpath(".//label[text()='Имя']/following-sibling::input[contains(@class,'input__textfield') and @name='name']");
    private By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input[contains(@class,'input__textfield') and @name='name']");
    private By inputPassword = By.xpath(".//input[contains(@class,'input__textfield') and @name='Пароль']");
    private By registrButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By enterButton = By.className("Auth_link__1fOlj");


    @Step("Зарегистрировать нового юзера")
    public void registerUser(String name,String email, String password) {
        findBy(inputName).clear();
        findBy(inputName).sendKeys(name);
        findBy(inputEmail).clear();
        findBy(inputEmail).sendKeys(email);
        findBy(inputPassword).clear();
        findBy(inputPassword).sendKeys(password);
        findBy(registrButton).click();
    }

    @Step("Кликнуть кнопку ВОЙТИ")
    public void clickEnterButton() {
        findBy(enterButton).click();
    }

}
