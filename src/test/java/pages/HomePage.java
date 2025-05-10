package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonPage{


    // Identificam Web elementele specifice pentru aceasta pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Se creeaza metode specifice pentru pagina

    public void goToDesiredMenu(String menu){
        // Se face scroll inainte
        javascriptMethods.scroll(0,400);
        elementsMethods.selectElementFromListByText(elements,menu);

    }


}
