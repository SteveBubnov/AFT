import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InsuranceTets {
    WebDriver driver;
    String url = "http://www.sberbank.ru/ru/person";
    String insured0_nameValue = "IVAN";
    String insured0_surnameValue = "IVANOV";
    String insured0_birthDateValue = "01.01.1987";
    String nameValue = "Иван";
    String surnameValue = "Иванов";
    String middlenameValue = "Иванович";
    String birthDateValue = "01.01.1987";
    String passport_seriesValue = "1234";
    String passport_numberValue = "123456";
    String issueDateValue = "01.01.1987";
    String issuePlaceValue = "Неким ОВД ГУВД РОВД РОССИИ";

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Ignore
    @Test
    public void testInsuranceFormValidation() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);

        //Открытие всплывающей секции "Страховатние"
        driver.findElement(By.xpath("//div[@class = 'sbrf-div-list-inner --area bp-area header_more_nav']//a[@aria-label = 'Раздел Застраховать себя  и имущество']")).click();

        WebElement insuranceOfTravelers = driver.findElement(By.xpath("//div[@class = 'sbrf-div-list-inner --area bp-area header_more_nav']//a[text()='Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(insuranceOfTravelers)).click();

        //Проверка названия заголовка
        WebElement title = driver.findElement(By.xpath("//div[@class = 'sbrf-rich-outer']/h1"));
        wait.until(ExpectedConditions.visibilityOf(title));

        Assert.assertEquals("Страхование путешественников", title.getText());

        //Переход  к оформлению
        //Всплывающее сообщение об использовании кукис не давало нажать кнопку
        driver.findElement(By.xpath("//a[@title ='Закрыть предупреждение']")).click();

        //Кнопка "Оформить онлайн" это не кнопка, а картинка с ссылкой, поэтому оперирую кнопкой в нижней части ЭФ
        driver.findElement(By.xpath("//a[text() ='Оформить сейчас']")).click();

        //Переключение на открывшуюся вкладку
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //Выбор плитки размера премии и переход к оформлению
        WebElement minSumPad = driver.findElement(By.xpath("//div[text() = 'Минимальная']/.."));
        wait.until(ExpectedConditions.visibilityOf(minSumPad)).click();

        driver.findElement(By.xpath("//span[text() = 'Оформить']")).click();

        //Заполнене полей
        WebElement insured0_surname = driver.findElement(By.name("insured0_surname"));
        WebElement insured0_name = driver.findElement(By.name("insured0_name"));
        WebElement insured0_birthDate = driver.findElement(By.name("insured0_birthDate"));
        WebElement surname = driver.findElement(By.name("surname"));
        WebElement name = driver.findElement(By.name("name"));
        WebElement middlename = driver.findElement(By.name("middlename"));
        WebElement birthDate = driver.findElement(By.name("birthDate"));
        WebElement passport_series = driver.findElement(By.name("passport_series"));
        WebElement passport_number = driver.findElement(By.name("passport_number"));
        WebElement issueDate = driver.findElement(By.name("issueDate"));
        WebElement issuePlace = driver.findElement(By.name("issuePlace"));

        fill(insured0_surname, insured0_surnameValue);
        fill(insured0_name, insured0_nameValue);
        fill(insured0_birthDate, insured0_birthDateValue);
        fill(surname, surnameValue);
        fill(name, nameValue);
        fill(middlename, middlenameValue);
        fill(birthDate, birthDateValue);
        fill(passport_number, passport_numberValue);
        fill(passport_series, passport_seriesValue);
        fill(issueDate, issueDateValue);
        fill(issuePlace, issuePlaceValue);
        driver.findElement(By.name("male")).click();

        //Проверка заполнения полей
        checking(insured0_surname, insured0_surnameValue);
        checking(insured0_name, insured0_nameValue);
        checking(insured0_birthDate, insured0_birthDateValue);
        checking(surname, surnameValue);
        checking(name, nameValue);
        checking(middlename, middlenameValue);
        checking(birthDate, birthDateValue);
        checking(passport_number, passport_numberValue);
        checking(passport_series, passport_seriesValue);
        checking(issueDate, issueDateValue);
        checking(issuePlace, issuePlaceValue);
        Assert.assertTrue(driver.findElement(By.name("male")).isSelected());

        //Нажимаем "Продолжить"
        driver.findElement(By.xpath("//span[@ng-click='save()']")).click();

        //Видим ощибку
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Заполнены не все обязательные поля']")).isDisplayed());

    }


    @After
    public void afterMethod() {
        driver.quit();
    }

    /**
     * Методы заполнения и проверки полей
     */

    public void fill(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checking(WebElement element, String value) {
        Assert.assertEquals(value, element.getAttribute("value"));
    }
}
