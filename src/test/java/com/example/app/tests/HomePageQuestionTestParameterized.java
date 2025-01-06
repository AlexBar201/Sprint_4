package com.example.app.tests;

import com.example.app.pages.HomePageQuestions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HomePageQuestionTestParameterized {

    private WebDriver driver;

    //Создаем переменные в которых будут храниться параметры с соответствующим индексом из тестового набора
    @Parameterized.Parameter(0)
    public By accordion;
    @Parameterized.Parameter(1)
    public By panelText;
    @Parameterized.Parameter(2)
    public String textElem;

    //Создаём тестовые наборы данных в виде списка массивов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {HomePageQuestions.QUESTION_PAY, HomePageQuestions.PANEL_ANSWER_PAY, HomePageQuestions.ANSWER_ELEM_PAY},
                {HomePageQuestions.QUESTION_MULTIPLE_SCOOTERS, HomePageQuestions.PANEL_ANSWER_MULTIPLE_SCOOTERS, HomePageQuestions.ANSWER_ELEM_MULTIPLE_SCOOTERS},
                {HomePageQuestions.QUESTION_TIME_RENT, HomePageQuestions.PANEL_ANSWER_TIME_RENT, HomePageQuestions.ANSWER_ELEM_TIME_RENT},
                {HomePageQuestions.QUESTION_TODAY_RENT, HomePageQuestions.PANEL_ANSWER_TODAY_RENT, HomePageQuestions.ANSWER_ELEM_TODAY_RENT},
                {HomePageQuestions.QUESTION_EXTEND_RENT, HomePageQuestions.PANEL_ANSWER_EXTEND_RENT, HomePageQuestions.ANSWER_ELEM_EXTEND_RENT},
                {HomePageQuestions.QUESTION_CHARGING, HomePageQuestions.PANEL_ANSWER_CHARGING, HomePageQuestions.ANSWER_ELEM_CHARGING},
                {HomePageQuestions.QUESTION_ORDER_CANCELLATION, HomePageQuestions.PANEL_ANSWER_CANCELLATION, HomePageQuestions.ANSWER_ELEM_CANCELLATION},
                {HomePageQuestions.QUESTION_BEYOND_THE_MKAD, HomePageQuestions.PANEL_ANSWER_BEYOND_THE_MKAD, HomePageQuestions.ANSWER_ELEM_BEYOND_THE_MKAD}
        });
    }

    //Сам тест
    @Test
    public void testQuestionsDropdown() {
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageQuestions objQuestDrop = new HomePageQuestions(driver);

        objQuestDrop.scrollQuestionsDropdown();
        objQuestDrop.checkDropdownTextOpensOnArrowClick(accordion, panelText, textElem);
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}