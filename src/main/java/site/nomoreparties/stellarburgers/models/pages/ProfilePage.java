package site.nomoreparties.stellarburgers.models.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By exitButton = By.xpath(".//button[text()='Выход']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");

    @Step("Ожидание появления кнопки ВЫХОД")
    public void waitForLoadExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

    @Step("Отображается кнопка ВЫХОД")
    public boolean isDisplayedExitButton() {
        return findBy(exitButton).isDisplayed();
    }

    @Step("Кликнуть кнопку ВЫХОД")
    public void clickExitButton() {
        findBy(exitButton).click();
    }

    @Step("Кликнуть кнопку КОНСТРУКТОР")
    public void clickConstructorButton() {
        findBy(constructorButton).click();
    }

    @Step("Кликнуть кнопку логотипа")
    public void clickLogoButton() {
        findBy(logoButton).click();
    }

}
