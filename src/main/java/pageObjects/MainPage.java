package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.BaseSteps.driver;
import static steps.BaseSteps.getDriver;


public class MainPage {

    Wait<WebDriver> wait = new WebDriverWait(getDriver(), 10, 1000);

    @FindBy(xpath = "//ul[@class =\"topmenu__list\" ]")
    WebElement mainMarketMenu;


    public MainPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    public void selectMainMenu(String menuItem){
        driver.findElement(By.xpath("//span[text() = 'Да, спасибо']/..")).click();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mainMarketMenu.findElement(By.xpath(".//*[text() =  '" + menuItem + "']"))).perform();
        //mainMarketMenu.findElement(By.xpath(".//*[text() =  '" + menuItem + "']")).click();
    }

    public void selectSubMenu(String menuItem){
        wait.until(ExpectedConditions.elementToBeClickable(mainMarketMenu.findElement(By.xpath(".//*[text() =  '" + menuItem + "']")))).click();
    }
}

