package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsuranceInfoPage {

    @FindBy(xpath = "//div[@class = 'sbrf-rich-outer']/h1")
    WebElement travelInsuranceTitle;

    @FindBy(xpath = "//a[text() ='Оформить сейчас']")
    WebElement sendNowButton;

    @FindBy(xpath = "//a[@title ='Закрыть предупреждение']")
    WebElement cookiesAlert;

    public TravelInsuranceInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(travelInsuranceTitle));
    }

    public void checkTitle() {
        Assert.assertEquals("Страхование путешественников", travelInsuranceTitle.getText());
    }

    public void clickSendNowButton() {
        if (cookiesAlert.isDisplayed()) {
            cookiesAlert.click();
        }
        sendNowButton.click();
    }
}
