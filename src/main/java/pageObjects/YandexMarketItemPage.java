package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class YandexMarketItemPage {



    @FindBy(xpath = "//input[@name = \"glf-pricefrom-var\"]")
    WebElement inputAreaPriceFrom;


    @FindBy(xpath = "//span[contains(text(), \"Производитель\")]/../../..//div[@class = \"n-filter-block__list-items i-bem\"]")
    WebElement manufacturer;

    @FindBy(xpath = "//button")
    WebElement button;

    @FindBy(xpath = "//div[contains(@class, \"2__hover\") ]/..")
    List<WebElement> itemGrid;

    @FindBy(xpath = "//input[@id = \"header-search\"]")
    WebElement searchBar;

    public YandexMarketItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setMinPrice(String value){
        inputAreaPriceFrom.sendKeys(value);
    }

    public void setManufacturer (String name){
        manufacturer.findElement(By.xpath(".//label[text() = '" + name + "']")).click();
    }


    //Мария, все же здесь нужна подсказка, т.к. не удается встроить скролл
    public void clickButton(String name){
       // Actions actions = new Actions(getDriver());
        //actions.moveToElement(button.findElement(By.xpath(".//span[text() = '" + name + "']"))).perform();
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button.findElement(By.xpath(".//span[text() = '" + name + "']")));
        //button.findElement(By.xpath(".//span[contains(text(), 'Применить')]")).click();
        button.findElement(By.xpath(".//span[contains(text(), '" + name + "')]/..")).click();


    }

    public void checkItemGridSize(Integer size){
        Assert.assertTrue("number of displayed items is not match", size==itemGrid.size());
    }

    public String rememberName() throws InterruptedException {
        Thread.sleep(2000);
     return itemGrid.get(0).findElement(By.xpath(".//div[contains(@class, \"title\")]/a")).getText();

    }

    public void inputRememberedValueToSearchBar(String storage){
        searchBar.sendKeys(storage);
    }

}
