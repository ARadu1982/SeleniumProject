package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascripMethods {

    public WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public JavascripMethods(WebDriver driver) {

        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void scroll(int x, int y){

        //facem un scroll
//      js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        javascriptExecutor.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public  void executeScript(String script){
        javascriptExecutor.executeScript(script);

    }

    public void forceClick(WebElement element){
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }
}
