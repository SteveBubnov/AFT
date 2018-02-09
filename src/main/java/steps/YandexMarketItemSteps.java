package steps;

import pageObjects.YandexMarketItemPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketItemSteps {

    String storage;

    @Step("В поле Цена От указать значение {0}")
    public void stepSetMinPrice(String value){
        new YandexMarketItemPage(BaseSteps.getDriver()).setMinPrice(value);
    }

    @Step("Выбрать производителя {0}")
    public void setManufacturer (String name){
        new YandexMarketItemPage(BaseSteps.getDriver()).setManufacturer(name);
    }

    @Step("Нажать кнопку {0}")
    public void stepClickButton (String name){
        new YandexMarketItemPage(BaseSteps.getDriver()).clickButton(name);
    }

    @Step("Проверить, что количество предметов на странице {0}")
    public void stepCheckItemGridSize(Integer size){
        new YandexMarketItemPage(BaseSteps.getDriver()).checkItemGridSize(size);
    }

    @Step("Запомнить значение первого элемента")
    public String stepRememberName() throws InterruptedException { return new YandexMarketItemPage(BaseSteps.getDriver()).rememberName();
    }

    @Step("Ввести в поисковую строку сохраненное значение")
    public void stepInputRememberedValueToSearchBar(String storage){
        new YandexMarketItemPage(BaseSteps.getDriver()).inputRememberedValueToSearchBar(storage);
    }
}
