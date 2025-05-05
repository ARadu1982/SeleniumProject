package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascripMethods javascripMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascripMethods = new JavascripMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // Identificam Web elementele specifice pentru aceasta pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    // Se creeaza metode specifice pentru pagina

    public void goToDesiredMenu(String menu){
        javascripMethods.scroll(0,400);
        elementsMethods.selectElementFromListByText(elements,menu);

    }


}
