package com.equifax.tests.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class book {
    @Test
    public void book (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // 1- Visit amazon.com Page
        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Search for Book 'qa testing for beginners'
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("qa testing for beginners" + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-index='1']")));

        //3. Click on 1st item in the listed results.
        driver.findElement(By.xpath("//div[@data-index='1']")).click();

        //4. Before Click on add to cart Add to Cart asset price from Step3.
        String actualPrice = driver.findElement(By.xpath("//span[@id='newBuyBoxPrice']")).getText();
        Assert.assertEquals(actualPrice, "$47.49");
        System.out.println("Actual price: "+actualPrice);

        // 5. Click on Add to Cart.
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        //6. Before Click on Proceed to Checkout asset price from Step3.
        String expectedPrice = driver.findElement(By.xpath("(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]")).getText();
        Assert.assertEquals(expectedPrice,"$47.49");
        System.out.println("Expected price :"+expectedPrice);

        Assert.assertEquals(actualPrice,expectedPrice);

        //7. Click on proceed to checkout
        driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']")).click();


        /* beginning from this line to end, since I do not pass real credentials, code will work until here.
        WebElement userName = driver.findElement(By.id("ap_email"));
        wait.until(
                ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys("Some User Name"+ Keys.ENTER);

        WebElement pwd = driver.findElement(By.id("ap_password"));
        pwd.sendKeys("Some Password" + Keys.ENTER);

        WebElement checkoutPrice = driver.findElement(By.xpath("/table[@id='subtotals-marketplace-table']//tr[1]/td[2]"));
        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutPrice));


        String expectedCheckoutPrice= checkoutPrice.getText();
        Assert.assertEquals(actualPrice, expectedCheckoutPrice);
        System.out.println("Price successfully validated in Checkout Page");
      */


    }
}