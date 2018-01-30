package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BasePage {

    public BasePage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    public void switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs.get(1));
    }


    public static boolean isElementPresent(By by) {
        try {
            BaseSteps.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
