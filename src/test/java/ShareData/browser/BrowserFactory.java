package ShareData.browser;

import ShareData.browser.service.ChromeBrowserService;
import ShareData.browser.service.EdgeBrowserService;
import ShareData.browser.service.FirefoxBrowserService;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class BrowserFactory {

    public WebDriver getBrowserFactory(){

        String CICD = System.getProperty("CICD"); // read from pom.xml
        String browser = System.getProperty("browser").toLowerCase(Locale.ROOT);

        System.out.println("CHECK HERE! "+browser);

        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        if (Boolean.parseBoolean(CICD)){
            configurationNode.driverConfigNode.headless = "--headless";
        }
        else{
            browser = configurationNode.driverConfigNode.localBrowser;
        }

        switch(browser){
            case BrowserType.BROWSER_CHROME:
                ChromeBrowserService chromeService = new ChromeBrowserService();
                chromeService.openBrowser(configurationNode.driverConfigNode);
                return  chromeService.getDriver();
            case BrowserType.BROWSER_EDGE:
                EdgeBrowserService edgeService = new EdgeBrowserService();
                edgeService.openBrowser(configurationNode.driverConfigNode);
                return  edgeService.getDriver();
            case BrowserType.BROWSER_FIREFOX:
                FirefoxBrowserService firefoxService = new FirefoxBrowserService();
                firefoxService.openBrowser(configurationNode.driverConfigNode);
                return  firefoxService.getDriver();
        }
        return null;
    }
}
