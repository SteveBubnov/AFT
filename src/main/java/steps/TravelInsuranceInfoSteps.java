package steps;

import pageObjects.TravelInsuranceInfoPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceInfoSteps {

    @Step("Проверить текст заголовка")
    public void stepCheckTitle(){
        new TravelInsuranceInfoPage(BaseSteps.getDriver()).checkTitle();
    }

    @Step("Нажать на кнопку Оформить сейчас")
    public void stepClickSendNowButton(){
        new TravelInsuranceInfoPage(BaseSteps.getDriver()).clickSendNowButton();
    }
}
