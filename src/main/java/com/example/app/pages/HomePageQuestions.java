package com.example.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Вопросы о важном !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class HomePageQuestions {

    private WebDriver driver;

    //Локатор Accordion элемента с вопросом для метода clickDropdownArrow
    private static final By QUESTION_PAY = By.id("accordion__heading-0");//"Сколько это стоит? И как оплатить?"

    //Локаторы панели с текстом для метода isDropdownTextCorrect
    public static final String _QUESTION_PAY = "Сколько это стоит? И как оплатить?";
    public static final String _QUESTION_MULTIPLE_SCOOTERS = "Хочу сразу несколько самокатов! Так можно?";
    public static final String _QUESTION_TIME_RENT = "Как рассчитывается время аренды?";
    public static final String _QUESTION_TODAY_RENT = "Можно ли заказать самокат прямо на сегодня?";
    public static final String _QUESTION_EXTEND_RENT = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String _QUESTION_CHARGING = "Вы привозите зарядку вместе с самокатом?";
    public static final String _QUESTION_CANCELLATION = "Можно ли отменить заказ?";
    public static final String _QUESTION_BEYOND_THE_MKAD = "Я жизу за МКАДом, привезёте?";

    //Текст который должен быть в поле для метода isDropdownTextCorrect
    public static final String ANSWER_ELEM_PAY = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";//Accordion "Сколько это стоит? И как оплатить?"
    public static final String ANSWER_ELEM_MULTIPLE_SCOOTERS = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";//Accordion "Хочу сразу несколько самокатов! Так можно?"
    public static final String ANSWER_ELEM_TIME_RENT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";//Accordion "Как рассчитывается время аренды?"
    public static final String ANSWER_ELEM_TODAY_RENT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";//Accordion "Можно ли заказать самокат прямо на сегодня?"
    public static final String ANSWER_ELEM_EXTEND_RENT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";//Accordion "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final String ANSWER_ELEM_CHARGING = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";//Accordion "Вы привозите зарядку вместе с самокатом?"
    public static final String ANSWER_ELEM_CANCELLATION = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";//Accordion "Можно ли отменить заказ?"
    public static final String ANSWER_ELEM_BEYOND_THE_MKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";//Accordion "Я живу за МКАДом, привезёте?"

    //Локаторы для двух кнопок "Заказать" на главной странице
    public static final By FIRST_BUTTON_ORDER = By.className("Button_Button__ra12g");//Кнопка, которая находится в заголовке страницы
    public static final By SECOND_BUTTON_ORDER = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button[contains(@class, 'Button_Button')]");//Кнопка, которая находится в Home RoadMap

    //Локатор для куки
    public static final By Cook = By.id("rcc-confirm-button");

    //Конструктор класса
    public HomePageQuestions(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для закрытия куки
    public void closeCooke(){
        driver.findElement(Cook).click();
    }

    //Метод скролла до вопросов
    public void scrollQuestionsDropdown() {

//Закрываем куки
        closeCooke();

//Скролл до вопросов
        WebElement element = driver.findElement(QUESTION_PAY);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    //Метод клика на Accordion элемент с вопросом
    public void clickQuestion(String question){
        scrollQuestionsDropdown();
        driver.findElement(By.xpath(".//div[text() = '" + question + "']")).click();
    }

    //Метод ожидания панели с текстом
    public void waitPanelElement() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='accordion__panel' and not(@hidden)]")));
    }

    //Метод проверки выпадающего текста
    public void textQuestionCorrect(String question, String textElement){
        clickQuestion(question);
        waitPanelElement();
        String textElementAccordion = driver.findElement(By.xpath(".//div[@class='accordion__panel' and not(@hidden)]")).getText();
        MatcherAssert.assertThat(textElementAccordion, is(textElement));
    }

    //Шаг "Когда нажимаешь на стрелочку, открывается соответствующий текст."
    public void checkDropdownTextOpensOnArrowClick(String question, String textElement) {
        textQuestionCorrect(question, textElement);
    }
}