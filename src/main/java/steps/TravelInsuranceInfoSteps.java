package steps;

import pageObjects.TravelInsuranceInfoPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceInfoSteps extends BaseSteps {
    TravelInsuranceInfoPage travelInsuranceInfoPage = new TravelInsuranceInfoPage(driver);

    @Step("Проверить текст заголовка")
    public void stepCheckTitle(){
        travelInsuranceInfoPage.checkTitle();
    }

    @Step("Нажать на кнопку Оформить сейчас")
    public void stepСlickSendNowButton(){
        travelInsuranceInfoPage.clickSendNowButton();
    }
}
