package main.java.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest
{
    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest log;
    @BeforeTest
    public void beforeTestMethod()
    {
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"QA_Automation.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("QA REPORT");
        htmlReporter.config().setReportName("QA TEST RESULTS");
        htmlReporter.config().setTheme(Theme.STANDARD);
        reports= new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Tester: ","Tamilarasi N");
    }

    @BeforeMethod
    public void beforeMethod(Method testMethod)
    {
        log = reports.createTest(testMethod.getName());
       //  System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
        if(result.getStatus()==ITestResult.SUCCESS)
        {
            String methodname= result.getMethod().getMethodName();
            String logtext = "Test Case: "+ methodname +" Passed";
            Markup obj= MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
            log.log(Status.PASS,obj);
        }
        else if(result.getStatus()==ITestResult.FAILURE)
        {
            String methodname= result.getMethod().getMethodName();
            String logtext = "Test Case: "+ methodname +" Failed";
            Markup obj= MarkupHelper.createLabel(logtext, ExtentColor.RED);
            log.log(Status.FAIL,obj);
        }
        driver.quit();
    }
    @AfterTest
    public void afterTest()
    {
        reports.flush();
    }

}
