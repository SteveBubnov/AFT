package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static steps.BaseSteps.getDriver;


public class MainPage {
    @FindBy(xpath = "//div[@class = 'sbrf-div-list-inner --area bp-area header_more_nav']//a[contains(@aria-label, 'Раздел Застраховать себя  и имущество')]/../div[contains(@class, 'alt-menu-collapser__area_cols_3')]")
    WebElement subMenu;

    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]")
    WebElement menuInsurance;
    Wait<WebDriver> wait = new WebDriverWait(getDriver(), 10, 1000);

    public MainPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    public void selectMainMenu(String menuItem){
        menuInsurance.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String menuItem){
        wait.until(ExpectedConditions.elementToBeClickable(subMenu.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")))).click();
    }
}

