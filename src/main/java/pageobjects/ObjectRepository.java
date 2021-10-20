package main.java.pageobjects;

public interface ObjectRepository {
    String username = "username";
    String pwd = "password";
    String loginbtn = "loginButton";
    String nextpageheader = "//*[@id='content']/div[2]/div/h4";
    String isolationward = "Isolation Ward";
    String invaliusererror = "error-message";
    String RegisterPatient = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension";
    String givenname = "givenName";
    String familyName = "familyName";
    String nextbutton = "next-button";
    String male = "//*[@id=\"gender-field\"]/option[1]";
    String female = "//*[@id=\"gender-field\"]/option[2]";
    String bdayfield = "birthdateDay-field";
    String bmnthfield = "birthdateMonth-field";
    String bmnthYear = "birthdateYear-field";
    String addr1 = "address1";
    String cityVillage = "cityVillage";
    String stateProvince = "stateProvince";
    String country = "country";
    String postalCode = "postalCode";
    String phoneNumber = "phoneNumber";
    String submit = "submit";
    String homeicon = "//*[@id='breadcrumbs']/li[1]/a/i";
    String findPatient = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension";
    String searchBar="patient-search";
    String deletepatient="org.openmrs.module.coreapps.deletePatient";
    String deleteReson="delete-reason";
    String confirmpopup="//*[@id='delete-patient-creation-dialog']/div[2]/button[1]";
    String norecords="//*[@id='patient-search-results-table']/tbody/tr/td";
    String logout="//*[@id='navbarSupportedContent']/ul/li[3]/a";
    String patientlink="//*[@id='patient-search-results-table']/tbody/tr[1]";



}
