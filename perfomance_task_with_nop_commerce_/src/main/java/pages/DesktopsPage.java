package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DesktopsPage extends BasePage {
    public DesktopsPage() {
        super();
    }

    @FindBy(xpath = "//div[@class='page category-page']//h2[@class='title']//a[@href='/desktops']")
    private WebElement desktopsPageButton;

    @FindBy(xpath = "//h2[@class='product-title']/a")
    private List<WebElement> desktopsProductsList;

    @FindBy(xpath = "//div[@class='breadcrumb']//strong[text()]")
    private WebElement openedDesktopsTitle;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='picture']//img")
    private WebElement productImage;

    public DesktopsPage openDesktopsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsPageButton));
        desktopsPageButton.click();
        waitUntilPageIsFullyLoaded(wait);
        Assert.assertTrue(productImage.isDisplayed());
        perfNavigationTiming.writeToInflux("LaptopsPage");
        return this;
    }

    public DesktopsPage openFirstDesktop() {
        String firstLaptopInTheListName = desktopsProductsList.get(0).getText();
        desktopsProductsList.get(0).click();
        waitUntilPageIsFullyLoaded(wait);
        Assert.assertTrue(openedDesktopsTitle.getText().contains("Build your own computer"));
        perfNavigationTiming.writeToInflux("ProductPage");
        return this;
    }
}
