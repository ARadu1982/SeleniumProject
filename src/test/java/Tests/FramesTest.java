package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascripMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;

public class FramesTest extends ShareData {

     JavascripMethods javascriptMethods;
     ElementsMethods elementsMethods;
     FramesMethods frameMethods;
     HomePage homePage;
     CommonPage commonPage;
     FramesPage framesPage;

    @Test
    public void framesMethod() {

        elementsMethods = new ElementsMethods(driver);
        frameMethods = new FramesMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        framesPage = new FramesPage(driver);
        javascriptMethods = new JavascripMethods(driver);

        //facem un scroll
        javascriptMethods.scroll(0,400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Frames");

        framesPage.switchToFrame1();

        framesPage.displayContentFromFrame();

        framesPage.switchingToDefaultContent();

        javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        framesPage.switchToFrame2();

        javascriptMethods.executeScript("window.scrollBy(200,200)");
    }
}
