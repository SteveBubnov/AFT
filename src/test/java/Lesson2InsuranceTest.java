import org.junit.Ignore;
import org.junit.Test;
import pageObjects.MainPage;
import pageObjects.TravelInsuranceFillPage;
import pageObjects.TravelInsuranceInfoPage;
import steps.BaseSteps;

public class Lesson2InsuranceTest extends BaseSteps {

    String insured0_nameValue = "IVAN";
    String insured0_surnameValue = "IVANOV";
    String insured0_birthDateValue = "01.01.1987";
    String nameValue = "Иван";
    String surnameValue = "Иванов";
    String middlenameValue = "Иванович";
    String birthDateValue = "01.01.1987";
    String passport_seriesValue = "1234";
    String passport_numberValue = "123456";
    String issueDateValue = "01.01.1987";
    String issuePlaceValue = "Неким ОВД ГУВД РОВД РОССИИ";

    @Ignore
    @Test
    public void insuranceTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать себя");
        Thread.sleep(500); //Подскажите, пожалуйста, как в данном случае правильно использовать явные ожидания.
        mainPage.selectSubMenu("Страхование путешественников");

        TravelInsuranceInfoPage travelInsuranceInfoPage = new TravelInsuranceInfoPage(driver);
        travelInsuranceInfoPage.checkTitle();
        travelInsuranceInfoPage.clickSendNowButton();
        switchToSecondTab();

        TravelInsuranceFillPage travelInsuranceFillPage = new TravelInsuranceFillPage(driver);
        travelInsuranceFillPage.clickMinSum();
        travelInsuranceFillPage.clickProceed();
        travelInsuranceFillPage.fill("Фамилия Застрахованного", insured0_surnameValue);
        travelInsuranceFillPage.fill("Имя Застрахованного", insured0_nameValue);
        travelInsuranceFillPage.fill("Дата рождения Застрахованного", insured0_birthDateValue);
        travelInsuranceFillPage.fill("Фамилия", surnameValue);
        travelInsuranceFillPage.fill("Имя", nameValue);
        travelInsuranceFillPage.fill("Отчество", middlenameValue);
        travelInsuranceFillPage.fill("Дата рождения", birthDateValue);
        travelInsuranceFillPage.fill("Серия паспорта", passport_seriesValue);
        travelInsuranceFillPage.fill("Номер паспорта", passport_numberValue);
        travelInsuranceFillPage.fill("Дата выдачи", issueDateValue);
        travelInsuranceFillPage.fill("Место выдачи", issuePlaceValue);

        travelInsuranceFillPage.checking("Фамилия Застрахованного", insured0_surnameValue);
        travelInsuranceFillPage.checking("Имя Застрахованного", insured0_nameValue);
        travelInsuranceFillPage.checking("Дата рождения Застрахованного", insured0_birthDateValue);
        travelInsuranceFillPage.checking("Фамилия", surnameValue);
        travelInsuranceFillPage.checking("Имя", nameValue);
        travelInsuranceFillPage.checking("Отчество", middlenameValue);
        travelInsuranceFillPage.checking("Дата рождения", birthDateValue);
        travelInsuranceFillPage.checking("Серия паспорта", passport_seriesValue);
        travelInsuranceFillPage.checking("Номер паспорта", passport_numberValue);
        travelInsuranceFillPage.checking("Дата выдачи", issueDateValue);
        travelInsuranceFillPage.checking("Место выдачи", issuePlaceValue);
    }
}
