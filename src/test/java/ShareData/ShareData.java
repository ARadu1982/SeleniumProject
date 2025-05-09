package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    public WebDriver driver;

    @BeforeMethod
    public void prepareBrowser(){

        // Deschidem un browser de chrome
        driver = new FirefoxDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");

        // definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //facem browserul in modul maximize
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void clearBrowser(){

        driver.quit();
    }

}
