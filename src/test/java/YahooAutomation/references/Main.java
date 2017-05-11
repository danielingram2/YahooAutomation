package YahooAutomation.references;

import YahooAutomation.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by daniel.ingram on 20/01/2016.
 */
public class Main {

    private  static boolean initialized = false;





    public FirefoxProfile profile;
    private HomePage homePage;
    private WebDriver driver;
    private PropertyReader propertyReader;


    //browser start

    public void setUp() throws Exception {
        if (!initialized) {
            createNewDriverInstance();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);//setting the minimum wait period to 10 seconds.
            initialized = true;
        }
    }

//Selecting the browser

    private void createNewDriverInstance() {
        String browser = new PropertyReader().readProperty("browser");
        switch (browser) {
            case "firefox":
                // profile = new FirefoxProfile();
                // profile.setAssumeUntrustedCertificateIssuer(false);
                //  profile.setPreference("javascript.enabled", true);
                //  profile.setEnableNativeEvents(true);
                // profile.setPreference("webdriver.load.strategy", "fast");
                System.setProperty("webdriver.gecko.driver", "/path/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/path/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "/path/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "/path/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;


        }

    }

    //Starting the browser
    public WebDriver StartBrowser() {
        try {
            setUp();
            initializePageObjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

//Initializing pageeobjects

    private void initializePageObjects() {
        homePage = PageFactory.initElements(driver, HomePage.class);

    }

    public WebDriver WebDriver() {
        return driver;
    }

    public HomePage homePage() {
        return homePage;
    }

    public void StopBrowser() {
        if (driver != null) {
            initialized = false;
            //  driver.quit();
        }

    }


}
