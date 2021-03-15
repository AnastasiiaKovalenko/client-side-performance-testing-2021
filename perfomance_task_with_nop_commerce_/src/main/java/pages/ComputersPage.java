package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ComputersPage extends BasePage {
    public ComputersPage() {
        super();
    }

    @FindBy(xpath = "//div[@class='page category-page']")
    private WebElement popularCategoriesBanner;

    public ComputersPage openComputersPage() {
        computersTitle.click();
        Assert.assertTrue(popularCategoriesBanner.isDisplayed());
        waitUntilPageIsFullyLoaded(wait);
        return this;
    }
}
