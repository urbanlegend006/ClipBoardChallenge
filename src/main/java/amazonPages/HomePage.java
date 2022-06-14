package amazonPages;

import amazon.config.EnvFactory;
import com.typesafe.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    By hamburgerMenu = By.id("nav-hamburger-menu");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickHamburgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
    }

    public void clickShopByDepartmentMenuByText(String department) {
        wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hmenu-item']/div[text()='" + department + "']")))
            .click();
    }

    public TelevisionDepartmentPage clickMenuByText(String menu) {

        wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[@class='hmenu-item'][text()='" + menu + "']")))
            .click();
        //driver.findElement(By.xpath("//li/a[@class='hmenu-item'][text()='"+menu+"']")).click();
        return new TelevisionDepartmentPage(driver);
    }


}
