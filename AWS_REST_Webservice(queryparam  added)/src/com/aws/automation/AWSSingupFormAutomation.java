package com.aws.automation;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AWSSingupFormAutomation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://aws.amazon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void automateAWSUsingJunit(String email) throws Exception {
    driver.get(baseUrl + "/premiumsupport/signup/");
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys(email);
    driver.findElement(By.id("ap_signin_create_radio")).click();
    driver.findElement(By.id("signInSubmit")).click();
    driver.findElement(By.id("ap_customer_name")).clear();
    driver.findElement(By.id("ap_customer_name")).sendKeys("test aws");
    driver.findElement(By.id("ap_email_check")).clear();
    driver.findElement(By.id("ap_email_check")).sendKeys(email);
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("Mayurkadu9");
    driver.findElement(By.id("ap_password_check")).clear();
    driver.findElement(By.id("ap_password_check")).sendKeys("Mayurkadu9");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.name("fullName")).clear();
    driver.findElement(By.name("fullName")).sendKeys("testt aws");
    driver.findElement(By.name("company")).clear();
    driver.findElement(By.name("company")).sendKeys("AWSTESTING");
    driver.findElement(By.name("addressLine1")).clear();
    driver.findElement(By.name("addressLine1")).sendKeys("heath street");
    driver.findElement(By.name("addressLine2")).clear();
    driver.findElement(By.name("addressLine2")).sendKeys("234");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("boston");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("02120");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("MA");
    driver.findElement(By.name("postalCode")).clear();
    driver.findElement(By.name("postalCode")).sendKeys("02120");
    driver.findElement(By.name("phoneNumber")).clear();
    driver.findElement(By.name("phoneNumber")).sendKeys("1231231234");
    driver.findElement(By.name("guess")).clear();
    driver.findElement(By.name("guess")).sendKeys("3R7JX8");
    driver.findElement(By.name("customerAgreementAccepted")).click();
    driver.findElement(By.xpath("//div[@id='ng-app']/div/div/div[5]/div/div/button")).click();
  }

  @After
  public void tearDown() throws Exception {
	 
	//Thread.sleep(1000);
	  try{
		 driver.close();
	  } catch(Exception e) {
		  System.out.println("error quiting the firefox");
	  }
    
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
      System.out.println("falied..");
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
