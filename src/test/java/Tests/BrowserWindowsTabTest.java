package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import HelperMethods.WindowsMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWebPage;
import pages.CommonPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTabTest extends ShareData {

    JavascripMethods javascriptMethods;
    ElementsMethods elementsMethods;
    WindowsMethods windowsMethods;
    HomePage homePage;
    CommonPage commonPage;
    BrowserWebPage browserWebPage;

    @Test
    public void browserWindowMethod() {

        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        browserWebPage = new BrowserWebPage(driver);

        //facem un scroll
        javascriptMethods = new JavascripMethods(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Browser Windows");

//        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
//        elementsMethods.clickOnElements(tabButtonElement);
        browserWebPage.clickTabButton();
        browserWebPage.switchToTabOpened();

        String sampleHeadingExpectedText = "This is a sample page";
        browserWebPage.assertSampleHeadingNewPage(sampleHeadingExpectedText);
        browserWebPage.closingTab();

        browserWebPage.switchingToMainTab();

        browserWebPage.clickWindowButton();
        browserWebPage.switchToTabOpened();
        browserWebPage.displayNewWindowContent();

        // inchidem window ul deschis
        browserWebPage.closingWindow();

        // facem switch pe fereastra initiala
        browserWebPage.switchingToMainTab();
    }
}
