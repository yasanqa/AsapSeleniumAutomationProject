package com.equifax.tests.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private static Object Assert;

    public static void main(String[] args) {
        //1 - set up the web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //3- test if driver is working

        driver.get("https://www.amazon.com/");






    }
}
