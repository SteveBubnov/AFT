package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    YandexMainSteps yandexMainSteps = new YandexMainSteps();
    YandexMarketItemSteps yandexMarketItemSteps = new YandexMarketItemSteps();
    YandexDetailedItemSteps yandexDetailedItemSteps = new YandexDetailedItemSteps();
    String storage;


    @When("выбран раздел \"(.*)\"$")
    public void stepSelectPageOnNavBar(String menuItem) {
        yandexMainSteps.stepSelectPageOnNavBar(menuItem);
    }

    @When("выбрано меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("выбран подпункт\"(.*)\"$")
    public void stepSelectSubMenu (String menuItem){
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("указана цена от \"(.*)\"$")
    public void stepSetMinPrice(String value){
        yandexMarketItemSteps.stepSetMinPrice(value);
    }

    @When("выбран производитель \"(.*)\"$")
    public void setManufacturer (String name){
        yandexMarketItemSteps.setManufacturer(name);
    }

    @When("нажата кнопка \"(.*)\"$")
    public void stepClickButton (String name) throws Throwable {
        Thread.sleep(5000);
        yandexMarketItemSteps.stepClickButton(name);
    }

    @Then("проверить, что товаров на странице \"(.*)\"$")
    public void checkItemGridSize(Integer size){
        yandexMarketItemSteps.stepCheckItemGridSize(size);
    }

    @Then("сохранено наименование первого товара")
    public void stepRememberName() throws InterruptedException{
       storage = yandexMarketItemSteps.stepRememberName();
    }

    @When("введено сохраненное значение в строку поиска")
    public void stepInputRememberedValueToSearchBar(){
        yandexMarketItemSteps.stepInputRememberedValueToSearchBar(storage);
    }

    @Then("проверено что заголовок соответствует сохраненному значению")
    public void stepCheckTitle(){
        yandexDetailedItemSteps.stepCheckTitle(storage);


    }

}
