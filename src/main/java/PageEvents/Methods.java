package main.java.PageEvents;

import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import main.java.pageobjects.ObjectRepository;
import main.java.utils.BaseTest;
import main.java.utils.FetchingElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import test.java.OpenMRSTest;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Methods implements ObjectRepository
{
    FetchingElement ele=new FetchingElement();
    Random random = new Random();
    public void enterCredentials(String username,String pwd1)
    {

        ele.getWebElement("ID",ObjectRepository.username).sendKeys(username);
        ele.getWebElement("ID",ObjectRepository.pwd).sendKeys(pwd1);
        BaseTest.log.info("Entered Username and Password ");
        ele.getWebElement("ID",ObjectRepository.isolationward).click();
        BaseTest.log.info("Location selected - Isolation Ward!!");
    }
    public void clickLogin()
    {
        takescreenshot("login");
        ele.getWebElement("ID",ObjectRepository.loginbtn).click();
        BaseTest.log.info("Login btton clicked successfully");
    }
    public void validateAfterLogin()
    {
        BaseTest.log.info("Logged in Successfully and Next page is diplayed properly :"+BaseTest.driver.getTitle());

        Assert.assertEquals("Home", BaseTest.driver.getTitle());
    }
    public void invaliduserError()
    {
        Assert.assertEquals(true, ele.getWebElement("ID",ObjectRepository.invaliusererror).isDisplayed());
        BaseTest.log.info("Invalid Credentials - Displayed error message : "+ ele.getWebElement("ID",ObjectRepository.invaliusererror).getText());
    }
    public void ClickRegisterPatientLink()
    {
        takescreenshot("RegisterPatient");
        ele.getWebElement("ID",ObjectRepository.RegisterPatient).click();
        BaseTest.log.info("Invalid Credentials - Displayed error message : "+ ele.getWebElement("ID",ObjectRepository.invaliusererror).getText());
        takescreenshot("Registration_Page");
    }
    public void EnterNameDetails(String givenname,String famName)
    {
        WebDriverWait wait=new WebDriverWait(BaseTest.driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("givenName")));
        ele.getWebElement("NAME",ObjectRepository.givenname).sendKeys(givenname);
        ele.getWebElement("NAME",ObjectRepository.familyName).sendKeys(famName);
        BaseTest.log.info("Enter Name Details");
    }
    public void clickNextButtion()
    {
        ele.getWebElement("ID",ObjectRepository.nextbutton).click();
        BaseTest.log.info("Clicked Next Button");
    }

    public void GenderDetail(String gender)
    {
        if(gender.equalsIgnoreCase("Male")) {
            ele.getWebElement("XPATH", ObjectRepository.male).click();
            BaseTest.log.info("Selected Gender as MALE");
        }
        else
        {
            ele.getWebElement("XPATH", ObjectRepository.female).click();
            BaseTest.log.info("Selected Gender as FEMALE");
        }

    }

    public void birthdateDetails(String date,String month,String year)
    {
        ele.getWebElement("ID",ObjectRepository.bdayfield).sendKeys(date);
        ele.getWebElement("ID",ObjectRepository.bmnthfield).click();
        ele.getWebElement("ID",ObjectRepository.bmnthfield).click();
        Select dropdown = new Select( ele.getWebElement("ID",ObjectRepository.bmnthfield));
        dropdown.selectByVisibleText(month);
        ele.getWebElement("ID",ObjectRepository.bmnthYear).sendKeys(year);
        BaseTest.log.info("BirthDate Details Entered successfully");
    }
    public void addressdetails(String addr1,String city,String postal)
    {
        ele.getWebElement("ID",ObjectRepository.addr1).sendKeys(addr1);
        ele.getWebElement("ID",ObjectRepository.cityVillage).sendKeys(city);
        ele.getWebElement("ID",ObjectRepository.stateProvince).sendKeys(city);
        ele.getWebElement("ID",ObjectRepository.country).sendKeys(city);
        ele.getWebElement("ID",ObjectRepository.postalCode).sendKeys(postal);
        takescreenshot("AdressDetails");
        BaseTest.log.info("Address Details Entered successfully");

    }
    public void phoneNumber(String phone) {
        ele.getWebElement("NAME", ObjectRepository.phoneNumber).sendKeys(phone);
        BaseTest.log.info("Phone Number Entered successfully");
    }

    public void submitdetails()
    {
        ele.getWebElement("ID", ObjectRepository.submit).click();
        BaseTest.log.info("Clicked the submit button");
        takescreenshot("Submi_Patient_Details" );
    }
    public void traversetoHome()
    {
        BaseTest.driver.get("https://demo.openmrs.org/openmrs/index.htm");
    }
    public void findPatientLink()
    {
        BaseTest.driver.get("https://demo.openmrs.org/openmrs/index.htm");
        WebDriverWait wait=new WebDriverWait(BaseTest.driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
        ele.getWebElement("ID", ObjectRepository.findPatient).click();
        BaseTest.log.info("Clicked the find Patient Link");
    }
    public void searchPatient(String Firstname,String Lstname)
    {
        WebDriverWait wait=new WebDriverWait(BaseTest.driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient-search")));
        ele.getWebElement("ID", ObjectRepository.searchBar).sendKeys(Firstname+" "+Lstname);
        takescreenshot("searchPatient" );
    }
    public void retrievePatentDetails()
    {
        WebElement baseTable = BaseTest.driver.findElement(By.id("patient-search-results-table"));

        //To find third row of table
        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id='patient-search-results-table']/tbody/tr"));
        String rowtext = tableRow.getText();
        System.out.println("Patient Details : "+rowtext);
        BaseTest.log.info("Patient Details : "+rowtext);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ele.getWebElement("XPATH",ObjectRepository.patientlink).click();
    }
    public void deletePatient()
    {
        ele.getWebElement("ID",ObjectRepository.deletepatient).click();
        BaseTest.log.info("Delete Patient Link clicked successfully");
        ele.getWebElement("ID",ObjectRepository.deleteReson).sendKeys("No use");
        ele.getWebElement("XPATH",ObjectRepository.confirmpopup).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takescreenshot("DeletedPatientDetail");

    }
    public void validateDeletedPatientDetail()
    {
        BaseTest.log.info("Serching Deleted Patient : "+ ele.getWebElement("XPATH",ObjectRepository.norecords).getText());
    }

public void logout()
{

    ele.getWebElement("XPATH",ObjectRepository.logout).click();
    takescreenshot("logout");
}
public static void takescreenshot(String Methodname)
{
    String filename= System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + OpenMRSTest.testCaseName+ Methodname;
    File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(f,new File(filename+".png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    }
