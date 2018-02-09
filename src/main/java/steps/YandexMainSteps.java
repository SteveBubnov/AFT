package steps;

import pageObjects.YandexMainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMainSteps {

    @Step("Выбрать в навигационном меню раздел {0}")
    public void stepSelectPageOnNavBar (String menuItem){
        new YandexMainPage(BaseSteps.getDriver()).selectPageOnNavBar(menuItem);
    }
}
