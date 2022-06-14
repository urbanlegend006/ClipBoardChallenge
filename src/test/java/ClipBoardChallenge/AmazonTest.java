package ClipBoardChallenge;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazonPages.HomePage;
import amazonPages.TelevisionDepartmentPage;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTest {
    private WebDriver driver = DriverFactory.getDriver();
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

    @BeforeMethod
    public void setUp() {
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(testName = "To Assert that About this item” section is present and log this section text to console/report. ")
    public void amazonIndiaTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickHamburgerMenu();
        homePage.clickShopByDepartmentMenuByText("TV, Appliances, Electronics");
        TelevisionDepartmentPage televisionDepartmentPage = homePage.clickMenuByText("Televisions");
        televisionDepartmentPage.filterByBrands("Samsung");
        televisionDepartmentPage.sortResultsByPriceHighToLow();
        televisionDepartmentPage.clickTelevisionByOrderbyPrice(2);

        String parentWindow = driver.getWindowHandle();
        driver.getWindowHandles().forEach(w -> {
            if (! w.equals(parentWindow)) {
                driver.switchTo().window(w);
            }
        });

        WebElement aboutThisItem = televisionDepartmentPage.getAboutThisItem();
        Assert.assertTrue(aboutThisItem.getText().trim().equalsIgnoreCase("About this item"));
        String aboutThisItemSectionText = televisionDepartmentPage.getAboutThisItemSectionText();
        System.out.println(aboutThisItemSectionText);

        driver.close();
        driver.switchTo().window(parentWindow);

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing the browsers");
        driver.quit();
    }
}
