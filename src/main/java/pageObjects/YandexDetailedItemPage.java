package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexDetailedItemPage {

    @FindBy(xpath = "//h1")
    WebElement title;

    public YandexDetailedItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void checkTitle (String name){
        Assert.assertEquals(name, title.getText());

    }
}
