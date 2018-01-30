package steps;

import pageObjects.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage(BaseSteps.getDriver()).selectMainMenu(menuItem);
    }

    @Step("Выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage(BaseSteps.getDriver()).selectSubMenu(menuItem);
    }
}
