package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods {

    WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(WebElement element){

        //switch focus to specific frame element
        driver.switchTo().frame(element);
    }

    public void  switchToDefaultContent(){

        //return focus to default page
        driver.switchTo().defaultContent();
    }

}
