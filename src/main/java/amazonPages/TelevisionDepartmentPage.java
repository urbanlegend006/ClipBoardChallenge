package amazonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TelevisionDepartmentPage {
    private WebDriver driver;
    private WebDriverWait wait;


    By sortByPrice = By.xpath("//select[@name='s']");
    By selectTV = By.xpath("//div[@data-component-type='s-search-result']");
    By aboutThisItem = By.xpath("//h1[text()=' About this item ']");
    By aboutThisItemSectionAllBullets = By.xpath("//h1[text()=' About this item ']/following-sibling::ul");

    String brandNameLocator = "//div[@class='a-section a-spacing-small']/span[text()='Brands']/ancestor::div[1]/following-sibling::ul[1]/li/span/a/span[text()='UNIQUEBRANDNAME']";

    private WebElement getBrandNameLocator(String name){
        return driver.findElement(By.xpath(brandNameLocator.replaceAll("UNIQUEBRANDNAME", name)));
    }
    public TelevisionDepartmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void filterByBrands(String brand){
        wait
            .until(ExpectedConditions.visibilityOfElementLocated(RelativeLocator.with(By.xpath("//label/i[@class='a-icon a-icon-checkbox']"))
                    .toLeftOf(getBrandNameLocator(brand)))).click();
    }

    public void sortResultsByPriceHighToLow(){
        wait.until(ExpectedConditions.elementToBeClickable(sortByPrice));
        Select select = new Select(driver.findElement(sortByPrice));
        select.selectByVisibleText("Price: High to Low");
    }

    public void clickTelevisionByOrderbyPrice(int order){
        wait.until(ExpectedConditions.elementToBeClickable(selectTV));
        driver.findElements(selectTV).get(order-1).click();
    }

    public WebElement getAboutThisItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutThisItem));
        return driver.findElement(aboutThisItem);

    }

    public String getAboutThisItemSectionText(){
        return driver.findElement(aboutThisItemSectionAllBullets).getText();
    }

}

