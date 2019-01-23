package com.esir.projet_dlc;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private WebDriver driver;
	private String URL = "http://148.60.11.117/movie/";

	@Before
	public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "/home/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void testGoOnSite() throws Exception {
		driver.get(URL + "liste");
		assertEquals(URL + "liste", driver.getCurrentUrl());
	}

	
	public void testSearch() throws Exception {
		driver.get(URL + "liste");
		WebElement element = driver.findElement(By.name("query"));
        element.sendKeys("test");
		driver.findElement(By.cssSelector("i.fa.fa-search")).click();
		assertEquals(URL + "search", driver.getCurrentUrl());
	}
	
	public void testMoviePage() throws Exception {
		driver.get(URL + "liste");
		driver.findElement(By.cssSelector(".movie:nth-child(10) a")).click();
		assertEquals(URL + "film?id=11", driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static TestSuite suite()
	{
	    return new TestSuite( AppTest.class );
	}
}


