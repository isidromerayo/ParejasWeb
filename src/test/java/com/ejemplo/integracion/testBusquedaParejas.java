package com.ejemplo.integracion;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBusquedaParejas {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPruebaServidor() throws Exception {
		driver.get(baseUrl + "ParejasWeb/");
		assertTrue(isElementPresent(By.name("nombre")));
		assertTrue(isElementPresent(By.name("edad")));
		assertTrue(isElementPresent(By.name("altura")));
		assertTrue(isElementPresent(By.name("sexo")));
		assertTrue(isElementPresent(By.name("buscar")));
		driver.findElement(By.name("nombre")).clear();
		driver.findElement(By.name("nombre")).sendKeys("fernando");
		driver.findElement(By.name("edad")).clear();
		driver.findElement(By.name("edad")).sendKeys("79");
		driver.findElement(By.name("altura")).clear();
		driver.findElement(By.name("altura")).sendKeys("1.79");
		driver.findElement(By.name("sexo")).clear();
		driver.findElement(By.name("sexo")).sendKeys("H");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

		//Assert.assertTrue(isElementPresent(By.id("nombre")));
		//Assert.assertTrue(isElementPresent(By.id("mail")));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
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
}
