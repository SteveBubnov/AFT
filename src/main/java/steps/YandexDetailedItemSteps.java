package steps;

import org.junit.Assert;
import pageObjects.YandexDetailedItemPage;
import pageObjects.YandexMarketItemPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexDetailedItemSteps {

    @Step("Проверить что название заголовка соответствует сохраненному значению {0}")
    public void stepCheckTitle(String name){
        new YandexDetailedItemPage(BaseSteps.getDriver()).checkTitle(name);

    }
}
