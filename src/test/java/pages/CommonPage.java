package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascripMethods javascripMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascripMethods = new JavascripMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // Identificam Web elementele specifice pentru sub-pagina
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // Se creeaza metode specifice pentru sub-pagina

    public void goToDesiredSubMenu(String submenu){
        javascripMethods.scroll(0,400);
        elementsMethods.selectElementFromListByText(elements,submenu);

    }
}
