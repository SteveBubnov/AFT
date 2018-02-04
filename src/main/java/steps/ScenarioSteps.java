package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    BaseSteps baseSteps = new BaseSteps();
    MainSteps mainSteps = new MainSteps();
    TravelInsuranceInfoSteps travelInsuranceInfoSteps = new TravelInsuranceInfoSteps();
    TravelInsuranceFillSteps travelInsuranceFillSteps = new TravelInsuranceFillSteps();



    @When("^выбран пункт меню\"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран подпункт \"(.*)\"$")
    public void stepSelectSubMenu (String menuItem){
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @Then("^проверить, что заголовок окна содержит текст - Страхование путешественников")
    public void stepCheckTitle(){
        travelInsuranceInfoSteps.stepCheckTitle();
    }

    @When("^выполнено нажатие на кнопку - Оформить сейчас")
    public void stepClickSendNowButton(){
        travelInsuranceInfoSteps.stepClickSendNowButton();
    }

    @When("^открывается новая вкладка")
    public void stepSwitchToSecondTab(){
        baseSteps.stepSwitchToSecondTab();
    }

    @When("^выбрана минимальная сумма страхования")
    public void stepClickMinSum(){
        travelInsuranceFillSteps.stepClickMinSum();
    }

    @When("^нажата кнопка - продолжить")
    public void stepClickProceed(){
        travelInsuranceFillSteps.stepClickProceed();
    }

    @When("^заполняются поля:")
    public void stepFillFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> travelInsuranceFillSteps.stepFill(key, value));
    }

    @When("^указан пол - Мужской")
    public void stepSetMale(){
        travelInsuranceFillSteps.stepSetMale();
    }

    @Then("^проверяются поля:")
    public void stepCheckFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key,value) -> travelInsuranceFillSteps.stepCheck(key, value));
    }

    @When("^нажата кнопка - Далее")
    public void stepClickForward(){
        travelInsuranceFillSteps.stepClickForward();
    }

    @Then("^Проверяется наличие текста ошибки - Заполнены не все обязательные поля")
    public void stepCheckError(){
        travelInsuranceFillSteps.stepCheckError();
    }

}
