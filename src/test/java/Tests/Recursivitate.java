package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class Recursivitate {
    public WebDriver driver;

    @Test
    public void parcurgereLista(){

        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/sortable");

//        Tema  - De navigat din meniul principal si apoi din submeniu folosind cele 2 clase

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));

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
