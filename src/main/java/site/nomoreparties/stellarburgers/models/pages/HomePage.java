package site.nomoreparties.stellarburgers.models.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By enterAccountButton = By.className("button_button__33qZ0");
    private By profileButton = By.xpath(".//a[contains(@href, 'account')]");
    private By sauces = By.xpath(".//span[text()='Соусы']");
    private By currentIsSauces = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");
    private By currentIsBuns = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Булки']");
    private By currentIsFilling = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");

    private By buns = By.xpath(".//span[text()='Булки']");
    private By filling = By.xpath(".//span[text()='Начинки']");
    private By createBurgerTitle = By.xpath(".//h1[text()='Соберите бургер']");

    @Step("Отображается заголовок СОБЕРИТЕ БУРГЕР")
    public boolean isDisplayedCreateBurgerTitle() {
        return findBy(createBurgerTitle).isDisplayed();
    }

    @Step("Выбран раздел Соусы")
    public boolean currentIsSauces() {
        return findBy(currentIsSauces).isEnabled();
    }

    @Step("Выбран раздел Булки")
    public boolean currentIsBuns() {
        return findBy(currentIsBuns).isEnabled();
    }

    @Step("Выбран раздел Начинки")
    public boolean currentIsFillin() {
        return findBy(currentIsFilling).isEnabled();
    }

    @Step("Кликнуть кнопку ВОЙТИ В АККАУНТ")
    public void clickEnterAccountButton() {
        findBy(enterAccountButton).click();
    }

    @Step("Кликнуть кнопку ЛИЧНЫЙ КАБИНЕТ")
    public void clickProfileButton() {
        findBy(profileButton).click();
    }

    @Step("Кликнуть раздел СОУСЫ")
    public void clickSauces() {
        findBy(sauces).click();
    }
    @Step("Кликнуть раздел БУЛОЧКИ>")
    public void clickBuns() {
        findBy(buns).click();
    }
    @Step("Кликнуть раздел НАЧИНКИ>")
    public void clickFilling() {
        findBy(filling).click();
    }


}
