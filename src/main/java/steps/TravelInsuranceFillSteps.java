package steps;

import org.openqa.selenium.By;
import pageObjects.BasePage;
import pageObjects.TravelInsuranceFillPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class TravelInsuranceFillSteps {

    @Step("Выбрать вкладку - Минимальный")
    public void stepClickMinSum(){
        new TravelInsuranceFillPage(BaseSteps.getDriver()).clickMinSum();
    }

    @Step("Нажать кнопку - Продолжить")
    public void stepClickProceed(){
        new TravelInsuranceFillPage(BaseSteps.getDriver()).clickProceed();
    }

    @Step("Поле {0} заполняется значением {1}")
    public void stepFill(String fieldName, String value){
        new TravelInsuranceFillPage(BaseSteps.getDriver()).fill(fieldName, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFill);
    }

    @Step("Указывать пол - Мужской")
    public void stepSetMale(){
        new TravelInsuranceFillPage(BaseSteps.getDriver()).setMale();
    }

    @Step("В поле {0} присутсвие значения {1}")
    public void stepCheck(String fieldName, String value){
        new TravelInsuranceFillPage(BaseSteps.getDriver()).checking(fieldName, value);
    }

    @Step("Проверяются поля:")
    public void stepCheckFields(HashMap<String,String> fields){
        fields.forEach(this::stepCheck);
    }

    @Step("Нажать кнопку - Далее")
    public void stepClickForward(){
        new TravelInsuranceFillPage(BaseSteps.getDriver()).clickForward();
    }

    @Step("Проверить наличие ошибки")
    public void stepCheckError (){
        BasePage.isElementPresent(By.xpath("//div[text() = 'Заполнены не все обязательные поля']"));
    }
}
