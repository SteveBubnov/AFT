package steps;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver driver;
    protected static String url;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();

        }

        url = properties.getProperty("app.url");
        System.out.println(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public static void close() throws Exception {
        driver.quit();
    }

    @Step("Переключение на вторую вкладку")
    public void stepSwitchToSecondTab(){
        new BasePage(BaseSteps.getDriver()).switchToSecondTab();
    }
    }