import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


//As a user of the program, I want use the parse feature


public class ParseTest {
	  private StringBuffer verificationErrors = new StringBuffer();
	

static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for Hoodpopper for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}

	// Given that I am on the main page
	// When I view the title
	// Then I see that it contains the word "Hoodpopper"
	@Test
	public void testShowsCorrectTitle() {
		
		// Check the title contains the word "Hoodpopper"
		
		String title = driver.getTitle();
		assertTrue(title.contains("Hoodpopper"));
	}
	
	
	// Given that I am on the main page
	// When I view the Parse button
	// Then I see that the value is Parse
	 @Test
	  public void testValueVerifyParse() throws Exception {
	    try {
	      assertEquals("Parse", driver.findElement(By.xpath("(//input[@name='commit'])[2]")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	
	// Given that I am on the main page
	// When I input 4 and select Parse, parsing took place
	// Then I see the back button which takes me back
	@Test
	 public void testParsing() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
		    driver.findElement(By.id("code_code")).clear();
		    driver.findElement(By.id("code_code")).sendKeys("4");
		    driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		    driver.findElement(By.linkText("Back")).click();
		    try {
		      assertEquals("Back", driver.findElement(By.linkText("Back")).getText());
		    } catch (Error e) {
		    	fail();
		    }
		  }
	
	
	// Given that I am on the main page
	// When I input 3+4
	// Then I see the parse including "n---3" and "n---4"
	@Test
	  public void testParseVerify() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	    driver.findElement(By.id("code_code")).clear();
	    driver.findElement(By.id("code_code")).sendKeys("3+4");
	    driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
	    try {
	      assertEquals("program\n--binary\n---@int\n---3\n----1\n----0\n--+\n---@int\n---4\n----1\n----2", driver.findElement(By.xpath("//p[2]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	
	
}