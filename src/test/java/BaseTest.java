import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.config.Browser;
import site.nomoreparties.stellarburgers.models.pages.*;
import site.nomoreparties.stellarburgers.models.request.User;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static site.nomoreparties.stellarburgers.config.Api.*;

public class BaseTest extends Browser {

    protected Browser browser;
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected ProfilePage profilePage;
    protected ForgotPasswordPage forgotPasswordPage;


    private String name = String.format("userName%s", new Random().nextInt(1000));
    private String email = String.format("user_mail%s@mail.ru", new Random().nextInt(1000));
    private String password = String.format("password%s",  new Random().nextInt(1000));
    protected User newUser = new User(email,password,name);

    private RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Content-type", "application/json")
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }
    @Before
    public void setUp() {
        driver = browser.createWebDriver();
        driver.get(BASE_URI);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Step("Регистрация юзера")
    public Response regUser(User user) {
        Response response = given().spec(baseRequestSpec()).body(user).when().post(REG_USER);
        return response;
    }

    @Step("Авторизация юзера")
    public Response authUser(User user) {
        Response response = given().spec(baseRequestSpec()).body(user).when().post(AUTHORIZE);
        return response;
    }

    @Step("Удаление юзера")
    public void delUser(String accessToken) {
        given().spec(baseRequestSpec()).header("Authorization",accessToken).when().delete(USER);
    }

    @After
    public void delTestData() {
        driver.quit();
        User user = new User(newUser.getEmail(), newUser.getPassword());
        String token = authUser(user).jsonPath().getString("accessToken");
        if (token!=null) {
            delUser(token);
            token = null;
        }
    }
}
