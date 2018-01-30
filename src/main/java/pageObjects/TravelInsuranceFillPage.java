package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class TravelInsuranceFillPage {

    @FindBy(name = "insured0_surname")
    WebElement insured0_surname;

    @FindBy(name = "insured0_name")
    WebElement insured0_name;

    @FindBy(name = "insured0_birthDate")
    WebElement insured0_birthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "passport_series")
    WebElement passport_series;

    @FindBy(name = "passport_number")
    WebElement passport_number;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(name = "male")
    WebElement maleSexButton;


    @FindBy(xpath = "//div[text() = 'Минимальная']/..")
    WebElement minSumPlate;

    @FindBy(xpath = "//span[text() = 'Оформить']")
    WebElement proceed;

    @FindBy(xpath = "//span[@ng-click='save()']")
    WebElement forward;

    @FindBy(xpath = "//div[text() = 'Заполнены не все обязательные поля']")
    WebElement errorMessage;

    public TravelInsuranceFillPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void clickMinSum() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(minSumPlate)).click();
    }

    public void clickProceed() {
        proceed.click();
    }
    public void clickForward(){
        forward.click();
    }

    public void setMale() {
        maleSexButton.click();
    }

    public void fill(String fieldName, String value) {
        checkElement(fieldName).clear();
        checkElement(fieldName).sendKeys(value);
    }

    public void checking(String fieldName, String value) {
        Assert.assertEquals(value, checkElement(fieldName).getAttribute("value"));
    }

    private WebElement checkElement(String fieldName) {
        WebElement element = null;
        switch (fieldName) {
            case "Фамилия Застрахованного":
                element = insured0_surname;
                break;
            case "Имя Застрахованного":
                element = insured0_name;
                break;
            case "Дата рождения Застрахованного":
                element = insured0_birthDate;
                element.click();
                break;
            case "Фамилия":
                element = surname;
                break;
            case "Имя":
                element = name;
                break;
            case "Отчество":
                element = middlename;
                break;
            case "Дата рождения":
                element = birthDate;
                element.click();
                break;
            case "Серия паспорта":
                element = passport_series;
                break;
            case "Номер паспорта":
                element = passport_number;
                break;
            case "Дата выдачи":
                element = issueDate;
                element.click();
                break;
            case "Место выдачи":
                element = issuePlace;
                break;
        }
        return element;
    }
}
