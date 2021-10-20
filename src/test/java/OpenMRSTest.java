package test.java;

import main.java.PageEvents.Methods;
import main.java.utils.BaseTest;
import org.testng.annotations.Test;


public class OpenMRSTest extends BaseTest
{
    public static String testCaseName= null;
    @Test
    public void TestCase1_loginSuccess()
  {
      Methods obj= new Methods();
      testCaseName="Testcase1_";
      obj.enterCredentials("Admin","Admin123");
      obj.clickLogin();
      obj.validateAfterLogin();
  }
    @Test
    public void TestCase2_loginFailure()
    {
        Methods obj= new Methods();
        testCaseName="Testcase2_";
        obj.enterCredentials("Admin","Admin155");
        obj.clickLogin();
        obj.invaliduserError();
    }
    @Test
    public void TestCase3_Validation()
    {
        Methods obj= new Methods();
        testCaseName="Testcase3_";
        obj.enterCredentials("Admin","Admin123");
        obj.clickLogin();
        obj.validateAfterLogin();
        obj.ClickRegisterPatientLink();
        obj.EnterNameDetails("satest1","test1");
        obj.clickNextButtion();
        obj.GenderDetail("Male");
        obj.clickNextButtion();
        obj.birthdateDetails("20","March","2000");
        obj.clickNextButtion();
        obj.addressdetails("Erode","Tam","12");
        obj.clickNextButtion();
        obj.phoneNumber("0998786768");
        obj.clickNextButtion();
        obj.clickNextButtion();
        obj.submitdetails();
        obj.traversetoHome();
        obj.findPatientLink();
        obj.searchPatient("satest1","test1");
        obj.retrievePatentDetails();
        obj.deletePatient();
        obj.searchPatient("satest1","test1");
        obj.validateDeletedPatientDetail();
        obj.logout();

    }

}
