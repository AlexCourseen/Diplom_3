import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SelectedSectionIngredientTests extends BaseTest {

    private final String pageName;

    public SelectedSectionIngredientTests(String pageName) {
        this.pageName = pageName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Sauces"},
                {"Buns"},
                {"Filling"}
        };
    }

    @Test
    @DisplayName("Выполняются переходы между разделами Соусы, Начинки, Булки")
    public void testSelectedSectionIngredient() {
        switch (pageName) {
            case "Sauces":
                homePage.clickSauces();
                Assert.assertTrue(homePage.currentIsSauces());
                break;
            case "Buns":
                homePage.clickSauces();
                homePage.clickBuns();
                Assert.assertTrue(homePage.currentIsBuns());
                break;
            case "Filling":
                homePage.clickFilling();
                Assert.assertTrue(homePage.currentIsFillin());
                break;
        }
    }
}
