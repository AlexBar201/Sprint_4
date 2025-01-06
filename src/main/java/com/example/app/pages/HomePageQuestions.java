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

    //Локаторы Accordion элемента с вопросом для метода clickDropdownArrow
    public static final By QUESTION_PAY = By.id("accordion__heading-0");//"Сколько это стоит? И как оплатить?"
    public static final By QUESTION_MULTIPLE_SCOOTERS = By.id("accordion__heading-1");//"Хочу сразу несколько самокатов! Так можно?"
    public static final By QUESTION_TIME_RENT = By.id("accordion__heading-2");//"Как рассчитывается время аренды?"
    public static final By QUESTION_TODAY_RENT = By.id("accordion__heading-3");//Accordion "Можно ли заказать самокат прямо на сегодня?"
    public static final By QUESTION_EXTEND_RENT = By.id("accordion__heading-4");//Accordion "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By QUESTION_CHARGING = By.id("accordion__heading-5");//Accordion "Вы привозите зарядку вместе с самокатом?"
    public static final By QUESTION_ORDER_CANCELLATION = By.id("accordion__heading-6");//Accordion "Можно ли отменить заказ?"
    public static final By QUESTION_BEYOND_THE_MKAD = By.id("accordion__heading-7");//Accordion "Я живу за МКАДом, привезёте?"

    //Локаторы панели с текстом для метода isDropdownTextCorrect
    public static final By PANEL_ANSWER_PAY = By.id("accordion__panel-0");
    public static final By PANEL_ANSWER_MULTIPLE_SCOOTERS = By.id("accordion__panel-1");
    public static final By PANEL_ANSWER_TIME_RENT = By.id("accordion__panel-2");
    public static final By PANEL_ANSWER_TODAY_RENT = By.id("accordion__panel-3");
    public static final By PANEL_ANSWER_EXTEND_RENT = By.id("accordion__panel-4");
    public static final By PANEL_ANSWER_CHARGING = By.id("accordion__panel-5");
    public static final By PANEL_ANSWER_CANCELLATION = By.id("accordion__panel-6");
    public static final By PANEL_ANSWER_BEYOND_THE_MKAD = By.id("accordion__panel-7");

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
    public static final By SECOND_BUTTON_ORDER = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");//Кнопка, которая находится в Home RoadMap

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
    public void clickDropdownArrow(By AccordionElement) {

//Клик на вопрос
        driver.findElement(AccordionElement).click();

    }

    //Метод ожидания панели с текстом
    public void waitPanelElement(By panelElement) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelElement));
    }

    //Метод проверки выпадающего текста
    public void isDropdownTextCorrect(By panelElement, String textElement) {
        String textElementAccordion = driver.findElement(panelElement).getText();
        MatcherAssert.assertThat(textElementAccordion, is(textElement));
    }

    //Шаг "Когда нажимаешь на стрелочку, открывается соответствующий текст."
    public void checkDropdownTextOpensOnArrowClick(By AccordionElement, By panelElement, String textElement) {
        clickDropdownArrow(AccordionElement);
        waitPanelElement(panelElement);
        isDropdownTextCorrect(panelElement, textElement);
    }
}