package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowsMethods {

    WebDriver driver;

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToOpenTab(){

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());

        // ne mutam pe noul tab deschis
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToMainTab(){

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));

    }

    private void close(){
        driver.close();
    }

    public void closeTab(){
        close();
    }

    public void closeWindow(){
        close();
    }
}
