package com.adidas.pages;

import com.adidas.base.BasePage;
import com.adidas.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {


@FindBy(xpath = "//h3[@class='price-container']")
public WebElement priceText;

@FindBy(linkText = "Add to cart")
public WebElement addCart;


    public int productAdder(String category, String product, WebDriverWait wait){
        // click on any category  Laptops, Phones, Monitors
        Driver.get().findElement(By.linkText(category)).click();

        // I could not create FindBy Method for products and categories
        // Because FindBy only works with constant

        // click on any product that I provide
        Driver.get().findElement(By.linkText(product)).click();

        String[] arrayAmount = priceText.getText().split(" ");
        int listPrice= Integer.parseInt(arrayAmount[0].substring(1));

        addCart.click();

        // sometimes webpage gives no such ALert exception so we are waiting dynamically

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();

        home.click();

        return listPrice;
    }


}
