package site.nomoreparties.stellarburgers.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findBy(By element) {
        WebElement webElement = driver.findElement(element);
        return webElement;
    }
}
