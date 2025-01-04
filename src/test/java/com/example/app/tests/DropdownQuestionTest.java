package com.example.app.tests;

import com.example.app.pages.DropdownQuestions;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.example.app.pages.DropdownQuestions.*;

public class DropdownQuestionTest {

    private WebDriver driver;

    //Начинаем писать тест
    @Test
    public void QuestionsDropdownTextTest(){

//Создали драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/

//Перешли на страницу, где находятся вопросы
        driver.get("https://qa-scooter.praktikum-services.ru/");

//Создали объект класса страницы с выпадающими вопросами
        DropdownQuestions objQuestDrop = new DropdownQuestions(driver);

//Проверка ответов на вопросы о важном
        objQuestDrop.scrollQuestionsDropdown();
        objQuestDrop.checkDropdownTextOpensOnArrowClick(ONE_ACCORDION, PANEL_TEXT_ONE, TEXT_ELEM_ONE);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(TWO_ACCORDION, PANEL_TEXT_TWO, TEXT_ELEM_TWO);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(THREE_ACCORDION, PANEL_TEXT_THREE, TEXT_ELEM_THREE);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(FOUR_ACCORDION, PANEL_TEXT_FOUR, TEXT_ELEM_FOUR);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(FIVE_ACCORDION, PANEL_TEXT_FIVE, TEXT_ELEM_FIVE);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(SIX_ACCORDION, PANEL_TEXT_SIX, TEXT_ELEM_SIX);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(SEVEN_ACCORDION, PANEL_TEXT_SEVEN, TEXT_ELEM_SEVEN);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(EIGHT_ACCORDION, PANEL_TEXT_EIGHT, TEXT_ELEM_EIGHT);
    }
    @After
    public void tearDown() {
        if (driver != null) { //чтобы не падал тест иначе тест провален, браузер не закрывается так и не понял как исправить
            driver.quit();  // Закрытие браузера
        }
    }
}