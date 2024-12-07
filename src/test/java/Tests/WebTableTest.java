package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod(){

        // Deschidem un browser de chrome

        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

    }
}
