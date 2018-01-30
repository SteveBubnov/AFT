import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.TravelInsuranceFillSteps;
import steps.TravelInsuranceInfoSteps;

import java.util.HashMap;

public class Lesson3InsuranceTest extends BaseSteps{

    MainSteps mainSteps = new MainSteps();
    TravelInsuranceInfoSteps travelInsuranceInfoSteps = new TravelInsuranceInfoSteps();
    TravelInsuranceFillSteps travelInsuranceFillSteps = new TravelInsuranceFillSteps();

    @Test
    @Title("Ошибка валидации - Страхование путешественников")
    public void testValidateTravelInsurance(){
        HashMap<String , String> testData = new HashMap<>();
        testData.put("Фамилия Застрахованного", "IVANOV");
        testData.put("Имя Застрахованного", "IVAN");
        testData.put("Дата рождения Застрахованного", "01.01.1987");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения", "01.01.1987");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "123456");
        testData.put("Дата выдачи", "01.01.2007");
        testData.put("Место выдачи", "Неким ОВД ГУВД РОВД РОССИИ");

        mainSteps.stepSelectMainMenu("Застраховать себя");
        mainSteps.stepSelectSubMenu("Страхование путешественников");

        travelInsuranceInfoSteps.stepCheckTitle();
        travelInsuranceInfoSteps.stepСlickSendNowButton();
        switchToSecondTab();

        travelInsuranceFillSteps.stepClickMinSum();
        travelInsuranceFillSteps.stepClickProceed();
        travelInsuranceFillSteps.stepFillFields(testData);
        travelInsuranceFillSteps.stepSetMale();
        travelInsuranceFillSteps.stepCheckFields(testData);
        travelInsuranceFillSteps.stepClickForward();
        travelInsuranceFillSteps.stepCheckError();

    }
}
