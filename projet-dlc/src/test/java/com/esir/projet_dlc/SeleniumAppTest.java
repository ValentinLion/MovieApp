package com.esir.projet_dlc;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * Unit test for simple App.
 */
public class SeleniumAppTest extends TestCase {
	private WebDriver driver;
	private String URL = "http://148.60.11.117/movie/";

	@Before
	public void setUp() throws Exception {

	    ChromeDriverManager.chromedriver().setup();
	    ChromeOptions chromeOptions = new ChromeOptions();

	    chromeOptions.addArguments("--headless");
	    driver = new ChromeDriver(chromeOptions);
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
	    return new TestSuite( SeleniumAppTest.class );
	}
}


