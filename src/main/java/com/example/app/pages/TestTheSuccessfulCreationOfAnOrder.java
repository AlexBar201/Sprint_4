package com.example.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Оформление заказа(две кнопки заказать) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class TestTheSuccessfulCreationOfAnOrder {

    private WebDriver driver;

    //Локаторы для двух кнопок "Заказать" на главной странице
    private static final By FIRST_BUTTON_ORDER = By.className("Button_Button__ra12g");//Кнопка, которая находится в заголовке страницы
    private static final By SECOND_BUTTON_ORDER = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");//Кнопка, которая находится в Home RoadMap

    //Локатор для кнопки "Далее"
    private static final By BUTTON_FURTHER = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//Кнопка "Далее" в форме "Для кого самокат"

    //Локаторы для формы "Для кого самокат"
    private static final By USER_NAME = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");//Поле "Имя"
    private static final By USER_SURNAME = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");//Поле "Фамилия"
    private static final By USER_ADDRESS = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");//Поле "Адрес куда привезти заказ"
    private static final By METRO_STATION = By.xpath(".//div[@class='Order_Form__17u6u']/div/div[@class='select-search']/div[@class='select-search__value']/input[@class='select-search__input']");//Поле "Станция метро"
    private static final By METRO_STATION_CHERKIZOVSKAY = By.xpath(".//div[@class='select-search__select']/ul[@class='select-search__options']/li[@data-index='0']/button[@class='Order_SelectOption__82bhS select-search__option']");//Выбор конкретной станции метро
    private static final By PHONE_NUMBER = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");//Поле "Телефон"
    private static final By ORDER_CONTENT = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");//Для ожидания формы

    //Локаторы для формы "Про аренду"
    private static final By WHEN_TO_BRING_THE_SCOOTER = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");
    private static final By RENTAL_PERIOD = By.className("Dropdown-placeholder");
    private static final By ORDER_CONTENT_TWO = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");//Для ожидания формы
    private static final By DATA = By.xpath(".//div[@aria-label='Choose воскресенье, 5-е января 2025 г.']");
    private static final By RENTAL_PERIOD_DAYS = By.xpath(".//div[@class='Dropdown-menu']/div[@class='Dropdown-option']");

    //Локатор для кнопки заказать в форме "Про аренду"
    private static final By BUTTON_ORDER_FINISH = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для кнопки "Да" в форме "Хотите оформить заказ?"
    private static final By BUTTON_YES_FINISH = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для окна "Заказ оформлен"
    private static final By THE_ORDER_HAS_BEEN_PLACED = By.xpath(".//div[@class='Order_Modal__YZ-d3']");

    //Конструктор класса
    public TestTheSuccessfulCreationOfAnOrder(WebDriver driver){
        this.driver = driver;
    }

    //Метод клика по кнопке FIRST_BUTTON_ORDER
    public void clickFirstButtonOrder(){
        driver.findElement(FIRST_BUTTON_ORDER).click();
    }

    //Метод клика по кнопке SECOND_BUTTON_ORDER
    public void clickSecondButtonOrder(){

//////Закрываем куки
        By cook = By.id("rcc-confirm-button");
        driver.findElement(cook).click();

//////Скролл до кнопки
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_StatusInfo__HrjoZ']/div[@class='Home_StatusDescription__3WGl5']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(SECOND_BUTTON_ORDER));

//////Клик по кнопке
        driver.findElement(SECOND_BUTTON_ORDER).click();
    }

    //Метод заполнения формы "Для кого самокат"
    public void formFillingWhoIsTheScooterFor(String name, String surname, String address, String number){

//////Ожидание формы
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_CONTENT));


//////Заполняем поле имя
        driver.findElement(USER_NAME).clear();
        driver.findElement(USER_NAME).sendKeys(name);

//////Заполняем поле фамилия
        driver.findElement(USER_SURNAME).clear();
        driver.findElement(USER_SURNAME).sendKeys(surname);

//////Заполняем поле адрес
        driver.findElement(USER_ADDRESS).clear();
        driver.findElement(USER_ADDRESS).sendKeys(address);

//////Заполняем поле станция метро
        driver.findElement(METRO_STATION).click();
        driver.findElement(METRO_STATION_CHERKIZOVSKAY).click();

//////Заполняем поле телефон
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(number);
//////Кликаем на кнопку далее
        driver.findElement(BUTTON_FURTHER).click();
    }

    //Метод заполнения формы "Про аренду"
    public void formFillingAbout(){

//////Ожидание формы
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_CONTENT_TWO));

//////Заполняем поле "Когда привезти самокат"
        driver.findElement(WHEN_TO_BRING_THE_SCOOTER).clear();
        driver.findElement(WHEN_TO_BRING_THE_SCOOTER).click();
        driver.findElement(DATA).click();

//////Поле срок аренды
        driver.findElement(RENTAL_PERIOD).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(RENTAL_PERIOD_DAYS));
        driver.findElement(RENTAL_PERIOD_DAYS).click();
        driver.findElement(BUTTON_ORDER_FINISH).click();
        driver.findElement(BUTTON_YES_FINISH).click();
    }

    //Метод для ожидания окна "Заказ оформлен"
    public void waitTheOrderHasBeenPlaced(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(THE_ORDER_HAS_BEEN_PLACED));
    }

    //Шаг для оформления заказа через кнопку FIRST_BUTTON_ORDER
    public void placingAnOrderViaTheFirstButtonOrder(String name, String surname, String address, String number){
        clickFirstButtonOrder();
        formFillingWhoIsTheScooterFor(name, surname, address, number);
        formFillingAbout();
        waitTheOrderHasBeenPlaced();
    }

    //Шаг для оформления заказа через кнопку SECOND_BUTTON_ORDER
    public void placingAnOrderViaTheSecondButtonOrder(String name, String surname, String address, String number){
        clickSecondButtonOrder();
        formFillingWhoIsTheScooterFor(name, surname, address, number);
        formFillingAbout();
        waitTheOrderHasBeenPlaced();
    }
}