package steps;

import org.openqa.selenium.By;
import pageObjects.TravelInsuranceFillPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class TravelInsuranceFillSteps extends BaseSteps {
    TravelInsuranceFillPage travelInsuranceFillPage = new TravelInsuranceFillPage(driver);

    @Step("Выбрать вкладку - Минимальный")
    public void stepClickMinSum(){
        travelInsuranceFillPage.clickMinSum();
    }

    @Step("Нажать кнопку - Продолжить")
    public void stepClickProceed(){
        travelInsuranceFillPage.clickProceed();
    }

    @Step("Поле {0} заполняется значением {1}")
    public void stepFill(String fieldName, String value){
        travelInsuranceFillPage.fill(fieldName, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFill);
    }

    @Step("Указывать пол - Мужской")
    public void stepSetMale(){
        travelInsuranceFillPage.setMale();
    }

    @Step("В поле {0} присутсвие значения {1}")
    public void stepCheck(String fieldName, String value){
        travelInsuranceFillPage.checking(fieldName, value);
    }

    @Step("Проверяются поля:")
    public void stepCheckFields(HashMap<String,String> fields){
        fields.forEach(this::stepCheck);
    }

    @Step("Нажать кнопку - Далее")
    public void stepClickForward(){
        travelInsuranceFillPage.clickForward();
    }

    @Step("Проверить наличие ошибки")
    public void stepCheckError (){
        isElementPresent(By.xpath("//div[text() = 'Заполнены не все обязательные поля'"));
    }
}
