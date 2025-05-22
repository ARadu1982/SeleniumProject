package pages;

import HelperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    protected WebDriver driver;
    protected ElementsMethods elementsMethods;
    protected JavascripMethods javascriptMethods;
    protected AlertMethods alertMethods;
    protected WindowsMethods windowsMethods;
    protected Actions actions;
    protected FramesMethods frameMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascripMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        this.actions = new Actions(driver);
        this.frameMethods = new FramesMethods(driver);

        PageFactory.initElements(driver, this);
    }

    // Identificam Web elementele specifice pentru sub-pagina
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // Se creeaza metode specifice pentru sub-pagina

    public void goToDesiredSubMenu(String submenu){
        javascriptMethods.scroll(0,400);
        elementsMethods.selectElementFromListByText(elements,submenu);

    }
}
