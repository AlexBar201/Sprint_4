package com.example.app.tests;

import com.example.app.pages.HomePageQuestions;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.example.app.pages.HomePageQuestions.*;

public class HomePageQuestionTest {

    private WebDriver driver;

    //Начинаем писать тест
    @Test
    public void QuestionsHomePageTest(){

//Создали драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/

//Перешли на страницу, где находятся вопросы
        driver.get("https://qa-scooter.praktikum-services.ru/");

//Создали объект класса страницы с выпадающими вопросами
        HomePageQuestions objQuestDrop = new HomePageQuestions(driver);

//Проверка ответов на вопросы о важном
        objQuestDrop.scrollQuestionsDropdown();
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_PAY, PANEL_ANSWER_PAY, ANSWER_ELEM_PAY);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_MULTIPLE_SCOOTERS, PANEL_ANSWER_MULTIPLE_SCOOTERS, ANSWER_ELEM_MULTIPLE_SCOOTERS);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_TIME_RENT, PANEL_ANSWER_TIME_RENT, ANSWER_ELEM_TIME_RENT);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_TODAY_RENT, PANEL_ANSWER_TODAY_RENT, ANSWER_ELEM_TODAY_RENT);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_EXTEND_RENT, PANEL_ANSWER_EXTEND_RENT, ANSWER_ELEM_EXTEND_RENT);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_CHARGING, PANEL_ANSWER_CHARGING, ANSWER_ELEM_CHARGING);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_ORDER_CANCELLATION, PANEL_ANSWER_CANCELLATION, ANSWER_ELEM_CANCELLATION);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(QUESTION_BEYOND_THE_MKAD, PANEL_ANSWER_BEYOND_THE_MKAD, ANSWER_ELEM_BEYOND_THE_MKAD);
    }
    @After
    public void tearDown() {
        if (driver != null) { //чтобы не падал тест иначе тест провален, браузер не закрывается так и не понял как исправить
            driver.quit();  // Закрытие браузера
        }
    }
}