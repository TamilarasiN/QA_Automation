package main.java.utils;

import main.java.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FetchingElement
{
    public WebElement getWebElement(String identifierType,String identifierValue)
    {
        switch(identifierType)
        {
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.tagName(identifierValue));
            case "NAME":
                return BaseTest.driver.findElement(By.name(identifierValue));
            case "CLASS":
                return BaseTest.driver.findElement(By.className(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getlistofWebElements(String identifierType, String identifierValue)
    {
        switch(identifierType)
        {
            case "ID":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElements(By.xpath(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.tagName(identifierValue));
            default:
                return null;
        }
    }

}
