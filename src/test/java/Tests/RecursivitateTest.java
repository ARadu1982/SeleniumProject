package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.util.List;

public class RecursivitateTest extends ShareData {

    public HomePage homePage;
    public CommonPage commonPage;

    @Test
    public void parcurgereLista(){

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");

        Actions actions = new Actions(getDriver());

        List<WebElement> list = getDriver().findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));

        for(int i=0;i<list.size()-1;i++){

            WebElement currentWebElement =  list.get(i);
            WebElement nextWebElement = list.get(i++);

            System.out.println("Numarul elementului este: "+currentWebElement.getText());

            actions.clickAndHold(currentWebElement)
                    .moveToElement(nextWebElement)
                    .release()
                    .build()
                    .perform();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
