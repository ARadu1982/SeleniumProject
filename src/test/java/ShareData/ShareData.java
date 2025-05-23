package ShareData;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    @BeforeMethod
    public void prepareBrowser(){

        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        // Deschidem un browser de chrome
        driver = new FirefoxDriver();
        //accesam o pagina web
        driver.get(configurationNode.driverConfigNode.url);

        // definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //facem browserul in modul maximize
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void clearBrowser(){

        driver.quit();
    }



}
