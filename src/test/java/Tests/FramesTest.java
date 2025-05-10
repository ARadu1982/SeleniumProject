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


     HomePage homePage;
     CommonPage commonPage;
     FramesPage framesPage;

    @Test
    public void framesMethod() {

        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());
        framesPage = new FramesPage(getDriver());

        //facem un scroll
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Frames");

        framesPage.switchToFrame1();

        framesPage.displayContentFromFrame();

        framesPage.switchingToDefaultContent();

        framesPage.switchToFrame2();
    }
}
