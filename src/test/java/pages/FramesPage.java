package pages;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends CommonPage {

    @FindBy(id = "frame1")
    private WebElement frame1Element;

    @FindBy(id = "frame2")
    private WebElement frame2Element;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFrameElement;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame1(){
        frameMethods.switchToFrame(frame1Element);
    }

    public void displayContentFromFrame(){
        elementsMethods.displayElementContent(sampleHeadingFrameElement);
    }

    public void switchingToDefaultContent(){
        frameMethods.switchToDefaultContent();
    }

    public void switchToFrame2(){
        frameMethods.switchToFrame(frame2Element);
    }
}
